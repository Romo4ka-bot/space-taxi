package app.servlets;

import app.models.User;
import app.repositories.UsersDao;
import app.services.UsersService;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(urlPatterns = "RegistrationServlet")
public class RegistrationServlet extends HttpServlet {

    private UsersService usersService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext servletContext = config.getServletContext();
        usersService = (UsersService) servletContext.getAttribute("usersService");
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        User user = User.builder().build();

        user.setLogin(login);
        user.setPassword(password);

        boolean status = usersService.regUser(user);
        if (status) {
            req.setAttribute("login", login);
            req.getRequestDispatcher("/Home.ftl").forward(req, resp);
        }else  {
            req.setAttribute("errMessage", "this user already exists");
            req.getRequestDispatcher("/Registration.ftl").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/Registration.ftl").forward(req, resp);
    }
}
