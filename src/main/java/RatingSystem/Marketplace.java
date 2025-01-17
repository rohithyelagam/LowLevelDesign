package RatingSystem;

import org.apache.kafka.common.metrics.stats.Rate;

import java.util.ArrayList;
import java.util.List;

public class Marketplace {

    List<Product> products;
    private SortStrategy strategy;

    Marketplace(){
        products = new ArrayList<>();
        strategy = new TimestampStrategy();
    }

    public void addProduct(Product product){
        this.products.add(product);
    }

    public void rate(User user, Product product, Integer rateValue, String review){
        Rating rating = new Rating(rateValue, review);
        product.addRating(user,rating);
    }

    public void setSortingStrategy(SortStrategy strategy){
        this.strategy = strategy;
    }

    public void display(Product product){
        this.strategy.sortAndDisplay(product);
    }

}
