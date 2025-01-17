package RatingSystem;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TimestampStrategy implements SortStrategy{

    static class TimeStampCmp implements Comparator<Map.Entry<User, Rating>> {
        public int compare(Map.Entry<User, Rating> a,Map.Entry<User, Rating> b){
            return (a.getValue().getCreatedOn().isAfter(b.getValue().getCreatedOn())) ? 1 : -1;
        }
    }

    @Override
    public void sortAndDisplay(Product product) {
        List<Map.Entry<User, Rating>> ratings = product.getRatings().entrySet().stream().collect(Collectors.toList());

        ratings.sort(new TimeStampCmp());
        product.describeProduct();
        product.getAverage();
        for(Map.Entry<User, Rating> r : ratings){
            System.out.print("User : "+r.getKey().getName()+" ");
            r.getValue().displayRating();
        }
    }
}
