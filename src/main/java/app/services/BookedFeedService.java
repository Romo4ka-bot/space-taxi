package app.services;

import app.models.BookedFeed;
import app.models.Feed;
import app.models.User;

public interface BookedFeedService {
    boolean addBookedFeed(BookedFeed bookedFeed);
}
