package app.services;

import app.models.Review;
import app.repositories.ReviewRepository;

import java.util.List;

public class ReviewServiceImpl implements ReviewService {
    ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> getReviewByFeedId(Long feed_id) {
        return reviewRepository.findAllByFeedId(feed_id);
    }

    @Override
    public int getReviewCountById(Long feed_id) {
        return getReviewByFeedId(feed_id).size();
    }
}
