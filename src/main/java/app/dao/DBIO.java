package app.dao;

import app.entities.Client;
import app.entities.Insurer;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DBIO {

    public void addClient(Client client) throws SQLException {
        DBCPDataSource.getStatement().executeUpdate("insert into clients (nickname, email, password, phone, balance, rating)" +
                "values ('" + client.getNickname() + "', '" + client.getEmail() + "', '" + client.getPassword() + "', " +
                client.getPhone() + ", " + client.getBalance() + ", " + client.getRating() + ")");
    }

    public Client extractClient(int id) throws SQLException {
        ResultSet resultSet = DBCPDataSource.getStatement().executeQuery("select * from clients where id = " + id);
        resultSet.next();
        Client client = new Client(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4),
                resultSet.getInt(5), resultSet.getBigDecimal(6), resultSet.getDouble(7));
        return client;
    }

    public void updateClient(Client newClient, int oldId) throws SQLException {
        DBCPDataSource.getStatement().executeUpdate("update clients set nickname = '" + newClient.getNickname() + "', email = '" + newClient.getEmail() + "', password = '" +
                newClient.getPassword() + "', phone = " + newClient.getPhone() + ", balance = " + newClient.getBalance() + ", rating = " + newClient.getRating() + " where id = " + oldId);
    }

    public void addInsurer(Insurer client) throws SQLException {
        DBCPDataSource.getStatement().executeUpdate("insert into insurers (nickname, email, password, short_company_name, information_phone, raiting)" +
                "values ('" + client.getNickname() + "', '" + client.getEmail() + "', '" + client.getPassword() + "', " +
                client.getCompanyName() + ", " + client.getPhone() + ", " + client.getRating() + ")");
    }

    public Insurer extractInsurer(int id) throws SQLException {
        ResultSet resultSet = DBCPDataSource.getStatement().executeQuery("select * from insurers where id = " + id);
        resultSet.next();
        Insurer insurer = new Insurer(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4),
                resultSet.getString(5), resultSet.getInt(6), resultSet.getDouble(7));
        return insurer;
    }

    public void updateInsurer(Insurer newInsurer, int oldId) throws SQLException {
        DBCPDataSource.getStatement().executeUpdate("update insurers set nickname = '" + newInsurer.getNickname() + "', email = '" + newInsurer.getEmail() + "', password = '" +
                newInsurer.getPassword() + "', short_company_name = " + newInsurer.getCompanyName() + ", information_phone = " + newInsurer.getPhone() + ", raiting = " + newInsurer.getRating() + " where id = " + oldId);
    }
}
