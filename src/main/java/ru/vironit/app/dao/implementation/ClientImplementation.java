package ru.vironit.app.dao.implementation;

import ru.vironit.app.dao.interfaces.ClientInterface;
import ru.vironit.app.dao.utils.DatabasePool;
import ru.vironit.app.entities.Client;

import java.sql.*;

public class ClientImplementation implements ClientInterface {

    @Override
    public void addClient(Client client) throws SQLException {
        Connection connection = DatabasePool.getConnectionPool().getConnection();
        /*
        Statement statement = connection.createStatement();
        statement.executeUpdate("insert into clients (nickname, email, password, phone, balance, rating)" +
                "values ('" + client.getNickname() + "', '" + client.getEmail() + "', '" + client.getPassword() + "', " +
                client.getPhone() + ", " + client.getBalance() + ", " + client.getRating() + ")");
         */
        PreparedStatement preparedStatement = connection.prepareStatement("insert into clients (nickname, email, password, phone, balance, rating) values (?, ?, ?, ?, ?, ?)");
        preparedStatement.setString(1, client.getNickname());
        preparedStatement.setString(2, client.getEmail());
        preparedStatement.setString(3, client.getPassword());
        preparedStatement.setInt(4, client.getPhone());
        preparedStatement.setBigDecimal(5, client.getBalance());
        preparedStatement.setDouble(6, client.getRating());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        DatabasePool.getConnectionPool().releaseConnection(connection);
        System.out.println(client.toString());
    }

    @Override
    public Client extractClient(int id) throws SQLException {
        Connection connection = DatabasePool.getConnectionPool().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from clients where id = " + id);
        resultSet.next();
        Client client = new Client(resultSet.getInt(1),
                resultSet.getString(2),
                resultSet.getString(3),
                resultSet.getString(4),
                resultSet.getInt(5),
                resultSet.getBigDecimal(7),
                resultSet.getDouble(8));
        statement.close();
        DatabasePool.getConnectionPool().releaseConnection(connection);
        return client;
    }

    @Override
    public void updateClient(Client client, int id) throws SQLException {
        Connection connection = DatabasePool.getConnectionPool().getConnection();
        /*
        Statement statement = connection.createStatement();
        DatabasePool.getConnectionPool().getConnection().createStatement().executeUpdate("update clients set nickname = '" + newClient.getNickname() + "', email = '" + newClient.getEmail() + "', password = '" +
                newClient.getPassword() + "', phone = " + newClient.getPhone() + ", balance = " + newClient.getBalance() + ", raiting = " + newClient.getRating() + " where id = " + id);
         */
        PreparedStatement preparedStatement = connection.prepareStatement("update clients set nickname = ?, email = ?, password = ?, phone = ?, balance = ?, rating = ? where id = ?");
        preparedStatement.setString(1, client.getNickname());
        preparedStatement.setString(2, client.getEmail());
        preparedStatement.setString(3, client.getPassword());
        preparedStatement.setInt(4, client.getPhone());
        preparedStatement.setBigDecimal(5, client.getBalance());
        preparedStatement.setDouble(6, client.getRating());
        preparedStatement.setInt(7, id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        DatabasePool.getConnectionPool().releaseConnection(connection);
    }

    @Override
    public void deleteClient(int id) throws SQLException {
        Connection connection = DatabasePool.getConnectionPool().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("delete from clients where id = ?");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        DatabasePool.getConnectionPool().releaseConnection(connection);
    }
}