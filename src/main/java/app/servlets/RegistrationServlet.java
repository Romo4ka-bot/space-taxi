package app.servlets;

import app.models.User;
import app.repositories.UsersDao;
import app.services.UsersService;
import app.services.UsersServiceImpl;
import app.util.HashPassword;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationServlet extends HttpServlet {

    private UsersService usersService;

    @Override
    public void init(ServletConfig config) throws ServletException {
//        ServletContext servletContext = config.getServletContext();
//        usersService = (UsersService) servletContext.getAttribute("usersService");
        UsersDao usersDao = new UsersDao();
        usersService = new UsersServiceImpl(usersDao);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String gender = req.getParameter("gender");

        User user = User.builder().build();

        user.setName(name);
        user.setSurname(surname);
        user.setLogin(login);
        user.setPassword(HashPassword.hashing(password));
        user.setGender(gender);

        boolean status = usersService.regUser(user);

        if (status) {
            req.setAttribute("login", login);
            req.getRequestDispatcher("/Home.ftl").forward(req, resp);
        } else {
            req.setAttribute("errMessage", "this user already exists");
            req.getRequestDispatcher("/Registration.ftl").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/Registration.ftl").forward(req, resp);
    }
}
