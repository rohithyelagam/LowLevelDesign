package LoggingFramework.Destination;

public class ConsoleDestination implements Destination{
    @Override
    public void send(String message) {
        System.out.println("Console :: "+message);
    }
}
