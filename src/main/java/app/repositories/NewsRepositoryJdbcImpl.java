package app.repositories;

import app.models.News;

import javax.sql.DataSource;
import java.util.List;

public class NewsRepositoryJdbcImpl implements NewsRepository {

    private DataSource dataSource;
    private SimpleJdbcTemplate template;

    //language=SQL
    private static final String SQL_SELECT_BY_ID = "select * from news where id = ?";

    //language=SQL
    private static final String SQL_SELECT = "select * from news";

    private RowMapper<News> newsRowMapper = row -> News.builder()
            .id(row.getLong("id"))
            .title(row.getString("title"))
            .photo(row.getString("photo"))
            .content(row.getString("content"))
            .date(row.getString("date"))
            .build();

    public NewsRepositoryJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
        template = new SimpleJdbcTemplate(dataSource);
    }

    @Override
    public News findById(Long id) {
        return template.query(SQL_SELECT_BY_ID, newsRowMapper, id).get(0);
    }

    @Override
    public List<News> findAll() {
        return template.query(SQL_SELECT, newsRowMapper);
    }

    @Override
    public void save(News entity) {
    }

    @Override
    public void update(News entity) {

    }

    @Override
    public void delete(News entity) {

    }
}
