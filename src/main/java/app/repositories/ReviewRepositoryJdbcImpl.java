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

    //language=SQL
    private static final String SQL_SELECT_BY_ID = "select * from review where feed_id = ? order by id desc";

    //language=SQL
    private static final String SQL_INSERT = "insert into review(feed_id, users_id, date, content) values(?, ?, ?, ?);";

    protected RowMapper<Review> reviewRowMapper = row -> Review.builder()
            .id(row.getLong("id"))
            .feed(feedService.getFeedById(row.getLong("feed_id")))
            .user(usersService.getUserById(row.getLong("users_id")))
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
    public void save(Review entity) {

        Long feed_id = entity.getFeed().getId();
        Long user_id = entity.getUser().getId();
        String date = entity.getDate();
        String content = entity.getContent();
        template.update(SQL_INSERT, feed_id, user_id, date, content);
    }

    @Override
    public void update(Review entity) {

    }

    @Override
    public void delete(Review entity) {

    }

    @Override
    public List<Review> findAllByFeedId(Long feed_id) {
        return template.query(SQL_SELECT_BY_ID, reviewRowMapper, feed_id);
    }
}