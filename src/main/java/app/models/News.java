package app.models;

import lombok.*;
import ru.kpfu.itis.orm.annotation.Constraint;
import ru.kpfu.itis.orm.annotation.Table;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString
@Table(name = "news")
public class News {
    @Constraint(pk = true)
    private Long id;
    private String title;
    private String photo;
    private String content;
    private String date;
}
