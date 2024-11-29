package LoggingFramework.Destination;

public class DataBaseDestination  implements Destination{
    @Override
    public void send(String message) {
        System.out.println("Database :: "+message);
    }
}
