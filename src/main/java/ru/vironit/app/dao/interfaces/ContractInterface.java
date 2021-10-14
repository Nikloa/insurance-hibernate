package ru.vironit.app.dao.interfaces;

import ru.vironit.app.entities.Contract;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ContractInterface {

    void addContract(Contract contract) throws SQLException;
    Contract extractContract(int id) throws SQLException;
    void updateContract(Contract contract, int id) throws SQLException;
    void deleteContract(int id) throws SQLException;
    ArrayList<Contract> listClientContract(int id) throws SQLException;
    int countContract(int insurer_id) throws SQLException;

}
