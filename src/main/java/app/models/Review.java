package app.models;

import lombok.*;
import ru.kpfu.itis.orm.annotation.Constraint;
import ru.kpfu.itis.orm.annotation.Table;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString
@Table(name = "review")
public class Review {
    @Constraint(pk = true)
    private Long id;
    private Feed feed;
    private User user;
    private String date;
    private String content;
}
