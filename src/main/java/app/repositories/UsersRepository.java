package app.repositories;

import app.models.User;

public interface UsersRepository extends CrudRepository<User> {
    User authenticateUser(String login);
    boolean findByLogin(String login);
    User findById(Long id);
}
