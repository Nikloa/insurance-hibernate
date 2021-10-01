package ru.vironit.app.dao.interfaces;

import ru.vironit.app.entities.Contract;

import java.sql.SQLException;

public interface ContractInterface {

    void addContract(Contract contract) throws SQLException;
    Contract extractContract(int id) throws SQLException;
    void updateContract(Contract contract, int id) throws SQLException;
    void deleteContract(int id) throws SQLException;
}
