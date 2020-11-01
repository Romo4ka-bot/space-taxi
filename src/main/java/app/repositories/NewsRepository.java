package app.repositories;

import app.models.News;

public interface NewsRepository extends CrudRepository<News> {

    News findById(Long id);

    @Override
    default void update(News entity) {

    }
}
