package ru.vironit.app.dao.implementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.vironit.app.dao.interfaces.PassportInterface;
import ru.vironit.app.dao.utils.DatabasePool;
import ru.vironit.app.dao.utils.HibernateUtil;
import ru.vironit.app.entities.Client;
import ru.vironit.app.entities.Passport;
import ru.vironit.app.entities.Role;

import java.sql.*;

public class PassportImplementation implements PassportInterface {

    @Override
    public void addPassport(Passport passport) throws SQLException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(passport);
        transaction.commit();
        session.close();
    }


    @Override
    public Passport extractPassport(int id) throws SQLException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Passport passport = session.get(Passport.class, id);
        transaction.commit();
        session.close();
        return passport;
    }

    @Override
    public void updatePassport(Passport passport, int id) throws SQLException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(passport);
        transaction.commit();
        session.close();
    }

    @Override
    public void deletePassport(int id) throws SQLException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Passport passport = session.get(Passport.class, id);
        session.delete(passport);
        transaction.commit();
        session.close();
    }
}
