package app.repositories;

import app.models.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;
import java.util.Optional;

public class UsersDao implements UsersRepository {

    private Connection connection;
    private SimpleJdbcTemplate template;

    //language=SQL
    private final String SQL_SELECT_LOG_AND_PASS = "select login, password from users";

    //language=SQL
    private final String SQL_SELECT_USER_LOG = "select * from users where login = ?";

    //language=SQL
    private final String SQL_INSERT_USER_LOG_PASS = "insert into users (login, password) " +
            "values(' ? ', ' ? ');";

    private RowMapper<User> userRowMapper = row -> User.builder()
            .id(row.getLong("id"))
            .name(row.getString("name"))
            .surname(row.getString("surname"))
            .login(row.getString("login"))
            .password(row.getString("password"))
            .gender(row.getString("gender"))
            .info(row.getString("info"))
            .build();


    public UsersDao(Connection connection) {
        this.connection = connection;
        template = new SimpleJdbcTemplate(this.connection);
    }

    @Override
    public boolean authenticateUser(User user) {
//        String login = user.getLogin();
//        String password = user.getPassword();
//
//        Connection connection = this.connection;
//        Statement statement = null;
//        ResultSet resultSet = null;
//
//        String loginDB;
//        String passwordDB;
//
//        try {
//            statement = connection.createStatement();
//            resultSet = statement.executeQuery(SQL_SELECT_LOG_AND_PASS);
//
//            if (resultSet.next()) {
//                loginDB = resultSet.getString("login");
//                passwordDB = resultSet.getString("password");
//                if (login.equals(loginDB.trim()) && password.equals(passwordDB.trim())) {
//                    return true;
//                }
//            }
//        } catch (SQLException e) {
//            throw new IllegalStateException(e);
//        } finally {
//            if (resultSet != null) {
//                try {
//                    resultSet.close();
//                } catch (SQLException e) {
//                    //ignore
//                }
//            }
//            if (statement != null) {
//                try {
//                    statement.close();
//                } catch (SQLException e) {
//                    //ignore
//                }
//            }
//            if (connection != null) {
//                try {
//                    connection.close();
//                } catch (SQLException e) {
//                    //ignore
//                }
//            }
//        }
//        return false;
        List<User> list = template.query(SQL_SELECT_LOG_AND_PASS, userRowMapper);
        return !list.isEmpty();
    }

    @Override
    public boolean registrationUser(User user) {

        String login = user.getLogin();
        String password = user.getPassword();
        String

        try (Connection connection = this.connection;
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(SQL_INSERT_USER_LOG_PASS);
            return true;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(User entity) {

    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void delete(User entity) {

    }
}
