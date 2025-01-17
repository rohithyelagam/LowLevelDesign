package RatingSystem;

import java.util.*;
import java.util.stream.Collectors;

public class RatingStrategy implements SortStrategy{

    static class RatingCmp implements Comparator<Map.Entry<User, Rating>> {
        public int compare(Map.Entry<User, Rating> a,Map.Entry<User, Rating> b){
            return (a.getValue().getRating() > b.getValue().getRating()) ? 1 : -1;
        }
    }

    @Override
    public void sortAndDisplay(Product product) {
        List<Map.Entry<User, Rating>> ratings = product.getRatings().entrySet().stream().collect(Collectors.toList());

        ratings.sort(new RatingCmp());
        product.describeProduct();
        product.getAverage();
        for(Map.Entry<User, Rating> r : ratings){
            System.out.print("User : "+r.getKey().getName()+" ");
            r.getValue().displayRating();
        }
    }
}
