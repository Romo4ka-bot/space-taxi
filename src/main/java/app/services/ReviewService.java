package app.services;

import app.models.Review;

import java.util.List;

public interface ReviewService {

    List<Review> getReviewByFeedId(Long feed_id);

    int getReviewCountById(Long feed_id);

    void addReview(Review review);

    List<Review> getAllById(Long feed_id);
}
