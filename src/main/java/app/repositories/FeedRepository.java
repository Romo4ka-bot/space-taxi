package app.repositories;

import app.models.Feed;

public interface FeedRepository extends CrudRepository<Feed> {
    Feed findById(Long id);
}
