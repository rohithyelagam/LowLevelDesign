package RatingSystem;

import java.util.HashMap;
import java.util.Map;

public class Product {
    private Integer id;
    private String name;
    private Map<User, Rating> ratings;
    private Double totalRatings;

    public Map<User, Rating> getRatings() {
        return ratings;
    }

    public Product(Integer id, String name){
        this.id = id;
        this.name = name;
        this.totalRatings = (double) 0;
        this.ratings = new HashMap<>();
    }

    public void addRating(User user, Rating rating){
        ratings.put(user, rating);
        this.totalRatings += rating.getRating();
        System.out.println("Rating added.....!");
    }

    public void removeRating(User user, Rating rating){
        ratings.remove(user,rating);
        this.totalRatings -= rating.getRating();
        System.out.println("Rating deleted.......!");
    }

    public void describeProduct(){
        System.out.println("ProductId: "+id+"  Product : "+this.name);
    }

    public void getAverage(){
        if(ratings.isEmpty()){
            System.out.println("Product not yet rated!");
            return;
        }
        System.out.println("Average rating of "+this.name+" : "+(this.totalRatings/(double)this.ratings.size()));
    }

}
