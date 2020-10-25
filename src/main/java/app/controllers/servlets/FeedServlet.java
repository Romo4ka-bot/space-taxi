package app.controllers.servlets;

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
import java.util.ArrayList;
import java.util.List;

public class FeedServlet extends HttpServlet {

    private FeedService feedService;
    private ReviewService reviewService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        DataSource dataSource = (DataSource) config.getServletContext().getAttribute("dataSource");
        FeedRepositoryJdbcImpl feedRepositoryJdbcImpl = new FeedRepositoryJdbcImpl(dataSource);
        ReviewRepositoryJdbcImpl reviewRepositoryJdbcImpl = new ReviewRepositoryJdbcImpl(dataSource, new UsersServiceImpl(new UsersRepositoryJdbcImpl(dataSource)), feedService);
        feedService = new FeedServiceImpl(feedRepositoryJdbcImpl);
        reviewService = new ReviewServiceImpl(reviewRepositoryJdbcImpl);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String search = req.getParameter("search");
        String sorting = req.getParameter("sorting");

        List<Feed> feeds = new ArrayList<>();
        if (search == null) {
            switch (sorting) {
                case "normal":
                    feeds = feedService.getAll();
                    break;
                case "priceIncrease":
                    feeds = feedService.getAllByIncreasePrice();
                    break;
                case "priceDecrease":
                    feeds = feedService.getAllByDecreasePrice();
                    break;
            }
        }

        req.setAttribute("list", feeds);
        resp.sendRedirect("FeedServlet");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Feed> feeds = (List<Feed>) req.getAttribute("list");

        if (feeds == null) {
            List<Feed> list = feedService.getAll();
            req.setAttribute("list", list);

        } else
            req.setAttribute("list", feeds);

            req.getRequestDispatcher("/Feed.ftl").forward(req, resp);
    }
}
