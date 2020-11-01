package app.repositories;

import app.models.News;
import app.services.UsersService;

import javax.sql.DataSource;
import java.util.List;

public class NewsRepositoryJdbcImpl implements NewsRepository {

    private DataSource dataSource;
    private SimpleJdbcTemplate template;
    private UsersService usersService;

    //language=SQL
    private static final String SQL_SELECT_BY_ID = "select * from news where id = ?";

    //language=SQL
    private static final String SQL_SELECT = "select * from news order by id desc";

    //language=SQL
    private static final String SQL_INSERT = "insert into news(title, content, photo, date, user_id) values (?, ?, ?, ?, ?)";

    private RowMapper<News> newsRowMapper = row -> News.builder()
            .id(row.getLong("id"))
            .user(usersService.getUserById(row.getLong("user_id")))
            .title(row.getString("title"))
            .photo(row.getString("photo"))
            .content(row.getString("content"))
            .date(row.getString("date"))
            .build();

    public NewsRepositoryJdbcImpl(DataSource dataSource, UsersService usersService) {
        this.dataSource = dataSource;
        template = new SimpleJdbcTemplate(dataSource);
        this.usersService = usersService;
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

        String title = entity.getTitle();
        String photo = entity.getPhoto();
        String content = entity.getContent();
        String date = entity.getDate();
        Long userId = entity.getUser().getId();

        template.update(SQL_INSERT, title, content, photo, date, userId);
    }

    @Override
    public void update(News entity) {

    }

    @Override
    public void delete(News entity) {

    }
}
