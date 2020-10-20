package app.dataSource;

import lombok.Data;

@Data
public class MyDataSourceConfig {
    private String url;
    private String driver;
    private String username;
    private String password;
}
