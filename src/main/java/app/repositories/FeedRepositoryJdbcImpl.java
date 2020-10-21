package app.repositories;

import app.models.Feed;

import javax.sql.DataSource;
import java.util.List;

public class FeedRepositoryJdbcImpl implements FeedRepository {

    private final DataSource dataSource;
    private SimpleJdbcTemplate template;

    //language=SQL
    private String SQL_SELECT = "select * from feed where id < 6";

    private RowMapper<Feed> feedRowMapper = row -> Feed.builder()
            .id(row.getLong("id"))
            .name(row.getString("name"))
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
        List<Feed> list = template.query(SQL_SELECT, feedRowMapper);
        return list;
    }

    @Override
    public boolean save(Feed entity) {
        return false;
    }

    @Override
    public void update(Feed entity) {

    }

    @Override
    public void delete(Feed entity) {

    }

    @Override
    public Feed findById(Long id) {
        return null;
    }
}
