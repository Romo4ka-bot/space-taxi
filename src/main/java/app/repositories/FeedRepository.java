package app.repositories;

import app.models.Feed;

import java.util.List;

public interface FeedRepository extends CrudRepository<Feed> {
    Feed findById(Long id);

    List<Feed> findAllByIncreasePrice();
    List<Feed> findAllByDecreasePrice();

    List<Feed> findAllByLeftLimitPrice(Long priceTo);
    List<Feed> findAllByIncreaseAndLeftLimitPrice(Long priceTo);
    List<Feed> findAllByDecreaseAndLeftLimitPrice(Long priceTo);

    List<Feed> findAllByRightLimitPrice(Long priceFrom);
    List<Feed> findAllByIncreaseAndRightLimitPrice(Long priceFrom);
    List<Feed> findAllByDecreaseAndRightLimitPrice(Long priceFrom);

    List<Feed> findAllByLimitPrice(Long priceFrom, Long priceTo);
    List<Feed> findAllByIncreaseAndLimitPrice(Long priceFrom, Long priceTo);
    List<Feed> findAllByDecreaseAndLimitPrice(Long priceFrom, Long priceTo);
}
