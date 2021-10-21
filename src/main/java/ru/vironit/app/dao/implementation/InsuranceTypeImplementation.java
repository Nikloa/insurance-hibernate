package ru.vironit.app.dao.implementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ru.vironit.app.dao.interfaces.ConnectionPool;
import ru.vironit.app.dao.interfaces.InsuranceTypeInterface;
import ru.vironit.app.dao.utils.DatabasePool;
import ru.vironit.app.dao.utils.HibernateUtil;
import ru.vironit.app.entities.Client;
import ru.vironit.app.entities.InsuranceType;
import ru.vironit.app.entities.Offer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InsuranceTypeImplementation implements InsuranceTypeInterface {

    @Override
    public void addInsuranceType(InsuranceType type) throws SQLException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(type);
        transaction.commit();
        session.close();
    }

    @Override
    public InsuranceType extractInsuranceType(int id) throws SQLException {
        //SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        InsuranceType insuranceType = session.get(InsuranceType.class, id);
        transaction.commit();
        session.close();
        return insuranceType;
    }

    @Override
    public void updateInsuranceType(InsuranceType type, int id) throws SQLException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(type);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteInsuranceType(int id) throws SQLException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        InsuranceType type = session.get(InsuranceType.class, id);
        session.delete(type);
        transaction.commit();
        session.close();
    }

    @Override
    public ArrayList<InsuranceType> allInsuranceType() throws SQLException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List insuranceType = session.createQuery("from InsuranceType ").list();
        transaction.commit();
        session.close();
        return (ArrayList<InsuranceType>) insuranceType;
    }
}
