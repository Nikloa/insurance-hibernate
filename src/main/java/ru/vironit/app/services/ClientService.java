package ru.vironit.app.services;

import ru.vironit.app.dao.implementation.ClientImplementation;
import ru.vironit.app.dao.interfaces.ClientInterface;
import ru.vironit.app.entities.Client;

import java.sql.SQLException;

public class ClientService implements ClientInterface {

    private ClientImplementation implementation;

    public ClientService() {
        implementation = new ClientImplementation();
    }

    @Override
    public void addClient(Client client) throws SQLException {
        implementation.addClient(client);
    }

    @Override
    public Client extractClient(int id) throws SQLException {
        Client client = implementation.extractClient(id);
        return client;
    }

    @Override
    public void updateClient(Client client, int id) throws SQLException {
        implementation.updateClient(client, id);
    }

    @Override
    public void deleteClient(int id) throws  SQLException {
        implementation.deleteClient(id);
    }
}
