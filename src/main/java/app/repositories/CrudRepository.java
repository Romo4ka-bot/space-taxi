package app.repositories;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T> {
    List<T> findAll();
    boolean save(T entity);
    void update(T entity);
    void delete(T entity);
}