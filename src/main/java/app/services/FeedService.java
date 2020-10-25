package app.services;

import app.models.Feed;

import java.util.List;

public interface FeedService {

    Feed getFeedById(Long feedId);

    List<Feed> getAll();

    List<Feed> getAllByIncreasePrice();

    List<Feed> getAllByDecreasePrice();
}
