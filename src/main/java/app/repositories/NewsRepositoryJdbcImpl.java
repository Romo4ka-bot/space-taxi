package app.repositories;

import app.models.News;

import javax.sql.DataSource;
import java.util.List;

public class NewsRepositoryJdbcImpl implements NewsRepository {

    private DataSource dataSource;
    private SimpleJdbcTemplate template;

    private RowMapper<News> newsRowMapper = row -> News.builder()
            .id(row.getLong("id"))
            .name(row.getString("name"))
            .photo(row.getString("photo"))
            .content(row.getString("content"))
            .date(row.getString("date"))
            .build();

    public NewsRepositoryJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
        template = new SimpleJdbcTemplate(dataSource);
    }

    public News findById(Long newsId) {
        return null;
    }

    @Override
    public List<News> findAll() {
        return null;
    }

    @Override
    public boolean save(News entity) {
        return false;
    }

    @Override
    public void update(News entity) {

    }

    @Override
    public void delete(News entity) {

    }
}
