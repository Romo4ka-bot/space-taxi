package app.controllers.servlets;

import app.models.News;
import app.repositories.NewsRepository;
import app.repositories.NewsRepositoryJdbcImpl;
import app.services.NewsService;
import app.services.NewsServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

public class NewsServlet extends HttpServlet {

    private NewsService newsService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        DataSource dataSource = (DataSource) config.getServletContext().getAttribute("dataSource");
        NewsRepository newsRepository = new NewsRepositoryJdbcImpl(dataSource);
        newsService = new NewsServiceImpl(newsRepository);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<News> news = newsService.getListOfNews();
        req.setAttribute("list", news);
        req.getRequestDispatcher("/News.ftl").forward(req, resp);
    }
}
