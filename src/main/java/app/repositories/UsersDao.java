package app.repositories;

import app.models.User;

import javax.servlet.RequestDispatcher;
import javax.sql.DataSource;
import java.sql.*;

public class UsersDao implements UserRepository {

    private DataSource dataSource;

    private RowMapper<User> userRowMapper = row -> User.builder()
            .id(row.getLong("id"))
            .name(row.getString("name"))
            .surname(row.getString("surname"))
            .login(row.getString("login"))
            .password(row.getString("password"))
            .age(row.getInt("age"))
            .build();

    public UsersDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public String authenticateUser(User user) {
        String login = user.getLogin();
        String password = user.getPassword();

        Connection connection;
        Statement statement;
        ResultSet resultSet;

        String loginDB;
        String passwordDB;

        try {
            connection = dataSource.getConnection();
            statement = connection.createStatement();
            //language=SQL
            String SQL_SELECT_LOG_AND_PASS = "select login, password from users";
            resultSet = statement.executeQuery(SQL_SELECT_LOG_AND_PASS);

            if (resultSet.next()) {
                loginDB = resultSet.getString("login");
                passwordDB = resultSet.getString("password");
                if (login.equals(loginDB.trim()) && password.equals(passwordDB.trim())) {
                    return "SUCCESS";
                }
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        return "Invalid user credentials";
    }

    @Override
    public boolean registrationUser(User user) {
        String login = user.getLogin();
        String password = user.getPassword();

        Connection connection;
        Statement statement;
        ResultSet resultSet;

        try {
            connection = dataSource.getConnection();
            statement = connection.createStatement();
            //language=SQL
            String SQL_SELECT_LOG = "select * from users where login = " + login;
            resultSet = statement.executeQuery(SQL_SELECT_LOG);

            if (!resultSet.next()) {

                //language=SQL
                String SQL_INSERT_USER = "insert into users (login, password) " +
                        "values('"+ login +"', '"+ password +"');";
                Statement statement1 = connection.createStatement();
                statement1.executeUpdate(SQL_INSERT_USER);
                return true;
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        return false;
    }


}
