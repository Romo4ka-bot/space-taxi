package app.repositories;

import app.util.DBConnection;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SimpleJdbcTemplate {

    DataSource dataSource;

    public SimpleJdbcTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... args) {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {

            connection = dataSource.getConnection();
            statement = connection.prepareStatement(sql);

            List<T> result = new ArrayList<>();

            if (args != null)

                for (int i = 0; i < args.length; i++) {
                    statement.setObject(i + 1, args[i]);
                }

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                T current = rowMapper.mapRow(resultSet);
                result.add(current);
            }

            return result;

        } catch (SQLException e) {
            throw new IllegalStateException(e);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    //ignore
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    //ignore
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    //ignore
                }
            }
        }
    }

    public void update(String sql, Object... args) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(sql);

            if (args != null)

                for (int i = 0; i < args.length; i++) {
                    statement.setObject(i + 1, args[i]);
                }

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    //ignore
                }
            }
            if (connection != null)
                try {
                    connection.close();
                } catch (SQLException e) {
                    //ignore
                }
        }
    }
}
