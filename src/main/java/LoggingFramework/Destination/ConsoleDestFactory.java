package LoggingFramework.Destination;

public class ConsoleDestFactory extends DestFactory{

    @Override
    public Destination getDestination() {
        return new ConsoleDestination();
    }
}
