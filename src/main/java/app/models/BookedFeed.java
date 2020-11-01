package app.models;

import lombok.*;
import ru.kpfu.itis.orm.annotation.Constraint;
import ru.kpfu.itis.orm.annotation.Table;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString
@Table(name = "booked_feed")
public class BookedFeed {
    @Constraint(pk = true)
    private Long id;
    private User user;
    private Feed feed;
    private String date;
}
