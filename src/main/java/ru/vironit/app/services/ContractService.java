package ru.vironit.app.services;

import ru.vironit.app.dao.implementation.ContractImplementation;
import ru.vironit.app.dao.interfaces.ContractInterface;
import ru.vironit.app.entities.Contract;

import java.sql.SQLException;
import java.util.ArrayList;

public class ContractService implements ContractInterface {

    private ContractImplementation implementation;

    public ContractService() {
        implementation = new ContractImplementation();
    }

    @Override
    public void addContract(Contract contract) throws SQLException {
        implementation.addContract(contract);
    }

    @Override
    public Contract extractContract(int id) throws SQLException {
        Contract contract = implementation.extractContract(id);
        return contract;
    }

    @Override
    public void updateContract(Contract contract, int id) throws SQLException {
        implementation.updateContract(contract, id);
    }

    @Override
    public void deleteContract(int id) throws  SQLException {
        implementation.deleteContract(id);

    }

    @Override
    public ArrayList<Contract> listClientContract(int id) throws SQLException {
        return implementation.listClientContract(id);
    }

    @Override
    public int countContract(int insurer_id) throws SQLException {
        return implementation.countContract(insurer_id);
    }
}
