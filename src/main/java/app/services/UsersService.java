package app.services;

import app.models.User;

public interface UsersService {

    boolean authUser(User user);

    boolean regUser(User user);

    boolean userIsExist(String login);
}
