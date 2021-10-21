package ru.vironit.app.dao.implementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ru.vironit.app.dao.interfaces.ContractInterface;
import ru.vironit.app.dao.utils.DatabasePool;
import ru.vironit.app.dao.utils.HibernateUtil;
import ru.vironit.app.entities.Client;
import ru.vironit.app.entities.Contract;
import ru.vironit.app.entities.Offer;
import ru.vironit.app.entities.Role;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class ContractImplementation implements ContractInterface {

    @Override
    public void addContract(Contract contract) throws SQLException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        System.out.println("Contract Implementation " + contract.toString());
        session.save(contract);
        transaction.commit();
        session.close();
    }

    @Override
    public Contract extractContract(int id) throws SQLException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Contract contract = session.get(Contract.class, id);
        transaction.commit();
        session.close();
        return contract;
    }

    @Override
    public void updateContract(Contract contract, int id) throws SQLException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(contract);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteContract(int id) throws SQLException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Contract contract = session.get(Contract.class, id);
        session.delete(contract);
        transaction.commit();
        session.close();
    }

    @Override
    public ArrayList<Contract> listClientContract(int id) throws SQLException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Contract where clientId=:clientId");
        query.setParameter("clientId", id);
        ArrayList<Contract> list = (ArrayList<Contract>) query.list();
        session.close();
        return list;
    }

    @Override
    public int countContract(int offer_id) throws SQLException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        LocalDate date = LocalDate.now();
        Query query = session.createQuery("select count(*) from Contract where offerId=:offerId");
        query.setParameter("offerId", offer_id);
        int count = (int) query.uniqueResult();
        session.close();
        return count;
    }
}
