package app.services;

import app.models.Feed;

public interface FeedService {
    Feed getFeedById(Long feedId);
}
