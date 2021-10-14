package ru.vironit.app.services;

import ru.vironit.app.dao.implementation.PassportImplementation;
import ru.vironit.app.dao.interfaces.PassportInterface;
import ru.vironit.app.entities.Passport;

import java.sql.SQLException;

public class PassportService implements PassportInterface {

    private PassportImplementation implementation;

    public PassportService() {
        implementation = new PassportImplementation();
    }

    @Override
    public void addPassport(Passport passport) throws SQLException {
        implementation.addPassport(passport);

    }

    @Override
    public Passport extractPassport(int id) throws SQLException {
        Passport passport = implementation.extractPassport(id);
        return passport;
    }

    @Override
    public void updatePassport(Passport passport, int id) throws SQLException {
        implementation.updatePassport(passport, id);
    }

    @Override
    public void deletePassport(int id) throws  SQLException {
        implementation.deletePassport(id);
    }
}
