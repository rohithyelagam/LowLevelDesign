package LoggingFramework.Destination;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileDestination implements Destination{

    private File file;
    private FileOutputStream fileOutputStream;

    public FileDestination(String path){
        try{
            this.file = new File(path);
            this.fileOutputStream = new FileOutputStream(this.file);
        }catch (Exception e){
            System.out.println("Exception during file Initialization : "+e.getMessage());
        }
    }

    @Override
    public void send(String message) {
        try{
            byte[] bytesArray = message.getBytes();
            fileOutputStream.write(bytesArray);
        }catch (Exception e){
            System.out.println("Exception during file output : "+e.getMessage());
        }
    }
}
