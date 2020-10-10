package app.servlets;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDao {
    public String authenticateUser(LoginBean loginBean) throws SQLException {
        String userName = loginBean.getUserName();
        String password = loginBean.getPassword();

        Connection con;
        Statement statement;
        ResultSet resultSet;

        String userNameDB;
        String passwordDB;

        try {
            con = DBConnection.createConnection();
            statement = con.createStatement();
            resultSet = statement.executeQuery("select userName,password from users");

            while (resultSet.next()) {
                userNameDB = resultSet.getString("userName");
                passwordDB = resultSet.getString("password");

                if (userName.equals(userNameDB) && password.equals(passwordDB)) {
                    return "SUCCESS";
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Invalid user credentials";
    }
}
