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
    public List<Feed> getAllByIncreasePrice() {
        return feedRepository.findAllByIncreasePrice();
    }

    @Override
    public List<Feed> getAllByDecreasePrice() {
        return feedRepository.findAllByDecreasePrice();
    }

    @Override
    public List<Feed> getAllByLeftLimitPrice(Long priceTo) {
        return feedRepository.findAllByLeftLimitPrice(priceTo);
    }

    @Override
    public List<Feed> getAllByIncreaseAndLeftLimitPrice(Long priceTo) {
        return feedRepository.findAllByIncreaseAndLeftLimitPrice(priceTo);
    }

    @Override
    public List<Feed> getAllByDecreaseAndLeftLimitPrice(Long priceTo) {
        return feedRepository.findAllByDecreaseAndLeftLimitPrice(priceTo);
    }

    @Override
    public List<Feed> getAllByRightLimitPrice(Long priceFrom) {
        return feedRepository.findAllByRightLimitPrice(priceFrom);
    }

    @Override
    public List<Feed> getAllByIncreaseAndRightLimitPrice(Long priceFrom) {
        return feedRepository.findAllByIncreaseAndRightLimitPrice(priceFrom);
    }

    @Override
    public List<Feed> getAllByDecreaseAndRightLimitPrice(Long priceFrom) {
        return feedRepository.findAllByDecreaseAndRightLimitPrice(priceFrom);
    }

    @Override
    public List<Feed> getAllByLimitPrice(Long priceFrom, Long priceTo) {
        return feedRepository.findAllByLimitPrice(priceFrom, priceTo);
    }

    @Override
    public List<Feed> getAllByIncreaseAndLimitPrice(Long priceFrom, Long priceTo) {
        return feedRepository.findAllByIncreaseAndLimitPrice(priceFrom, priceTo);
    }

    @Override
    public List<Feed> getAllByDecreaseAndLimitPrice(Long priceFrom, Long priceTo) {
        return feedRepository.findAllByDecreaseAndLimitPrice(priceFrom, priceTo);
    }
}
