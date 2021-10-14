package ru.vironit.app.dao.utils;

import ru.vironit.app.dao.interfaces.ConnectionPool;

import java.sql.SQLException;

public class DatabasePool {

    private static ConnectionPool connectionPool;

    static {
        try {

            connectionPool = BasicConnectionPool.create("jdbc:postgresql://localhost/insurance_service?user=postgres&password=1234&ssl=false", "postgres", "1234");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ConnectionPool getConnectionPool() {
        return connectionPool;
    }

}
