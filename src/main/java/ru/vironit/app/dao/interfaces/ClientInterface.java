package ru.vironit.app.dao.interfaces;

import ru.vironit.app.entities.Client;

import java.sql.SQLException;

public interface ClientInterface {

    void addClient(Client client) throws SQLException;
    Client extractClient(int id) throws SQLException;
    void updateClient(Client newClient, int oldId) throws SQLException;
    void deleteClient(int id) throws SQLException;
    Client checkClient(String email) throws SQLException;
    boolean loginClient(String email, String password) throws SQLException;
    int parsePhone(String phone);

}
