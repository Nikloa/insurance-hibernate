package ru.vironit.app.dao.implementation;

import ru.vironit.app.dao.interfaces.ContractInterface;
import ru.vironit.app.dao.utils.DatabasePool;
import ru.vironit.app.entities.Contract;

import java.sql.*;

public class ContractImplementation implements ContractInterface {

    @Override
    public void addContract(Contract contract) throws SQLException {
        Connection connection = DatabasePool.getConnectionPool().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into contracts (contract_date, insurer_confirm_status, insurer_confirm_payment_status, client_incedent_status, insurer_confirm_incedent_status, client_pay_status, client_id, offer_id) values (?, ?, ?, ?, ?, ?, ?, ?)");
        preparedStatement.setDate(1, contract.getDate());
        preparedStatement.setBoolean(2, contract.isInsurerConfirmContractStatus());
        preparedStatement.setBoolean(3, contract.isInsurerConfirmPaymentStatus());
        preparedStatement.setBoolean(4, contract.isClientIncidentStatus());
        preparedStatement.setBoolean(5, contract.isInsurerConfirmIncidentStatus());
        preparedStatement.setBoolean(6, contract.isClientConfirmPaymentStatus());
        preparedStatement.setInt(7, contract.getClientId());
        preparedStatement.setInt(8, contract.getOfferId());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        DatabasePool.getConnectionPool().releaseConnection(connection);
    }

    @Override
    public Contract extractContract(int id) throws SQLException {
        Connection connection = DatabasePool.getConnectionPool().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from contracts where id = " + id);
        resultSet.next();
        Contract admin = new Contract(resultSet.getInt(1),
                resultSet.getDate(2),
                resultSet.getBoolean(3),
                resultSet.getBoolean(4),
                resultSet.getBoolean(5),
                resultSet.getBoolean(6),
                resultSet.getBoolean(7),
                resultSet.getInt(8),
                resultSet.getInt(9));
        statement.close();
        DatabasePool.getConnectionPool().releaseConnection(connection);
        return admin;
    }

    @Override
    public void updateContract(Contract contract, int id) throws SQLException {
        Connection connection = DatabasePool.getConnectionPool().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("update contracts set contract_date = ?, insurer_confirm_contract_status = ?, insurer_confirm_payment_status = ?, client_incedent_status = ?, insurer_confirm_incedent_status = ?, client_pay_status = ?, client_id = ?, offer_id where id = ?");
        preparedStatement.setDate(1, contract.getDate());
        preparedStatement.setBoolean(2, contract.isInsurerConfirmContractStatus());
        preparedStatement.setBoolean(3, contract.isClientConfirmPaymentStatus());
        preparedStatement.setBoolean(4, contract.isClientIncidentStatus());
        preparedStatement.setBoolean(5, contract.isInsurerConfirmIncidentStatus());
        preparedStatement.setBoolean(6, contract.isClientConfirmPaymentStatus());
        preparedStatement.setInt(7, contract.getClientId());
        preparedStatement.setInt(8, contract.getOfferId());
        preparedStatement.setInt(9, id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        DatabasePool.getConnectionPool().releaseConnection(connection);
    }

    @Override
    public void deleteContract(int id) throws SQLException {
        Connection connection = DatabasePool.getConnectionPool().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("delete from contracts where id = ?");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        DatabasePool.getConnectionPool().releaseConnection(connection);
    }
}
