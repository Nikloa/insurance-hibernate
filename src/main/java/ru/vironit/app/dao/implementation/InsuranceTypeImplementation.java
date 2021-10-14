package ru.vironit.app.dao.implementation;

import ru.vironit.app.dao.interfaces.ConnectionPool;
import ru.vironit.app.dao.interfaces.InsuranceTypeInterface;
import ru.vironit.app.dao.utils.DatabasePool;
import ru.vironit.app.entities.InsuranceType;

import java.sql.*;
import java.util.ArrayList;

public class InsuranceTypeImplementation implements InsuranceTypeInterface {

    @Override
    public void addInsuranceType(InsuranceType type) throws SQLException {
        ConnectionPool pool = DatabasePool.getConnectionPool();
        Connection connection = pool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into insurance_type (insurance_type) values (?)");
        preparedStatement.setString(1, type.getInsuranceType());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        pool.releaseConnection(connection);
    }

    @Override
    public InsuranceType extractInsuranceType(int id) throws SQLException {
        ConnectionPool pool = DatabasePool.getConnectionPool();
        Connection connection = pool.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from insurance_type where id = " + id);
        if(resultSet.next()) {
            InsuranceType type = new InsuranceType(resultSet.getInt(1),
                    resultSet.getString(2));
            statement.close();
            pool.releaseConnection(connection);
            return type;
        }
        pool.releaseConnection(connection);
        return null;
    }

    @Override
    public void updateInsuranceType(InsuranceType type, int id) throws SQLException {
        ConnectionPool pool = DatabasePool.getConnectionPool();
        Connection connection = pool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("update insurance_type set insurance_type = ? where id = ?");
        preparedStatement.setString(1, type.getInsuranceType());
        preparedStatement.setInt(2, id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        pool.releaseConnection(connection);
    }

    @Override
    public void deleteInsuranceType(int id) throws SQLException {
        ConnectionPool pool = DatabasePool.getConnectionPool();
        Connection connection = pool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("delete from insurance_type where id = ?");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        pool.releaseConnection(connection);
    }

    @Override
    public ArrayList<InsuranceType> allInsuranceType() throws SQLException {
        ArrayList<InsuranceType> list = new ArrayList<>();
        ConnectionPool pool = DatabasePool.getConnectionPool();
        Connection connection = pool.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from insurance_type");
        while(resultSet.next()) {
            InsuranceType type = new InsuranceType(resultSet.getInt(1),
                    resultSet.getString(2));
            list.add(type);
        }
        statement.close();
        pool.releaseConnection(connection);
        return list;
    }
}
