package app.servlets;

import app.models.Feed;
import app.repositories.FeedRepository;
import app.repositories.FeedRepositoryJdbcImpl;
import app.services.FeedService;
import app.services.FeedServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

public class TicketServlet extends HttpServlet {

    private FeedService feedService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        DataSource dataSource = (DataSource) config.getServletContext().getAttribute("dataSource");
        FeedRepository feedRepositoryJdbcImpl = new FeedRepositoryJdbcImpl(dataSource);
        feedService = new FeedServiceImpl(feedRepositoryJdbcImpl);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Feed feed = feedService.getFeedById(Long.parseLong(id));
        req.setAttribute("feed", feed);
        req.getRequestDispatcher("/Tickets.ftl").forward(req, resp);
    }
}
