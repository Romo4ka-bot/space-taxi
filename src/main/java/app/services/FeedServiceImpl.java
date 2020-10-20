package app.services;

import app.models.Feed;
import app.repositories.FeedRepository;

public class FeedServiceImpl implements FeedService {
    private FeedRepository feedRepository;

    public FeedServiceImpl(FeedRepository feedRepository) {
        this.feedRepository = feedRepository;
    }

    @Override
    public Feed getFeedById(Long feedId) {
        return feedRepository.findById(feedId);
    }
}
