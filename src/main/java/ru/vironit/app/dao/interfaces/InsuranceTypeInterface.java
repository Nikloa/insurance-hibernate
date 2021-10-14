package ru.vironit.app.dao.interfaces;

import ru.vironit.app.entities.InsuranceType;

import java.sql.SQLException;
import java.util.ArrayList;

public interface InsuranceTypeInterface {

    void addInsuranceType(InsuranceType type) throws SQLException;
    InsuranceType extractInsuranceType(int id) throws SQLException;
    void updateInsuranceType(InsuranceType type, int id) throws SQLException;
    void deleteInsuranceType(int id) throws SQLException;
    ArrayList<InsuranceType> allInsuranceType() throws SQLException;

}
