package ru.vironit.app.dao.implementation;

import ru.vironit.app.dao.interfaces.PassportInterface;
import ru.vironit.app.dao.utils.DatabasePool;
import ru.vironit.app.entities.Passport;

import java.sql.*;

public class PassportImplementation implements PassportInterface {

    @Override
    public void addPassport(Passport passport) throws SQLException {
        Connection connection = DatabasePool.getConnectionPool().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into passports (client_id, first_name, last_name, birth_date, passport_number, identification_number, issue_date, issuing_authority, confirmation) values (?, ?, ?, ?, ?, ?, ?, ?, ?)");
        preparedStatement.setInt(1, passport.getClientId());
        preparedStatement.setString(2, passport.getFirstName());
        preparedStatement.setString(3, passport.getLastName());
        preparedStatement.setDate(4, passport.getBirthDate());
        preparedStatement.setString(5, passport.getPassportNumber());
        preparedStatement.setString(6, passport.getIdentificationNumber());
        preparedStatement.setDate(7, passport.getIssueDate());
        preparedStatement.setString(8, passport.getIssuingAuthority());
        preparedStatement.setBoolean(9, passport.isConfirmation());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        DatabasePool.getConnectionPool().releaseConnection(connection);
    }


    @Override
    public Passport extractPassport(int id) throws SQLException {
        Connection connection = DatabasePool.getConnectionPool().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from passports where id = " + id);
        if(resultSet.next()) {
            Passport passport = new Passport(resultSet.getInt(1),
                    resultSet.getInt(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getDate(5),
                    resultSet.getString(6),
                    resultSet.getString(7),
                    resultSet.getDate(8),
                    resultSet.getString(9),
                    resultSet.getBoolean(11));
            statement.close();
            DatabasePool.getConnectionPool().releaseConnection(connection);
            return passport;
        }
        return null;
    }

    @Override
    public void updatePassport(Passport passport, int id) throws SQLException {
        Connection connection = DatabasePool.getConnectionPool().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("update passports set client_id = ?, first_name = ?, last_name = ?, birth_date = ?, passport_number = ?, identification_number = ?, issue_date = ?, issuing_authority = ?, confirmation = ? where id = ?");
        preparedStatement.setInt(1, passport.getClientId());
        preparedStatement.setString(2, passport.getFirstName());
        preparedStatement.setString(3, passport.getLastName());
        preparedStatement.setDate(4, passport.getBirthDate());
        preparedStatement.setString(5, passport.getPassportNumber());
        preparedStatement.setString(6, passport.getIdentificationNumber());
        preparedStatement.setDate(7, passport.getIssueDate());
        preparedStatement.setString(8, passport.getIssuingAuthority());
        preparedStatement.setBoolean(9, passport.isConfirmation());
        preparedStatement.setInt(10, id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        DatabasePool.getConnectionPool().releaseConnection(connection);
    }

    @Override
    public void deletePassport(int id) throws SQLException {
        Connection connection = DatabasePool.getConnectionPool().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("delete from passports where id = ?");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        DatabasePool.getConnectionPool().releaseConnection(connection);
    }
}
