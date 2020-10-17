package app.servlets;

import app.models.User;
import app.repositories.UsersDao;
import app.services.UsersService;
import app.services.UsersServiceImpl;
import app.util.HashPassword;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

    private UsersService usersService;


    @Override
    public void init(ServletConfig config) throws ServletException {
//        ServletContext servletContext = config.getServletContext();
//        usersService = (UsersService) servletContext.getAttribute("usersService");
        UsersDao usersDao = new UsersDao();
        usersService = new UsersServiceImpl(usersDao);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        User user = User.builder().build();

        user.setLogin(login);
        user.setPassword(HashPassword.hashing(password));

        boolean userValidate = usersService.authUser(user);

        if (userValidate) {
            request.setAttribute("login", login);
            request.getRequestDispatcher("/Home.ftl").forward(request, response);
        } else {
            request.setAttribute("errMessage", "Invalid user credentials");
            request.getRequestDispatcher("/Login.ftl").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {}
}
