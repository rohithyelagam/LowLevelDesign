package LoggingFramework.Destination;

public class DataBaseDestFactory extends DestFactory{

    public DataBaseDestFactory(){
        super();
    }

    @Override
    public Destination getDestination() {
        return new DataBaseDestination();
    }
}
