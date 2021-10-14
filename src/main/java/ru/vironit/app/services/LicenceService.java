package ru.vironit.app.services;

import ru.vironit.app.dao.implementation.LicenceImplementation;
import ru.vironit.app.dao.interfaces.LicenceInterface;
import ru.vironit.app.entities.Licence;

import java.sql.SQLException;

public class LicenceService implements LicenceInterface {

    private LicenceImplementation implementation;

    public LicenceService() {
        implementation = new LicenceImplementation();
    }

    @Override
    public void addLicence(Licence licence) throws SQLException {
        implementation.addLicence(licence);

    }

    @Override
    public Licence extractLicence(int id) throws SQLException {
        Licence licence = implementation.extractLicence(id);
        return licence;
    }

    @Override
    public void updateLicence(Licence licence, int id) throws SQLException {
        implementation.updateLicence(licence, id);
    }

    @Override
    public void deleteLicence(int id) throws  SQLException {
        implementation.deleteLicence(id);
    }
}
