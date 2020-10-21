package app.servlets;

import app.models.User;
import app.repositories.UsersRepositoryJdbcImpl;
import app.services.UsersService;
import app.services.UsersServiceImpl;
import app.util.HashPassword;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class LoginServlet extends HttpServlet {

    private UsersService usersService;


    @Override
    public void init(ServletConfig config) throws ServletException {
        DataSource dataSource = (DataSource) config.getServletContext().getAttribute("datasource");
        UsersRepositoryJdbcImpl usersRepositoryJdbcImpl = new UsersRepositoryJdbcImpl(dataSource);
        usersService = new UsersServiceImpl(usersRepositoryJdbcImpl);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        User user = User.builder().build();

        user.setLogin(login);
//        user.setPassword(HashPassword.hashing(password));
        user.setPassword(password);

        boolean userValidate = usersService.authUser(user);
        String check = request.getParameter("check");
        System.out.println(check);

        if (userValidate) {
            request.setAttribute("login", login);
            request.getRequestDispatcher("/Home.ftl").forward(request, response);
        } else {
            request.setAttribute("errMessage", "Invalid user credentials");
            request.getRequestDispatcher("/Login.ftl").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/Login.ftl").forward(req, resp);
    }
}
