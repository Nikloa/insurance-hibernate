package ru.vironit.app.dao.implementation;

import ru.vironit.app.dao.interfaces.ConnectionPool;
import ru.vironit.app.dao.interfaces.OfferInterface;
import ru.vironit.app.dao.utils.DatabasePool;
import ru.vironit.app.entities.Offer;

import java.sql.*;
import java.util.ArrayList;

public class OfferImplementation implements OfferInterface {

    @Override
    public void addOffer(Offer offer) throws SQLException {
        ConnectionPool pool = DatabasePool.getConnectionPool();
        Connection connection = pool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into offers (insurance_type_id, description, cost, insurer_id, visible, term) values (?, ?, ?, ?, ?, ?)");
        preparedStatement.setInt(1, offer.getInsuranceTypeId());
        preparedStatement.setString(2, offer.getDescription());
        preparedStatement.setBigDecimal(3, offer.getCost());
        preparedStatement.setInt(4, offer.getInsurerId());
        preparedStatement.setBoolean(5, offer.isVisible());
        preparedStatement.setInt(6, offer.getTerm());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        pool.releaseConnection(connection);
    }

    @Override
    public Offer extractOffer(int id) throws SQLException {
        ConnectionPool pool = DatabasePool.getConnectionPool();
        Connection connection = pool.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from offers where id = " + id);
        if(resultSet.next()) {
            Offer offer = new Offer(resultSet.getInt(1),
                    resultSet.getInt(2),
                    resultSet.getString(3),
                    resultSet.getBigDecimal(4),
                    resultSet.getInt(5),
                    resultSet.getBoolean(6),
                    resultSet.getInt(7));
            statement.close();
            pool.releaseConnection(connection);
            return offer;
        }
        pool.releaseConnection(connection);
        return null;
    }

    @Override
    public void updateOffer(Offer offer, int id) throws SQLException {
        ConnectionPool pool = DatabasePool.getConnectionPool();
        Connection connection = pool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("update offers set insurance_type_id = ?, description = ?, cost = ?, insurer_id = ?, visible = ?, term = ? where id = ?");
        preparedStatement.setInt(1, offer.getInsuranceTypeId());
        preparedStatement.setString(2, offer.getDescription());
        preparedStatement.setBigDecimal(3, offer.getCost());
        preparedStatement.setInt(4, offer.getInsurerId());
        preparedStatement.setBoolean(5, offer.isVisible());
        preparedStatement.setInt(6, offer.getTerm());
        preparedStatement.setInt(7, id);

        preparedStatement.executeUpdate();
        preparedStatement.close();
        pool.releaseConnection(connection);
    }

    @Override
    public void deleteOffer(int id) throws SQLException {
        ConnectionPool pool = DatabasePool.getConnectionPool();
        Connection connection = pool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("delete from offers where id = ?");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        DatabasePool.getConnectionPool().releaseConnection(connection);
    }

    @Override
    public ArrayList<Offer> listOffer() throws SQLException {
        ArrayList<Offer> list = new ArrayList<>();
        ConnectionPool pool = DatabasePool.getConnectionPool();
        Connection connection = pool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from offers");
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()) {
            Offer offer = new Offer(resultSet.getInt(1),
                    resultSet.getInt(2),
                    resultSet.getString(3),
                    resultSet.getBigDecimal(4),
                    resultSet.getInt(5),
                    resultSet.getBoolean(6),
                    resultSet.getInt(7));
            list.add(offer);
        }
        pool.releaseConnection(connection);
        return list;
    }

    @Override
    public ArrayList<Offer> listInsurerOffer(int insurer_id) throws SQLException {
        ArrayList<Offer> list = new ArrayList<>();
        ConnectionPool pool = DatabasePool.getConnectionPool();
        Connection connection = pool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from offers where insurer_id = " + insurer_id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()) {
            Offer offer = new Offer(resultSet.getInt(1),
                    resultSet.getInt(2),
                    resultSet.getString(3),
                    resultSet.getBigDecimal(4),
                    resultSet.getInt(5),
                    resultSet.getBoolean(6),
                    resultSet.getInt(7));
            list.add(offer);
        }
        pool.releaseConnection(connection);
        return list;
    }

    @Override
    public ArrayList<Offer> listTypeOffer(int insurance_type_id) throws SQLException {
        ArrayList<Offer> list = new ArrayList<>();
        ConnectionPool pool = DatabasePool.getConnectionPool();
        Connection connection = pool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from offers where insurance_type_id = " + insurance_type_id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()) {
            Offer offer = new Offer(resultSet.getInt(1),
                    resultSet.getInt(2),
                    resultSet.getString(3),
                    resultSet.getBigDecimal(4),
                    resultSet.getInt(5),
                    resultSet.getBoolean(6),
                    resultSet.getInt(7));
            list.add(offer);
        }
        pool.releaseConnection(connection);
        return list;
    }
}
