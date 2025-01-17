package RatingSystem;

public class Client {
    public static void main(String[] args) {

        Marketplace amazon = new Marketplace();

        User rohith  = new User(1, "Rohith");
        User supriya  = new User(2, "Supriya");
        User jessey  = new User(3, "Jessey");

        Product redBull = new Product(1,"RedBull");

        amazon.addProduct(redBull);

        amazon.rate(rohith, redBull, 8, "RedBull gives you wings..!");
        amazon.rate(supriya,redBull, 10,"Really the redBull is giving wings....!");
        amazon.rate(jessey, redBull, 2,"Its is not good for your health....!");

        amazon.display(redBull);

        amazon.setSortingStrategy(new RatingStrategy());

        amazon.display(redBull);


    }
}
