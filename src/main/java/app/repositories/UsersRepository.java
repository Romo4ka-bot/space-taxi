package app.repositories;

import app.models.User;

import java.util.List;

public interface UsersRepository extends CrudRepository<User> {
    User findByLogin(String login);
    User findById(Long id);
    List<User> findAll(int page, int size);
}
