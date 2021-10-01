package ru.vironit.app.services;

import ru.vironit.app.dao.implementation.InsuranceTypeImplementation;
import ru.vironit.app.dao.interfaces.InsuranceTypeInterface;
import ru.vironit.app.entities.InsuranceType;

import java.sql.SQLException;

public class InsuranceTypeService implements InsuranceTypeInterface {

    private InsuranceTypeImplementation implementation;

    public InsuranceTypeService() {
        implementation = new InsuranceTypeImplementation();
    }

    @Override
    public void addInsuranceType(InsuranceType insuranceType) throws SQLException {
        implementation.addInsuranceType(insuranceType);
    }

    @Override
    public InsuranceType extractInsuranceType(int id) throws SQLException {
        InsuranceType insuranceType = implementation.extractInsuranceType(id);
        return insuranceType;
    }

    @Override
    public void updateInsuranceType(InsuranceType insuranceType, int id) throws SQLException {
        implementation.updateInsuranceType(insuranceType, id);
    }

    @Override
    public void deleteInsuranceType(int id) throws  SQLException {
        implementation.deleteInsuranceType(id);
    }
}
