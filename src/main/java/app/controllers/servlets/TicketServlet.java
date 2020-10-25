package app.controllers.servlets;

import app.models.Feed;
import app.models.Review;
import app.models.User;
import app.repositories.*;
import app.services.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

public class TicketServlet extends HttpServlet {

    private FeedService feedService;
    private ReviewService reviewService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        DataSource dataSource = (DataSource) config.getServletContext().getAttribute("dataSource");

        FeedRepository feedRepository = new FeedRepositoryJdbcImpl(dataSource);
        feedService = new FeedServiceImpl(feedRepository);

        UsersRepository usersRepository = new UsersRepositoryJdbcImpl(dataSource);
        UsersService usersService = new UsersServiceImpl(usersRepository);

        ReviewRepository reviewRepository = new ReviewRepositoryJdbcImpl(dataSource, usersService, feedService);
        reviewService = new ReviewServiceImpl(reviewRepository);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        Feed feed = feedService.getFeedById(Long.parseLong(id));
        req.setAttribute("feed", feed);

        List<Review> reviews = reviewService.getAllById(Long.parseLong(id));
        req.setAttribute("list", reviews);

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null) {
            req.setAttribute("user", user);
        }

        req.getRequestDispatcher("/Tickets.ftl").forward(req, resp);
    }
}
