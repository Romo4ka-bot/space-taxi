package app.controllers.servlets;

import app.models.User;
import app.repositories.UsersRepository;
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
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

public class LoginServlet extends HttpServlet {

    private UsersService usersService;


    @Override
    public void init(ServletConfig config) throws ServletException {
        DataSource dataSource = (DataSource) config.getServletContext().getAttribute("dataSource");
        UsersRepository usersRepositoryJdbcImpl = new UsersRepositoryJdbcImpl(dataSource);
        usersService = new UsersServiceImpl(usersRepositoryJdbcImpl);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        User user = usersService.authUser(login);
        String check = request.getParameter("check");


        if (user != null && user.getPassword().equals(HashPassword.hashing(password))) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
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