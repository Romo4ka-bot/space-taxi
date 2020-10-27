package app.services;

import app.models.Feed;

import java.util.List;

public interface FeedService {
    Feed getFeedById(Long feedId);

    List<Feed> getAll();

    List<Feed> getAllByIncreasePrice();

    List<Feed> getAllByDecreasePrice();

    List<Feed> getAllByLeftLimitPrice(Long priceTo);
    List<Feed> getAllByIncreaseAndLeftLimitPrice(Long priceTo);
    List<Feed> getAllByDecreaseAndLeftLimitPrice(Long priceTo);

    List<Feed> getAllByRightLimitPrice(Long priceFrom);
    List<Feed> getAllByIncreaseAndRightLimitPrice(Long priceFrom);
    List<Feed> getAllByDecreaseAndRightLimitPrice(Long priceFrom);

    List<Feed> getAllByLimitPrice(Long priceFrom, Long priceTo);
    List<Feed> getAllByIncreaseAndLimitPrice(Long priceFrom, Long priceTo);
    List<Feed> getAllByDecreaseAndLimitPrice(Long priceFrom, Long priceTo);
}
