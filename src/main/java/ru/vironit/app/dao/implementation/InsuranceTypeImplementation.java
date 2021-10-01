package ru.vironit.app.dao.implementation;

import ru.vironit.app.dao.interfaces.InsuranceTypeInterface;
import ru.vironit.app.dao.utils.DatabasePool;
import ru.vironit.app.entities.InsuranceType;

import java.sql.*;

public class InsuranceTypeImplementation implements InsuranceTypeInterface {

    @Override
    public void addInsuranceType(InsuranceType type) throws SQLException {
        Connection connection = DatabasePool.getConnectionPool().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into insurance_type (insurance_type) values (?)");
        preparedStatement.setString(1, type.getInsuranceType());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        DatabasePool.getConnectionPool().releaseConnection(connection);
    }

    @Override
    public InsuranceType extractInsuranceType(int id) throws SQLException {
        Connection connection = DatabasePool.getConnectionPool().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from insurance_type where id = " + id);
        resultSet.next();
        InsuranceType type = new InsuranceType(resultSet.getInt(1),
                resultSet.getString(2));
        statement.close();
        DatabasePool.getConnectionPool().releaseConnection(connection);
        return type;
    }

    @Override
    public void updateInsuranceType(InsuranceType type, int id) throws SQLException {
        Connection connection = DatabasePool.getConnectionPool().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("update insurance_type set insurance_type = ? where id = ?");
        preparedStatement.setString(1, type.getInsuranceType());
        preparedStatement.setInt(2, id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        DatabasePool.getConnectionPool().releaseConnection(connection);
    }

    @Override
    public void deleteInsuranceType(int id) throws SQLException {
        Connection connection = DatabasePool.getConnectionPool().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("delete from insurance_type where id = ?");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        DatabasePool.getConnectionPool().releaseConnection(connection);
    }
}
