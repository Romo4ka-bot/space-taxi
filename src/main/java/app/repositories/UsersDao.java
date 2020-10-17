package app.repositories;

import app.models.User;
import java.util.List;

public class UsersDao implements UsersRepository {

    private SimpleJdbcTemplate template;

    //language=SQL
    private final String SQL_SELECT_LOG_AND_PASS = "select * from users where login = ? and password = ?";

    //language=SQL
    private final String SQL_SELECT_USER_LOG = "select * from users where login = ?";

    //language=SQL
    private final String SQL_INSERT_USER = "insert into users(name, surname, login, password, gender) " +
            "values(?, ?, ?, ?, ?);";

    private RowMapper<User> userRowMapper = row -> User.builder()
            .id(row.getLong("id"))
            .name(row.getString("name"))
            .surname(row.getString("surname"))
            .login(row.getString("login"))
            .password(row.getString("password"))
            .gender(row.getString("gender"))
            .info(row.getString("info"))
            .build();


    public UsersDao() {
        template = new SimpleJdbcTemplate();
    }

    @Override
    public boolean authenticateUser(User entity) {

        String login = entity.getLogin();
        String password = entity.getPassword();
        List<User> list = template.query(SQL_SELECT_LOG_AND_PASS, userRowMapper, login, password);
        return !list.isEmpty();
    }

    @Override
    public boolean findByLogin(String login) {
        List<User> list = template.query(SQL_SELECT_USER_LOG, userRowMapper, login);
        return list.isEmpty();
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public boolean save(User entity) {

        String name = entity.getName();
        String surname = entity.getSurname();
        String login = entity.getLogin();
        String password = entity.getPassword();
        String gender = entity.getGender();

        boolean ex = findByLogin(login);

        if (ex) {
            template.update(SQL_INSERT_USER, name, surname, login, password, gender);
        }

        return ex;
    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void delete(User entity) {

    }
}
