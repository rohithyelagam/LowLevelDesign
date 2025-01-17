package ContainerDemo;

@Bean
public class Car {
    private String model;

    @Inject()
    private Engine engine;

    public Car(){
        this.model = "TATA Nexon";
    }

    public void getCar(){
        System.out.println("CarName:"+this.model+"  EngineModel:"+this.engine.getName());
    }
}
