package app.repositories;

import app.models.Feed;

import java.util.List;

public interface FeedRepository extends CrudRepository<Feed> {
    Feed findById(Long id);

    List<Feed> findAllWithSearch(String search, List<Integer> listStars);
    List<Feed> findAllByIncreasePrice(String search, List<Integer> listStars);
    List<Feed> findAllByDecreasePrice(String search, List<Integer> listStars);

    List<Feed> findAllByLeftLimitPrice(Long priceTo, String search, List<Integer> listStars);
    List<Feed> findAllByIncreaseAndLeftLimitPrice(Long priceTo, String search, List<Integer> listStars);
    List<Feed> findAllByDecreaseAndLeftLimitPrice(Long priceTo, String search, List<Integer> listStars);

    List<Feed> findAllByRightLimitPrice(Long priceFrom, String search, List<Integer> listStars);
    List<Feed> findAllByIncreaseAndRightLimitPrice(Long priceFrom, String search, List<Integer> listStars);
    List<Feed> findAllByDecreaseAndRightLimitPrice(Long priceFrom, String search, List<Integer> listStars);

    List<Feed> findAllByLimitPrice(Long priceFrom, Long priceTo, String search, List<Integer> listStars);
    List<Feed> findAllByIncreaseAndLimitPrice(Long priceFrom, Long priceTo, String search, List<Integer> listStarsv);
    List<Feed> findAllByDecreaseAndLimitPrice(Long priceFrom, Long priceTo, String search, List<Integer> listStars);
}
