package app.models;


import lombok.*;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString
public class Feed {
    private Long id;
    private String name;
    private String photo;
    private String content;
    private String dateFrom;
    private String dateTo;
    private String description;
    private Integer price;

    public Feed(String name, String content, String dateFrom, String dateTo, String description, Integer price) {
        this.name = name;
        this.content = content;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.description = description;
        this.price = price;
    }
}
