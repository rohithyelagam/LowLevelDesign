package LoggingFramework.Destination;

public class FileDestFactory extends DestFactory{

    private String outputPath;

    public FileDestFactory(String path){
        super();
        outputPath = path;
    }

    @Override
    public Destination getDestination() {
        return new FileDestination(outputPath);
    }
}
