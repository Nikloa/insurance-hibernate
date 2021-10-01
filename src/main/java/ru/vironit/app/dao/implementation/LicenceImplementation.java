package ru.vironit.app.dao.implementation;

import ru.vironit.app.dao.interfaces.LicenceInterface;
import ru.vironit.app.dao.utils.DatabasePool;
import ru.vironit.app.entities.Licence;

import java.sql.*;

public class LicenceImplementation implements LicenceInterface {

    @Override
    public void addLicence(Licence licence) throws SQLException {
        Connection connection = DatabasePool.getConnectionPool().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into contracts (insurer_id, insurer_name, address, taxpayer_identification_number, licence_number, issue_decision_date, issue_decision_number, confirmation) values (?, ?, ?, ?, ?, ?, ?, ?)");
        preparedStatement.setInt(1, licence.getInsurerId());
        preparedStatement.setString(2, licence.getInsurerName());
        preparedStatement.setString(3, licence.getAddress());
        preparedStatement.setInt(4, licence.getTaxpayerIdentificationNumber());
        preparedStatement.setString(5, licence.getLicenceNumber());
        preparedStatement.setDate(6, licence.getIssueDecisionDate());
        preparedStatement.setInt(7, licence.getIssueDecisionNumber());
        preparedStatement.setBoolean(8, licence.isConfirmation());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        DatabasePool.getConnectionPool().releaseConnection(connection);
    }

    @Override
    public Licence extractLicence(int id) throws SQLException {
        Connection connection = DatabasePool.getConnectionPool().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from licences where id = " + id);
        resultSet.next();
        Licence licence = new Licence(resultSet.getInt(1),
                resultSet.getInt(2),
                resultSet.getString(3),
                resultSet.getString(4),
                resultSet.getInt(5),
                resultSet.getString(6),
                resultSet.getDate(7),
                resultSet.getInt(8),
                resultSet.getBoolean(9));
        statement.close();
        DatabasePool.getConnectionPool().releaseConnection(connection);
        return licence;
    }

    @Override
    public void updateLicence(Licence licence, int id) throws SQLException {
        Connection connection = DatabasePool.getConnectionPool().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("update licences set insurer_id = ?, insurer_name = ?, address = ?, taxpayer_identification_number = ?, licence_number = ?, issue_decision_date = ?, isuue_decision_number = ?, confirmation = ? where id = ?");
        preparedStatement.setInt(1, licence.getInsurerId());
        preparedStatement.setString(2, licence.getInsurerName());
        preparedStatement.setString(3, licence.getAddress());
        preparedStatement.setInt(4, licence.getTaxpayerIdentificationNumber());
        preparedStatement.setString(5, licence.getLicenceNumber());
        preparedStatement.setDate(6, licence.getIssueDecisionDate());
        preparedStatement.setInt(7, licence.getIssueDecisionNumber());
        preparedStatement.setBoolean(8, licence.isConfirmation());
        preparedStatement.setInt(9, id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        DatabasePool.getConnectionPool().releaseConnection(connection);
    }

    @Override
    public void deleteLicence(int id) throws SQLException {
        Connection connection = DatabasePool.getConnectionPool().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("delete from licences where id = ?");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        DatabasePool.getConnectionPool().releaseConnection(connection);
    }
}
