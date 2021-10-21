package ru.vironit.app.services;

import ru.vironit.app.dao.implementation.InsurerImplementation;
import ru.vironit.app.dao.interfaces.InsurerInterface;
import ru.vironit.app.entities.Insurer;

import java.sql.SQLException;

public class InsurerService implements InsurerInterface {

    private InsurerImplementation implementation;

    public InsurerService() {
        implementation = new InsurerImplementation();
    }

    @Override
    public void addInsurer(Insurer insurer) throws SQLException {
        implementation.addInsurer(insurer);
    }

    @Override
    public Insurer extractInsurer(int id) throws SQLException {
        Insurer insurer = implementation.extractInsurer(id);
        return insurer;
    }

    @Override
    public void updateInsurer(Insurer insurer) throws SQLException {
        implementation.updateInsurer(insurer);
    }

    @Override
    public void deleteInsurer(int id) throws SQLException {
        implementation.deleteInsurer(id);
    }

    @Override
    public boolean checkInsurer(String email) throws SQLException {
        return implementation.checkInsurer(email);

    }

    @Override
    public Insurer loginInsurer(String email, String password) throws SQLException {
        return implementation.loginInsurer(email, password);
    }

    @Override
    public int parsePhone(String phone) {
        return implementation.parsePhone(phone);
    }
}
