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

//    private UsersService usersService;
//
//
//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        DataSource dataSource = (DataSource) config.getServletContext().getAttribute("dataSource");
//        UsersRepository usersRepositoryJdbcImpl = new UsersRepositoryJdbcImpl(dataSource);
//        usersService = new UsersServiceImpl(usersRepositoryJdbcImpl);
//    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        String login = request.getParameter("login");
//        String password = request.getParameter("password");
//
//        Pattern pattern = Pattern.compile("^([A-Za-z0-9_\\-\\.])+\\@([A-Za-z0-9_\\-\\.])+\\.([A-Za-z]{2,4})$");
//        Matcher matcher = pattern.matcher(login);
//        if (matcher.find()) {
//
//            User user = usersService.authUser(login);
//            String check = request.getParameter("check");
//
//            if (user != null && user.getPassword().equals(HashPassword.hashing(password))) {
//
//                HttpSession session = request.getSession();
//                session.setAttribute("user", user);
//
//                if (check != null) {
//                    Cookie cookie = new Cookie("userLogin", login);
//                    cookie.setMaxAge(60 * 60 * 24 * 365);
//                    response.addCookie(cookie);
//                }
//                request.getRequestDispatcher("/Home.ftl").forward(request, response);
//
//            } else {
//                request.setAttribute("errMessage", "Invalid user credentials");
//                request.getRequestDispatcher("/Login.ftl").forward(request, response);
//            }
//        } else {
//            request.setAttribute("errMessage", "Invalid user credentials");
//            request.getRequestDispatcher("/Login.ftl").forward(request, response);
//        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/Login.ftl").forward(req, resp);
    }
}
