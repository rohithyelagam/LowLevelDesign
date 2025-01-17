package ContainerDemo;

@Bean
public class Engine {
    private String name;

    public Engine(){
        this.name = "V6 Engine";
    }

    public String getName(){
        return this.name;
    }
}
