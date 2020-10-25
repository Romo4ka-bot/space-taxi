package app.repositories;

import app.models.Feed;

import java.util.List;

public interface FeedRepository extends CrudRepository<Feed> {

    Feed findById(Long id);

    List<Feed> findAllByIncreasePrice();

    List<Feed> findAllByDecreasePrice();
}
