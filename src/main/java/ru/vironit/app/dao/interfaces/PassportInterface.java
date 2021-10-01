package ru.vironit.app.dao.interfaces;

import ru.vironit.app.entities.Passport;

import java.sql.SQLException;

public interface PassportInterface {

    void addPassport(Passport passport) throws SQLException;
    Passport extractPassport(int id) throws SQLException;
    void updatePassport(Passport passport, int id) throws SQLException;
    void deletePassport(int id) throws SQLException;
}
