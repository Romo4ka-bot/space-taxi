package app.services;


import app.models.User;
import app.repositories.UsersDao;

public class UsersServiceImpl implements UsersService {

    private UsersDao usersDao;

    public UsersServiceImpl(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    @Override
    public boolean authUser(User user) {
        return usersDao.authenticateUser(user);
    }

    @Override
    public boolean regUser(User user) {
        return usersDao.registrationUser(user);
    }
}
