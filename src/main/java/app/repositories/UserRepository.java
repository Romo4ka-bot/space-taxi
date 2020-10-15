package app.repositories;

import app.models.User;

public interface UserRepository {
    String authenticateUser(User user);
    boolean registrationUser(User user);
}
