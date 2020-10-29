package app.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import ru.kpfu.itis.orm.annotation.Constraint;
import ru.kpfu.itis.orm.annotation.Table;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString
@Table(name = "users")
public class User {
    @Constraint(pk = true)
    private Long id;
    private String name;
    private String surname;
    private String login;
    private String password;
    private String photo;
    private String gender;
    private String dateBirthday;
    private String dateRegistration;
    private String info;
}
