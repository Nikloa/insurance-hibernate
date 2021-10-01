package ru.vironit.app.dao.implementation;

import ru.vironit.app.dao.interfaces.AdminInterface;
import ru.vironit.app.dao.utils.DatabasePool;
import ru.vironit.app.entities.Admin;

import java.sql.*;

public class AdminImplementation implements AdminInterface {

    @Override
    public void addAdmin(Admin admin) throws SQLException {
        Connection connection = DatabasePool.getConnectionPool().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into admins (nickname, email, password) values (?, ?, ?)");
        preparedStatement.setString(1, admin.getNickname());
        preparedStatement.setString(2, admin.getEmail());
        preparedStatement.setString(3, admin.getPassword());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        DatabasePool.getConnectionPool().releaseConnection(connection);
    }

    @Override
    public Admin extractAdmin(int id) throws SQLException {
        Connection connection = DatabasePool.getConnectionPool().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from admins where id = " + id);
        resultSet.next();
        Admin admin = new Admin(resultSet.getInt(1),
                resultSet.getString(2),
                resultSet.getString(3),
                resultSet.getString(4));
        statement.close();
        DatabasePool.getConnectionPool().releaseConnection(connection);
        return admin;
    }

    @Override
    public void updateAdmin(Admin admin, int id) throws SQLException {
        Connection connection = DatabasePool.getConnectionPool().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("update admins set nickname = ?, email = ?, password = ? where id = ?");
        preparedStatement.setString(1, admin.getNickname());
        preparedStatement.setString(2, admin.getEmail());
        preparedStatement.setString(3, admin.getPassword());
        preparedStatement.setInt(4, id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        DatabasePool.getConnectionPool().releaseConnection(connection);
    }

    @Override
    public void deleteAdmin(int id) throws SQLException {
        Connection connection = DatabasePool.getConnectionPool().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("delete from admins where id = ?");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        DatabasePool.getConnectionPool().releaseConnection(connection);
    }
}
