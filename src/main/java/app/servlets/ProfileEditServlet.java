package app.servlets;

import app.models.User;
import app.repositories.UsersRepository;
import app.repositories.UsersRepositoryJdbcImpl;
import app.services.UsersService;
import app.services.UsersServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.io.IOException;

public class ProfileEditServlet extends HttpServlet {

    private UsersService usersService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        DataSource dataSource = (DataSource) config.getServletContext().getAttribute("dataSource");
        UsersRepository usersRepositoryJdbcImpl = new UsersRepositoryJdbcImpl(dataSource);
        usersService = new UsersServiceImpl(usersRepositoryJdbcImpl);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String date = req.getParameter("date");
        String gender = req.getParameter("gender");
        String info = req.getParameter("info");

        System.out.println(date);
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        if (name != null)
            user.setName(name);
        if (surname != null)
            user.setSurname(surname);
        if (date != null)
            user.setDateBirthday(date);

        user.setGender(gender);
        user.setInfo(info);

        req.setAttribute("user", user);

        usersService.updateUser(user);
        session.setAttribute("user", user);
        req.getRequestDispatcher("/Profile.ftl").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        req.setAttribute("user", user);
        req.getRequestDispatcher("/Profile_edit.ftl").forward(req, resp);
    }
}
