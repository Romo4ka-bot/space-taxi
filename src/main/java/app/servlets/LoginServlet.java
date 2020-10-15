package app.servlets;

import app.repositories.UsersDao;
import app.models.User;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

    private UsersDao usersRepository;

    @Override
    public void init() throws ServletException {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl("jdbc:postgresql://localhost:5432/space_taxi");
        hikariConfig.setDriverClassName("org.postgresql.Driver");
        hikariConfig.setUsername("postgres");
        hikariConfig.setPassword("111");
        hikariConfig.setMaximumPoolSize(20);

        HikariDataSource dataSource = new HikariDataSource(hikariConfig);
        usersRepository = new UsersDao(dataSource);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        User user = User.builder().build();

        user.setLogin(login);
        user.setPassword(password);

        String userValidate = usersRepository.authenticateUser(user);

        if (userValidate.equals("SUCCESS")) {
            request.setAttribute("login", login);
            request.getRequestDispatcher("/home.ftl").forward(request, response);
        } else {
            request.setAttribute("errMessage", userValidate);
            request.getRequestDispatcher("/login.ftl").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {}
}
