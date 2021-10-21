package ru.vironit.app.dao.implementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ru.vironit.app.dao.interfaces.LicenceInterface;
import ru.vironit.app.dao.utils.DatabasePool;
import ru.vironit.app.dao.utils.HibernateUtil;
import ru.vironit.app.entities.Client;
import ru.vironit.app.entities.Licence;
import ru.vironit.app.entities.Role;

import java.sql.*;

public class LicenceImplementation implements LicenceInterface {

    @Override
    public void addLicence(Licence licence) throws SQLException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(licence);
        transaction.commit();
        session.close();
    }

    @Override
    public Licence extractLicence(int id) throws SQLException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Licence licence = session.get(Licence.class, id);
        transaction.commit();
        session.close();
        return licence;
    }

    @Override
    public void updateLicence(Licence licence, int id) throws SQLException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(licence);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteLicence(int id) throws SQLException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Licence licence = session.get(Licence.class, id);
        session.delete(licence);
        transaction.commit();
        session.close();
    }

    @Override
    public Licence checkLicence(int insurerId) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Licence where insurerId=:insurerId");
        query.setParameter("insurerId", insurerId);
        Licence licence = (Licence) query.uniqueResult();
        session.close();
        return licence;
    }
}
