package ru.vironit.app.dao.implementation;

import ru.vironit.app.dao.interfaces.ConnectionPool;
import ru.vironit.app.dao.interfaces.InsurerInterface;
import ru.vironit.app.dao.utils.DatabasePool;
import ru.vironit.app.entities.Insurer;

import java.sql.*;

public class InsurerImplementation implements InsurerInterface {

    @Override
    public void addInsurer(Insurer insurer) throws SQLException {
        Connection connection = DatabasePool.getConnectionPool().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into insurers (nickname, email, password, short_company_name, information_phone, rating) values (?, ?, ?, ?, ?, ?)");
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
    public Insurer extractInsurer(int id) throws SQLException {
        ConnectionPool pool = DatabasePool.getConnectionPool();
        Connection connection = pool.getConnection();
        ResultSet resultSet = connection.createStatement().executeQuery("select * from insurers where id = " + id);
        if(resultSet.next()) {
            Insurer insurer = new Insurer(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getInt(6),
                    resultSet.getDouble(8));
            pool.releaseConnection(connection);
            return insurer;
        }
        pool.releaseConnection(connection);
        return null;
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

    @Override
    public Insurer checkInsurer(String email) throws SQLException {
        ResultSet resultSet = DatabasePool.getConnectionPool().getConnection().createStatement().executeQuery("select * from insurers where email like '" + email + "'");
        if(resultSet.next()) {
            Insurer insurer = new Insurer(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getInt(6),
                    resultSet.getDouble(8));
            return insurer;
        }
        return null;
    }

    @Override
    public boolean loginInsurer(String email, String password) throws SQLException {
        Connection connection = DatabasePool.getConnectionPool().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from insurers where email like '" + email + "' and password like '" + password + "'");
        return resultSet.next();
    }

    @Override
    public int parsePhone(String phone) {
        String numb = "0123456789";
        String phoneString = "";
        if(phoneString != phone) {
            for (int i = 4; i < phone.length(); i++) {
                for (int j = 0; j < 10; j++) {
                    if(phone.charAt(i) == numb.charAt(j)) {
                        phoneString += numb.charAt(j);
                    }
                }
            }
            return Integer.parseInt(phoneString);
        }
        return 0;
    }
}
