package app.services;

import app.models.Feed;
import app.repositories.FeedRepository;

import java.util.List;

public class FeedServiceImpl implements FeedService {
    private FeedRepository feedRepository;

    public FeedServiceImpl(FeedRepository feedRepository) {
        this.feedRepository = feedRepository;
    }

    @Override
    public Feed getFeedById(Long feedId) {
        return feedRepository.findById(feedId);
    }

    @Override
    public List<Feed> getAll() {
        return feedRepository.findAll();
    }

    @Override
    public List<Feed> getAllWithSearch(String search, List<Integer> listStars) {
        return feedRepository.findAllWithSearch(search, listStars);
    }

    @Override
    public List<Feed> getAllByIncreasePrice(String search, List<Integer> listStars) {
        return feedRepository.findAllByIncreasePrice(search, listStars);
    }

    @Override
    public List<Feed> getAllByDecreasePrice(String search, List<Integer> listStars) {
        return feedRepository.findAllByDecreasePrice(search, listStars);
    }

    @Override
    public List<Feed> getAllByLeftLimitPrice(Long priceTo, String search, List<Integer> listStars) {
        return feedRepository.findAllByLeftLimitPrice(priceTo, search, listStars);
    }

    @Override
    public List<Feed> getAllByIncreaseAndLeftLimitPrice(Long priceTo, String search, List<Integer> listStars) {
        return feedRepository.findAllByIncreaseAndLeftLimitPrice(priceTo, search, listStars);
    }

    @Override
    public List<Feed> getAllByDecreaseAndLeftLimitPrice(Long priceTo, String search, List<Integer> listStars) {
        return feedRepository.findAllByDecreaseAndLeftLimitPrice(priceTo, search, listStars);
    }

    @Override
    public List<Feed> getAllByRightLimitPrice(Long priceFrom, String search, List<Integer> listStars) {
        return feedRepository.findAllByRightLimitPrice(priceFrom, search, listStars);
    }

    @Override
    public List<Feed> getAllByIncreaseAndRightLimitPrice(Long priceFrom, String search, List<Integer> listStars) {
        return feedRepository.findAllByIncreaseAndRightLimitPrice(priceFrom, search, listStars);
    }

    @Override
    public List<Feed> getAllByDecreaseAndRightLimitPrice(Long priceFrom, String search, List<Integer> listStars) {
        return feedRepository.findAllByDecreaseAndRightLimitPrice(priceFrom, search, listStars);
    }

    @Override
    public List<Feed> getAllByLimitPrice(Long priceFrom, Long priceTo, String search, List<Integer> listStars) {
        return feedRepository.findAllByLimitPrice(priceFrom, priceTo, search, listStars);
    }

    @Override
    public List<Feed> getAllByIncreaseAndLimitPrice(Long priceFrom, Long priceTo, String search, List<Integer> listStars) {
        return feedRepository.findAllByIncreaseAndLimitPrice(priceFrom, priceTo, search, listStars);
    }

    @Override
    public List<Feed> getAllByDecreaseAndLimitPrice(Long priceFrom, Long priceTo, String search, List<Integer> listStars) {
        return feedRepository.findAllByDecreaseAndLimitPrice(priceFrom, priceTo, search, listStars);
    }
}
