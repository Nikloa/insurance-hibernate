package ru.vironit.app.dao.implementation;

import ru.vironit.app.dao.interfaces.InsurerInterface;
import ru.vironit.app.dao.utils.DatabasePool;
import ru.vironit.app.entities.Insurer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsurerImplementation implements InsurerInterface {

    @Override
    public void addInsurer(Insurer insurer) throws SQLException {
        Connection connection = DatabasePool.getConnectionPool().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into clients (nickname, email, password, short_company_name, infomation_phone, rating) values (?, ?, ?, ?, ?, ?)");
        preparedStatement.setString(1, insurer.getNickname());
        preparedStatement.setString(2, insurer.getEmail());
        preparedStatement.setString(3, insurer.getPassword());
        preparedStatement.setString(4, insurer.getCompanyName());
        preparedStatement.setInt(5, insurer.getPhone());
        preparedStatement.setDouble(6, insurer.getRating());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        DatabasePool.getConnectionPool().releaseConnection(connection);
        /*
        DatabasePool.getConnectionPool().getConnection().createStatement().executeUpdate("insert into insurers (nickname, email, password, short_company_name, information_phone, raiting)" +
                "values ('" + client.getNickname() + "', '" + client.getEmail() + "', '" + client.getPassword() + "', " +
                client.getCompanyName() + ", " + client.getPhone() + ", " + client.getRating() + ")");
         */
    }

    @Override
    public Insurer extractInsurer(String email) throws SQLException {
        ResultSet resultSet = DatabasePool.getConnectionPool().getConnection().createStatement().executeQuery("select * from insurers where email like '" + email + "'");
        resultSet.next();
        Insurer insurer = new Insurer(resultSet.getInt(1),
                resultSet.getString(2),
                resultSet.getString(3),
                resultSet.getString(4),
                resultSet.getString(5),
                resultSet.getInt(6),
                resultSet.getDouble(8));
        return insurer;
    }

    @Override
    public void updateInsurer(Insurer insurer, int id) throws SQLException {
        Connection connection = DatabasePool.getConnectionPool().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("update insurers set nickname = ?, email = ?, password = ?, short_company_name = ?, information_phone = ?, rating = ? where id = ?");
        preparedStatement.setString(1, insurer.getNickname());
        preparedStatement.setString(2, insurer.getEmail());
        preparedStatement.setString(3, insurer.getPassword());
        preparedStatement.setString(4, insurer.getCompanyName());
        preparedStatement.setInt(5, insurer.getPhone());
        preparedStatement.setDouble(6, insurer.getRating());
        preparedStatement.setInt(7, id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        DatabasePool.getConnectionPool().releaseConnection(connection);
        /*
        DatabasePool.getConnectionPool().getConnection().createStatement().executeUpdate("update insurers set nickname = '" + newInsurer.getNickname() + "', email = '" + newInsurer.getEmail() + "', password = '" +
                newInsurer.getPassword() + "', short_company_name = " + newInsurer.getCompanyName() + ", information_phone = " + newInsurer.getPhone() + ", raiting = " + newInsurer.getRating() + " where id = " + id);
         */
    }

    @Override
    public void deleteInsurer(int id) throws SQLException {
        Connection connection = DatabasePool.getConnectionPool().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("delete from insurers where id = ?");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        DatabasePool.getConnectionPool().releaseConnection(connection);
    }
}
