package app.servlets;

import app.models.User;
import app.repositories.UsersRepository;
import app.repositories.UsersRepositoryJdbcImpl;
import app.services.UsersService;
import app.services.UsersServiceImpl;
import app.util.HashPassword;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.sql.DataSource;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/Login.ftl").forward(req, resp);
    }
}
