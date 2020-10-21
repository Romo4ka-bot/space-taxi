package app.servlets;

import app.models.Feed;
import app.repositories.FeedRepositoryJdbcImpl;
import app.repositories.ReviewRepositoryJdbcImpl;
import app.repositories.UsersRepositoryJdbcImpl;
import app.services.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

public class FeedServlet extends HttpServlet {

    private FeedService feedService;
    private ReviewService reviewService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        DataSource dataSource = (DataSource) config.getServletContext().getAttribute("datasource");
        FeedRepositoryJdbcImpl feedRepositoryJdbcImpl = new FeedRepositoryJdbcImpl(dataSource);
        ReviewRepositoryJdbcImpl reviewRepositoryJdbcImpl = new ReviewRepositoryJdbcImpl(dataSource, new UsersServiceImpl(new UsersRepositoryJdbcImpl(dataSource)), feedService);
        feedService = new FeedServiceImpl(feedRepositoryJdbcImpl);
        reviewService = new ReviewServiceImpl(reviewRepositoryJdbcImpl);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Feed> list = feedService.getListOfFeeds();

        int count = reviewService.getReviewByFeedId();

                req.setAttribute("list", list);
        req.getRequestDispatcher("/Feed.ftl").forward(req, resp);
    }
}
