package app.repositories;

import app.models.Feed;

import javax.sql.DataSource;
import java.util.List;

public class FeedRepositoryJdbcImpl implements FeedRepository {

    private final DataSource dataSource;
    private SimpleJdbcTemplate template;

    //language=SQL
    private String SQL_SELECT = "select * from feed where id < 6";
    //language=SQL
    private String SQL_SELECT_BY_ID = "select * from feed where id = ?";

    //language=SQL
    private String SQL_SELECT_ORDER_DESC_PRICE = "select * from feed order by price desc";

    //language=SQL
    private String SQL_SELECT_ORDER_PRICE = "select * from feed order by price desc";

    private RowMapper<Feed> feedRowMapper = row -> Feed.builder()
            .id(row.getLong("id"))
            .title(row.getString("title"))
            .photo(row.getString("photo"))
            .content(row.getString("content"))
            .dateFrom(row.getString("date_from"))
            .dateTo(row.getString("date_to"))
            .description(row.getString("description"))
            .price(row.getInt("price"))
            .build();

    public FeedRepositoryJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
        template = new SimpleJdbcTemplate(dataSource);
    }

    @Override
    public List<Feed> findAll() {
        return template.query(SQL_SELECT, feedRowMapper);
    }

    @Override
    public void save(Feed entity) {}

    @Override
    public void update(Feed entity) {

    }

    @Override
    public void delete(Feed entity) {

    }

    @Override
    public Feed findById(Long id) {
        return template.query(SQL_SELECT_BY_ID, feedRowMapper, id).get(0);
    }

    @Override
    public List<Feed> findAllByIncreasePrice() {
        return template.query(SQL_SELECT_ORDER_DESC_PRICE, feedRowMapper);
    }

    @Override
    public List<Feed> findAllByDecreasePrice() {
        return template.query(SQL_SELECT_ORDER_PRICE, feedRowMapper);
    }
}
