package app.services;

import app.repositories.ReviewRepository;

public class ReviewServiceImpl implements ReviewService {
    ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }
}
