package app.dao;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DBCPDataSource {

    private static BasicDataSource ds = new BasicDataSource();

    static {
        ds.setUrl("jdbc:postgresql://localhost/insurance_service");
        ds.setUsername("postgres");
        ds.setPassword("1234");
        ds.setMinIdle(5);
        ds.setMaxIdle(10);
        ds.setMaxOpenPreparedStatements(100);
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    public  static Statement getStatement() throws SQLException {
        Statement statement = ds.getConnection().createStatement();
        return statement;
    }

    private DBCPDataSource() {

    }
}
