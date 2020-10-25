package app.services;

import app.models.Review;

import java.util.List;

public interface ReviewService {

    List<Review> getReviewByFeedId(Long feed_id);

    int getReviewCountById(Long feed_id);

    void addReview(Long feed_id, Long user_id, String date, String content);
}
