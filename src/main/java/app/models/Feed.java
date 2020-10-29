package app.models;


import lombok.*;
import ru.kpfu.itis.orm.annotation.Constraint;
import ru.kpfu.itis.orm.annotation.Table;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString
@Table(name = "feed")
public class Feed {
    @Constraint(pk = true)
    private Long id;
    private String title;
    private String photo;
    private String content;
    private String dateFrom;
    private String dateTo;
    private String description;
    private Integer price;
}
