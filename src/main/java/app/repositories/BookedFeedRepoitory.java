package app.repositories;

import app.models.BookedFeed;

public interface BookedFeedRepoitory extends CrudRepository<BookedFeed> {
    BookedFeed find(BookedFeed bookedFeed);
}
