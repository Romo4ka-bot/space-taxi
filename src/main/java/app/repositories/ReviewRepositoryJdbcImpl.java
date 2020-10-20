package app.repositories;

import app.models.Review;
import app.services.FeedService;
import app.services.UsersService;

import javax.sql.DataSource;
import java.util.List;

public class ReviewRepositoryJdbcImpl implements ReviewRepository {

    private DataSource dataSource;
    private SimpleJdbcTemplate template;
    private UsersService usersService;
    private FeedService feedService;

    private RowMapper<Review> reviewRowMapper = row -> Review.builder()
            .feed(feedService.getFeedById(row.getLong("news_id")))
            .user(usersService.getUserById(row.getLong("user_id")))
            .date(row.getString("date"))
            .content(row.getString("content"))
            .build();

    public ReviewRepositoryJdbcImpl(DataSource dataSource, UsersService usersService, FeedService feedService) {
        this.dataSource = dataSource;
        this.usersService = usersService;
        this.feedService = feedService;
        template = new SimpleJdbcTemplate(dataSource);
    }

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public boolean save(Review entity) {
        return false;
    }

    @Override
    public void update(Review entity) {

    }

    @Override
    public void delete(Review entity) {

    }

}
