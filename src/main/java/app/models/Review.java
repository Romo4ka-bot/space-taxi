package app.models;

import lombok.*;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString
public class Review {
    private Feed feed;
    private User user;
    private String date;
    private String content;
}
