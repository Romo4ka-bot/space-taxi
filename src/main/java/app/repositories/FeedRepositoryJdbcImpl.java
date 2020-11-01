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
    private static final String SQL_SELECT_SEARCH = "select * from feed where title ilike ? ";

    //language=SQL
    private static final String SQL_SELECT_ORDER_DESC_PRICE = "select * from feed where title ilike ? ";

    //language=SQL
    private static final String SQL_SELECT_ORDER_PRICE = "select * from feed where title ilike ? ";

    //language=SQL
    private static final String SQL_SELECT_LEFT_LIMIT_PRICE = "select * from feed where price < ? and title ilike ? ";

    //language=SQL
    private static final String SQL_SELECT_ORDER_AND_LEFT_LIMIT_PRICE = "select * from feed where price < ? and title ilike ? ";

    //language=SQL
    private static final String SQL_SELECT_ORDER_DESC_AND_LEFT_LIMIT_PRICE = "select * from feed where price < ? and title ilike ? ";

    //language=SQL
    private static final String SQL_SELECT_RIGHT_LIMIT_PRICE = "select * from feed where price > ? and title ilike ? ";

    //language=SQL
    private static final String SQL_SELECT_ORDER_AND_RIGHT_LIMIT_PRICE = "select * from feed where price > ? and title ilike ? ";

    //language=SQL
    private static final String SQL_SELECT_ORDER_DESC_AND_RIGHT_LIMIT_PRICE = "select * from feed where price < ? and title ilike ? ";

    //language=SQL
    private static final String SQL_SELECT_LIMIT_PRICE = "select * from feed where price > ? and price < ? and title ilike ? ";

    //language=SQL
    private static final String SQL_SELECT_ORDER_AND_LIMIT_PRICE = "select * from feed where price > ? and price < ? and title ilike ? ";

    //language=SQL
    private static final String SQL_SELECT_ORDER_DESC_AND_LIMIT_PRICE = "select * from feed where price > ? and price < ? and title ilike ? ";

    private RowMapper<Feed> feedRowMapper = row -> Feed.builder()
            .id(row.getLong("id"))
            .title(row.getString("title"))
            .photo(row.getString("photo"))
            .content(row.getString("content"))
            .dateFrom(row.getString("date_from"))
            .dateTo(row.getString("date_to"))
            .description(row.getString("description"))
            .price(row.getInt("price"))
            .stars(row.getInt("stars"))
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
    public void save(Feed entity) {
    }

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
    public List<Feed> findAllWithSearch(String search, List<Integer> listStars) {
        String stars = formatSelectStars(listStars);
        return template.query(SQL_SELECT_SEARCH + stars, feedRowMapper, "%" + search.toLowerCase() + "%");
    }

    @Override
    public List<Feed> findAllByIncreasePrice(String search, List<Integer> listStars) {
        String stars = formatSelectStars(listStars);
        return template.query(SQL_SELECT_ORDER_DESC_PRICE + stars + "order by price desc;", feedRowMapper, "%" + search.toLowerCase() + "%");
    }

    @Override
    public List<Feed> findAllByDecreasePrice(String search, List<Integer> listStars) {
        String stars = formatSelectStars(listStars);
        return template.query(SQL_SELECT_ORDER_PRICE + stars + " order by price;", feedRowMapper, "%" + search.toLowerCase() + "%");
    }

    @Override
    public List<Feed> findAllByLeftLimitPrice(Long priceTo, String search, List<Integer> listStars) {
        String stars = formatSelectStars(listStars);
        return template.query(SQL_SELECT_LEFT_LIMIT_PRICE + stars, feedRowMapper, priceTo, "%" + search.toLowerCase() + "%");
    }

    @Override
    public List<Feed> findAllByIncreaseAndLeftLimitPrice(Long priceTo, String search, List<Integer> listStars) {
        String stars = formatSelectStars(listStars);
        return template.query(SQL_SELECT_ORDER_AND_LEFT_LIMIT_PRICE + stars + " order by price;", feedRowMapper, priceTo, "%" + search.toLowerCase() + "%");
    }

    @Override
    public List<Feed> findAllByDecreaseAndLeftLimitPrice(Long priceTo, String search, List<Integer> listStars) {
        String stars = formatSelectStars(listStars);
        return template.query(SQL_SELECT_ORDER_DESC_AND_LEFT_LIMIT_PRICE + stars + " order by price desc;", feedRowMapper, priceTo, "%" + search.toLowerCase() + "%");
    }

    @Override
    public List<Feed> findAllByRightLimitPrice(Long priceFrom, String search, List<Integer> listStars) {
        String stars = formatSelectStars(listStars);
        return template.query(SQL_SELECT_RIGHT_LIMIT_PRICE + stars, feedRowMapper, priceFrom, "%" + search.toLowerCase() + "%");
    }

    @Override
    public List<Feed> findAllByIncreaseAndRightLimitPrice(Long priceFrom, String search, List<Integer> listStars) {
        String stars = formatSelectStars(listStars);
        return template.query(SQL_SELECT_ORDER_AND_RIGHT_LIMIT_PRICE + stars + " order by price;", feedRowMapper, priceFrom, "%" + search.toLowerCase() + "%");
    }

    @Override
    public List<Feed> findAllByDecreaseAndRightLimitPrice(Long priceFrom, String search, List<Integer> listStars) {
        String stars = formatSelectStars(listStars);
        return template.query(SQL_SELECT_ORDER_DESC_AND_RIGHT_LIMIT_PRICE + stars + " order by price desc;", feedRowMapper, priceFrom, "%" + search.toLowerCase() + "%");
    }

    @Override
    public List<Feed> findAllByLimitPrice(Long priceFrom, Long priceTo, String search, List<Integer> listStars) {
        String stars = formatSelectStars(listStars);
        return template.query(SQL_SELECT_LIMIT_PRICE + stars, feedRowMapper, priceFrom, priceTo, "%" + search.toLowerCase() + "%");
    }

    @Override
    public List<Feed> findAllByIncreaseAndLimitPrice(Long priceFrom, Long priceTo, String search, List<Integer> listStars) {
        String stars = formatSelectStars(listStars);
        return template.query(SQL_SELECT_ORDER_AND_LIMIT_PRICE + stars + " order by price;", feedRowMapper, priceFrom, priceTo, "%" + search.toLowerCase() + "%");
    }

    @Override
    public List<Feed> findAllByDecreaseAndLimitPrice(Long priceFrom, Long priceTo, String search, List<Integer> listStars) {
        String stars = formatSelectStars(listStars);
        return template.query(SQL_SELECT_ORDER_DESC_AND_LIMIT_PRICE + stars + " order by price desc;", feedRowMapper, priceFrom, priceTo, "%" + search.toLowerCase() + "%");
    }

    private String formatSelectStars(List<Integer> listStars) {
        StringBuilder request = new StringBuilder("and (");
        if (!listStars.isEmpty()) {

            for (Integer listStar : listStars) request.append("stars = ").append(listStar).append(" or ");

            request = new StringBuilder(request.substring(0, request.length() - 3)).append(")");

            return request.toString();

        } else return "";
    }
}
