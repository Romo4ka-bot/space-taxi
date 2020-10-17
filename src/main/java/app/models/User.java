package app.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString
public class User {
    private Long id;
    private String name;
    private String surname;
    private String login;
    private String password;
    private String gender;
    private String info;
}