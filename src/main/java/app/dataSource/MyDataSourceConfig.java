package app.dataSource;

public class MyDataSourceConfig {
    private String JdbcUrl;
    private String DriverClassName;
    private String username;
    private String password;

    public MyDataSourceConfig(){}

    public String getJdbcUrl() {
        return JdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        JdbcUrl = jdbcUrl;
    }

    public String getDriverClassName() {
        return DriverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        DriverClassName = driverClassName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
