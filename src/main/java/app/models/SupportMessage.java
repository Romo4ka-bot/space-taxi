package app.models;

import lombok.*;
import ru.kpfu.itis.orm.annotation.Constraint;
import ru.kpfu.itis.orm.annotation.Table;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString
@Table(name = "support_message")
public class SupportMessage {
    @Constraint(pk = true)
    private Long id;
    private Long userId;
    private String name;
    private String surname;
    private String email;
    private String date;
    private String content;
}
