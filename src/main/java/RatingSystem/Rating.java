package RatingSystem;

import java.time.LocalDateTime;

public class Rating {

    private LocalDateTime createdOn;
    private Integer rating;
    private String review;

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public Integer getRating() {
        return rating;
    }

    public String getReview() {
        return review;
    }

    public Rating(Integer rating, String review){
        this.createdOn = LocalDateTime.now();
        this.rating = rating;
        this.review = review;
    }

    public void displayRating(){
        System.out.println(this.createdOn+" Rating:"+this.rating+", Review:"+this.review);
    }
}
