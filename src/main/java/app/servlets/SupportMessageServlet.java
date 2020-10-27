package app.servlets;

import app.models.SupportMessage;
import app.models.User;
import app.repositories.SupportMessageRepository;
import app.repositories.SupportMessageRepositoryImpl;
import app.repositories.UsersRepositoryJdbcImpl;
import app.services.SupportMessageService;
import app.services.SupportMessageServiceImpl;
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
import java.text.SimpleDateFormat;
import java.util.Date;

public class SupportMessageServlet extends HttpServlet {

    private SupportMessageService supportMessageService;
    private UsersService usersService;

    @Override
    public void init(ServletConfig config) throws ServletException {

        DataSource dataSource = (DataSource) config.getServletContext().getAttribute("dataSource");
        UsersRepositoryJdbcImpl usersRepositoryJdbcImpl = new UsersRepositoryJdbcImpl(dataSource);
        usersService = new UsersServiceImpl(usersRepositoryJdbcImpl);

        SupportMessageRepository supportMessageRepository = new SupportMessageRepositoryImpl(dataSource, usersService);
        supportMessageService = new SupportMessageServiceImpl(supportMessageRepository);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        String content = req.getParameter("content");
        Long userId = null;
        String name;
        String surname;
        String email;

        if (user == null) {
            name = req.getParameter("name");
            surname = req.getParameter("surname");
            email = req.getParameter("email");

        } else {
            userId = user.getId();
            name = user.getName();
            surname = user.getSurname();
            email = user.getLogin();
        }

        System.out.println(name);
        System.out.println(surname);

        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy-MM-dd");

        String date = formatForDateNow.format(dateNow);

        SupportMessage supportMessage = SupportMessage.builder().build();
        supportMessage.setUserId(userId);
        supportMessage.setName(name);
        supportMessage.setSurname(surname);
        supportMessage.setEmail(email);
        supportMessage.setDate(date);
        supportMessage.setContent(content);

        supportMessageService.addSupportMessage(supportMessage);

        resp.sendRedirect("InfoServlet");
    }
}
