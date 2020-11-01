package app.services;

import app.models.Feed;

import java.util.List;

public interface FeedService {
    Feed getFeedById(Long feedId);

    List<Feed> getAll();

    List<Feed> getAllWithSearch(String search, List<Integer> listStars);
    List<Feed> getAllByIncreasePrice(String search, List<Integer> listStars);
    List<Feed> getAllByDecreasePrice(String search, List<Integer> listStars);

    List<Feed> getAllByLeftLimitPrice(Long priceTo, String search, List<Integer> listStars);
    List<Feed> getAllByIncreaseAndLeftLimitPrice(Long priceTo, String search, List<Integer> listStars);
    List<Feed> getAllByDecreaseAndLeftLimitPrice(Long priceTo, String search, List<Integer> listStars);

    List<Feed> getAllByRightLimitPrice(Long priceFrom, String search, List<Integer> listStars);
    List<Feed> getAllByIncreaseAndRightLimitPrice(Long priceFrom, String search, List<Integer> listStars);
    List<Feed> getAllByDecreaseAndRightLimitPrice(Long priceFrom, String search, List<Integer> listStars);

    List<Feed> getAllByLimitPrice(Long priceFrom, Long priceTo, String search, List<Integer> listStars);
    List<Feed> getAllByIncreaseAndLimitPrice(Long priceFrom, Long priceTo, String search, List<Integer> listStars);
    List<Feed> getAllByDecreaseAndLimitPrice(Long priceFrom, Long priceTo, String search, List<Integer> listStars);
}
