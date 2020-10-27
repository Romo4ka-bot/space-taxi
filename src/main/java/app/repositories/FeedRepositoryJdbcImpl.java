package app.repositories;

import app.models.Feed;

import javax.sql.DataSource;
import java.util.List;

public class FeedRepositoryJdbcImpl implements FeedRepository {

    private final DataSource dataSource;
    private SimpleJdbcTemplate template;

    //language=SQL
    private static final String SQL_SELECT = "select * from feed";
    //language=SQL
    private static final String SQL_SELECT_BY_ID = "select * from feed where id = ?";

    //language=SQL
    private static final String SQL_SELECT_ORDER_DESC_PRICE = "select * from feed order by price desc";

    //language=SQL
    private static final String SQL_SELECT_ORDER_PRICE = "select * from feed order by price";

    //language=SQL
    private static final String SQL_SELECT_LEFT_LIMIT_PRICE = "select * from feed where price < ?";

    //language=SQL
    private static final String SQL_SELECT_ORDER_AND_LEFT_LIMIT_PRICE = "select * from feed where price < ? order by price";

    //language=SQL
    private static final String SQL_SELECT_ORDER_DESC_AND_LEFT_LIMIT_PRICE = "select * from feed where price < ? order by price desc";

    //language=SQL
    private static final String SQL_SELECT_RIGHT_LIMIT_PRICE = "select * from feed where price > ?";

    //language=SQL
    private static final String SQL_SELECT_ORDER_AND_RIGHT_LIMIT_PRICE = "select * from feed where price > ? order by price";

    //language=SQL
    private static final String SQL_SELECT_ORDER_DESC_AND_RIGHT_LIMIT_PRICE = "select * from feed where price < ? order by price desc";

    //language=SQL
    private static final String SQL_SELECT_LIMIT_PRICE = "select * from feed where price > ? and price < ?";

    //language=SQL
    private static final String SQL_SELECT_ORDER_AND_LIMIT_PRICE = "select * from feed where price > ? and price < ? order by price";

    //language=SQL
    private static final String SQL_SELECT_ORDER_DESC_AND_LIMIT_PRICE = "select * from feed where price > ? and price < ? order by price desc";

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

    @Override
    public List<Feed> findAllByLeftLimitPrice(Long priceTo) {
        return template.query(SQL_SELECT_LEFT_LIMIT_PRICE, feedRowMapper, priceTo);
    }

    @Override
    public List<Feed> findAllByIncreaseAndLeftLimitPrice(Long priceTo) {
        return template.query(SQL_SELECT_ORDER_AND_LEFT_LIMIT_PRICE, feedRowMapper, priceTo);
    }

    @Override
    public List<Feed> findAllByDecreaseAndLeftLimitPrice(Long priceTo) {
        return template.query(SQL_SELECT_ORDER_DESC_AND_LEFT_LIMIT_PRICE, feedRowMapper, priceTo);
    }

    @Override
    public List<Feed> findAllByRightLimitPrice(Long priceFrom) {
        return template.query(SQL_SELECT_RIGHT_LIMIT_PRICE, feedRowMapper, priceFrom);
    }

    @Override
    public List<Feed> findAllByIncreaseAndRightLimitPrice(Long priceFrom) {
        return template.query(SQL_SELECT_ORDER_AND_RIGHT_LIMIT_PRICE, feedRowMapper, priceFrom);
    }

    @Override
    public List<Feed> findAllByDecreaseAndRightLimitPrice(Long priceFrom) {
        return template.query(SQL_SELECT_ORDER_DESC_AND_RIGHT_LIMIT_PRICE, feedRowMapper, priceFrom);
    }

    @Override
    public List<Feed> findAllByLimitPrice(Long priceFrom, Long priceTo) {
        return template.query(SQL_SELECT_LIMIT_PRICE, feedRowMapper, priceFrom, priceTo);
    }

    @Override
    public List<Feed> findAllByIncreaseAndLimitPrice(Long priceFrom, Long priceTo) {
        return template.query(SQL_SELECT_ORDER_AND_LIMIT_PRICE, feedRowMapper, priceFrom, priceTo);
    }

    @Override
    public List<Feed> findAllByDecreaseAndLimitPrice(Long priceFrom, Long priceTo) {
        return template.query(SQL_SELECT_ORDER_DESC_AND_LIMIT_PRICE,feedRowMapper,  priceFrom, priceTo);
    }
}
