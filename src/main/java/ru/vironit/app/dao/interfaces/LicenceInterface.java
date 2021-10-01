package ru.vironit.app.dao.interfaces;

import ru.vironit.app.entities.Licence;

import java.sql.SQLException;

public interface LicenceInterface {

    void addLicence(Licence licence) throws SQLException;
    Licence extractLicence(int id) throws SQLException;
    void updateLicence(Licence licence, int id) throws SQLException;
    void deleteLicence(int id) throws SQLException;
}
