package app.repositories;

import app.models.Review;

import java.util.List;

public interface ReviewRepository extends CrudRepository<Review> {

    List<Review> findAllByFeedId(Long feed_id);
}
