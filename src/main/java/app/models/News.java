package app.models;

import lombok.*;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString
public class News {
    private Long id;
    private String name;
    private String photo;
    private String content;
    private String date;
}