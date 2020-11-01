package app.repositories;

import app.models.User;

import javax.sql.DataSource;
import java.util.List;

public class UsersRepositoryJdbcImpl implements UsersRepository {

    private DataSource dataSource;
    private SimpleJdbcTemplate template;

    //language=SQL
    private static final String SQL_SELECT_USER_LOG = "select * from users where login = ?";

    //language=SQL
    private static final String SQL_INSERT_USER = "insert into users(name, surname, login, password, gender, date_registration) " +
            "values(?, ?, ?, ?, ?, ?);";

    //language=SQL
    private static final String SQL_SELECT_BY_ID = "select * from users where id = ?";

    //language=SQL
    private static final String SQL_UPDATE = "update users set name = ?, surname = ?, photo = ?, date_birthday = ?, gender = ?, info = ? where id = ?";

    //language=SQL
    private static final String SQL_SELECT_ALL_WITH_PAGES = "select * from users order by id limit ? offset ?;";

    private RowMapper<User> userRowMapper = row -> User.builder()
            .id(row.getLong("id"))
            .name(row.getString("name"))
            .surname(row.getString("surname"))
            .login(row.getString("login"))
            .password(row.getString("password"))
            .photo(row.getString("photo"))
            .gender(row.getString("gender"))
            .dateBirthday(row.getString("date_birthday"))
            .dateRegistration(row.getString("date_registration"))
            .info(row.getString("info"))
            .build();


    public UsersRepositoryJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
        template = new SimpleJdbcTemplate(dataSource);
    }

    @Override
    public User findByLogin(String login) {
        List<User> list = template.query(SQL_SELECT_USER_LOG, userRowMapper, login);
        return !list.isEmpty() ? list.get(0) : null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void save(User entity) {

        String name = entity.getName();
        String surname = entity.getSurname();
        String login = entity.getLogin();
        String password = entity.getPassword();
        String gender = entity.getGender();
        String dateRegistration = entity.getDateRegistration();

        template.update(SQL_INSERT_USER, name, surname, login, password, gender, dateRegistration);
    }

    @Override
    public void update(User entity) {

        Long id = entity.getId();
        String name = entity.getName();
        String surname = entity.getSurname();
        String photo = entity.getPhoto();
        String dateBirthday = entity.getDateBirthday();
        String gender = entity.getGender();
        String info = entity.getInfo();

        template.update(SQL_UPDATE, name, surname, photo, dateBirthday, gender, info, id);
    }

    @Override
    public void delete(User entity) {

    }

    @Override
    public User findById(Long id) {
        return template.query(SQL_SELECT_BY_ID, userRowMapper, id).get(0);
    }

    @Override
    public List<User> findAll(int page, int size) {
        return template.query(SQL_SELECT_ALL_WITH_PAGES, userRowMapper, size, page * size);
    }
}
