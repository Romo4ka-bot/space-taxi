package app.services;

import app.models.BookedFeed;
import app.repositories.BookedFeedRepoitory;

public class BookedFeedServiceImpl implements BookedFeedService {
    BookedFeedRepoitory bookedFeedRepoitory;

    public BookedFeedServiceImpl(BookedFeedRepoitory bookedFeedRepoitory) {
        this.bookedFeedRepoitory = bookedFeedRepoitory;
    }

    @Override
    public boolean addBookedFeed(BookedFeed bookedFeed) {
        if (bookedFeedIsExist(bookedFeed) == null) {
            bookedFeedRepoitory.save(bookedFeed);
            return true;
        }
        return false;
    }

    private BookedFeed bookedFeedIsExist(BookedFeed bookedFeed) {
        return bookedFeedRepoitory.find(bookedFeed);
    }
}
