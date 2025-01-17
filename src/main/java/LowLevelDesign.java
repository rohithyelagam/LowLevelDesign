import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class LowLevelDesign {
    public static void main(String[] args) {

        try{

            BeanFactory factory = new ClassPathXmlApplicationContext("test.xml");

            Test t1 = (Test)factory.getBean("Test");

            t1.getId();

            System.out.println();

        }catch (Exception e){

            System.out.println(e.getMessage());

        }
    }
}
