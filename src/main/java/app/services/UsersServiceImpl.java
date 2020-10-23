package app.services;


import app.models.User;
import app.repositories.UsersRepository;

public class UsersServiceImpl implements UsersService {

    private UsersRepository usersRepository;

    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public boolean authUser(User user) {
        return usersRepository.authenticateUser(user);
    }

    @Override
    public boolean regUser(User user) {
        if (userIsExist(user.getLogin())) {
            usersRepository.save(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean userIsExist(String login) {
        return usersRepository.findByLogin(login);
    }

    @Override
    public User getUserById(Long user_id) {
        return usersRepository.findById(user_id);
    }
}
