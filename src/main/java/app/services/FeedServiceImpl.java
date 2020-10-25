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
}
