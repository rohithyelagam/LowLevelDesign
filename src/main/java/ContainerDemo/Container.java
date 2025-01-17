package ContainerDemo;

import java.io.File;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class Container {

    private Map<Class<?>, Object> container;

    public Container(String packageName){
        container = new HashMap<>();
        String path = packageName.replace('.','/');
        loadClasses(path);
    }

    private void loadClasses(String path){
        try{
            File directory = new File(Thread.currentThread().getContextClassLoader().getResource(path).getFile());
            File[] files = directory.listFiles();
            assert files != null;
            for(File file : files){
                if(file.isFile() && file.getName().endsWith(".class")){
                    String classPath = path+"."+file.getName().substring(0,file.getName().length()-6);
                    Class<?> currClass = Class.forName(classPath);

                    if(currClass.isAnnotationPresent(Bean.class)){
                        container.put(currClass, currClass.getDeclaredConstructor().newInstance());
                    }

                }
            }

            for(File file : files){
                if(file.isFile() && file.getName().endsWith(".class")){
                    String classPath = path+"."+file.getName().substring(0,file.getName().length()-6);
                    Class<?> currClass = Class.forName(classPath);

                    Field[] fields = currClass.getDeclaredFields();

                    for(Field field: fields){
                        if(field.isAnnotationPresent(Inject.class)){
                            Class<?> currFieldType = field.getType();
                            Object currObject = container.get(currClass);
                            Object feildObject = container.get(currFieldType);
                            field.setAccessible(true);
                            field.set(currObject, feildObject);
                        }
                    }

                }
            }

        }catch (Exception e){
            System.out.println("Exception during loadClasses : "+e.getMessage());
        }
    }

}
