package app.servlets;

import app.models.User;
import app.repositories.UsersRepositoryJdbcImpl;
import app.services.UsersService;
import app.services.UsersServiceImpl;
import app.util.HashPassword;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegistrationServlet extends HttpServlet {

    private UsersService usersService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        DataSource dataSource = (DataSource) config.getServletContext().getAttribute("dataSource");
        UsersRepositoryJdbcImpl usersRepositoryJdbcImpl = new UsersRepositoryJdbcImpl(dataSource);
        usersService = new UsersServiceImpl(usersRepositoryJdbcImpl);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("first_name");
        String surname = req.getParameter("second_name");
        String login = req.getParameter("email");
        String gender = req.getParameter("gender");
        String password = req.getParameter("password1");

        User user = User.builder().build();

        user.setName(name);
        user.setSurname(surname);
        user.setLogin(login);
        user.setGender(gender);
        user.setPassword(HashPassword.hashing(password));

        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy");

        String date = formatForDateNow.format(dateNow);
        user.setDateRegistration(date);

        boolean status = usersService.regUser(user);

        if (status) {
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
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
