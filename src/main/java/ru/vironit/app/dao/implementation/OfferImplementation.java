package ru.vironit.app.dao.implementation;

import ru.vironit.app.dao.interfaces.OfferInterface;
import ru.vironit.app.dao.utils.DatabasePool;
import ru.vironit.app.entities.Offer;

import java.sql.*;
import java.util.ArrayList;

public class OfferImplementation implements OfferInterface {

    @Override
    public void addOffer(Offer offer) throws SQLException {
        Connection connection = DatabasePool.getConnectionPool().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into offers (insurance_type_id, description, term, cost, insurer_id) values (?, ?, ?, ?, ?)");
        preparedStatement.setInt(1, offer.getInsuranceType());
        preparedStatement.setString(2, offer.getDescription());
        preparedStatement.setDate(3, offer.getTerm());
        preparedStatement.setBigDecimal(4, offer.getCost());
        preparedStatement.setInt(5, offer.getInsurerId());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        DatabasePool.getConnectionPool().releaseConnection(connection);
    }

    @Override
    public Offer extractOffer(int id) throws SQLException {
        Connection connection = DatabasePool.getConnectionPool().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from offers where id = " + id);
        resultSet.next();
        Offer offer = new Offer(resultSet.getInt(1),
                resultSet.getInt(2),
                resultSet.getString(3),
                resultSet.getDate(4),
                resultSet.getBigDecimal(5),
                resultSet.getInt(6));
        statement.close();
        DatabasePool.getConnectionPool().releaseConnection(connection);
        return offer;
    }

    @Override
    public void updateOffer(Offer offer, int id) throws SQLException {
        Connection connection = DatabasePool.getConnectionPool().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("update offers set insurance_type_id = ?, description = ?, term = ?, cost = ?, insurer_id = ? where id = ?");
        preparedStatement.setInt(1, offer.getInsuranceType());
        preparedStatement.setString(2, offer.getDescription());
        preparedStatement.setDate(3, offer.getTerm());
        preparedStatement.setBigDecimal(4, offer.getCost());
        preparedStatement.setInt(5, offer.getInsurerId());
        preparedStatement.setInt(6, id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        DatabasePool.getConnectionPool().releaseConnection(connection);
    }

    @Override
    public void deleteOffer(int id) throws SQLException {
        Connection connection = DatabasePool.getConnectionPool().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("delete from offers where id = ?");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        DatabasePool.getConnectionPool().releaseConnection(connection);
    }

    @Override
    public ArrayList<Offer> listOffer() throws SQLException {
        ArrayList<Offer> list = new ArrayList<>();
        Connection connection = DatabasePool.getConnectionPool().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from offers");
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()) {
            Offer offer = new Offer(resultSet.getInt(1),
                    resultSet.getInt(2),
                    resultSet.getString(3),
                    resultSet.getDate(4),
                    resultSet.getBigDecimal(5),
                    resultSet.getInt(6));
            list.add(offer);
        }
        return list;
    }
}
