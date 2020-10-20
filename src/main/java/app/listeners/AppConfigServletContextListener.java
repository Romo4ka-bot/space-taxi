package app.listeners;

import app.dataSource.MyDataSource;
import app.dataSource.MyDataSourceConfig;
import app.repositories.*;
import app.services.*;
import lombok.SneakyThrows;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;
import java.util.Properties;

@WebListener
public class AppConfigServletContextListener implements ServletContextListener {
    @SneakyThrows
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        Properties properties = new Properties();
        try {
            properties.load(servletContextEvent.getServletContext().getResourceAsStream("/WEB-INF/properties/db.properties"));
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }

        MyDataSourceConfig simpleConfig = new MyDataSourceConfig();

        simpleConfig.setUrl(properties.getProperty("db.url"));
        simpleConfig.setUsername(properties.getProperty("db.username"));
        simpleConfig.setPassword(properties.getProperty("db.password"));
        simpleConfig.setDriver(properties.getProperty("db.driver-class-name"));


        MyDataSource dataSource = new MyDataSource(simpleConfig);


        UsersRepositoryJdbcImpl usersRepositoryJdbcImpl = new UsersRepositoryJdbcImpl(dataSource);
        UsersService usersService = new UsersServiceImpl(usersRepositoryJdbcImpl);

        FeedRepository feedRepository = new FeedRepositoryJdbcImpl(dataSource);
        FeedService feedService = new FeedServiceImpl(feedRepository);

        NewsRepository newsRepository = new NewsRepositoryJdbcImpl(dataSource);
        NewsService newsService = new NewsServiceImpl(newsRepository);

        ReviewRepository reviewRepository = new ReviewRepositoryJdbcImpl(dataSource, usersService, feedService);
        ReviewService reviewService = new ReviewServiceImpl(reviewRepository);

        servletContextEvent.getServletContext().setAttribute("dataSource", dataSource);
        servletContextEvent.getServletContext().setAttribute("userService", usersService);
        servletContextEvent.getServletContext().setAttribute("feedService", feedService);
        servletContextEvent.getServletContext().setAttribute("newsService", newsService);
        servletContextEvent.getServletContext().setAttribute("reviewService", reviewService);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
