package app.controllers.servlets;

import app.models.User;
import app.services.FeedService;
import app.services.ReviewService;
import app.services.UsersService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReviewServlet extends HttpServlet {

    ReviewService reviewService;
    UsersService usersService;
    FeedService feedService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        reviewService = (ReviewService) config.getServletContext().getAttribute("reviewService");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        String content = req.getParameter("comment");
        Long feed_id = Long.parseLong(req.getParameter("id"));

        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy-MM-dd");
        String date = formatForDateNow.format(dateNow);

        reviewService.addReview(feed_id, user.getId(), date, content);


    }
}
