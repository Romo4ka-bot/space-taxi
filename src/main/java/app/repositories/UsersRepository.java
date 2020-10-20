package app.repositories;

import app.models.User;

public interface UsersRepository extends CrudRepository<User> {
    boolean authenticateUser(User user);
    boolean findByLogin(String login);
    User findById(Long id);
}
