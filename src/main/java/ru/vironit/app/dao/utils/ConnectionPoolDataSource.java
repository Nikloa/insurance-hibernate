package ru.vironit.app.dao.utils;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPoolDataSource {

    private static BasicDataSource ds = new BasicDataSource();

    static {
        ds.setUrl("jdbc:postgresql://localhost/insurance_service");
        ds.setUsername("postgres");
        ds.setPassword("1234");
        ds.setMinIdle(5);
        ds.setMaxIdle(10);
        ds.setMaxOpenPreparedStatements(100);
    }

    static {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Everything is good");
        } catch (ClassNotFoundException e) {
            System.err.println("PostgreSQL DataSource unable to load PostgreSQL JDBC Driver");
        }
    }


    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    private ConnectionPoolDataSource() {

    }
}
