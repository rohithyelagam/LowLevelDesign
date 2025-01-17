package ContainerDemo;

@Bean
public class Driver {

    @Inject
    private static Car car;

    public static void main(String[] args) {

        Container container = new Container("ContainerDemo");

        car.getCar();
    }
}
