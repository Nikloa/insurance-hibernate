package ru.vironit.app.dao.implementation;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import ru.vironit.app.dao.interfaces.ConnectionPool;
import ru.vironit.app.dao.interfaces.InsurerInterface;
import ru.vironit.app.dao.utils.DatabasePool;
import ru.vironit.app.dao.utils.HibernateUtil;
import ru.vironit.app.entities.Client;
import ru.vironit.app.entities.InsuranceType;
import ru.vironit.app.entities.Insurer;
import ru.vironit.app.entities.Role;

import java.sql.*;

public class InsurerImplementation implements InsurerInterface {

    @Override
    public void addInsurer(Insurer insurer) throws SQLException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(insurer);
        transaction.commit();
        session.close();
    }

    @Override
    public Insurer extractInsurer(int id) throws SQLException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Insurer insurer = session.get(Insurer.class, id);
        insurer.setRole(Role.INSURER);
        transaction.commit();
        session.close();
        return insurer;
    }

    @Override
    public void updateInsurer(Insurer insurer) throws SQLException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(insurer);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteInsurer(int id) throws SQLException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Insurer insurer = session.get(Insurer.class, id);
        session.delete(insurer);
        transaction.commit();
        session.close();
    }

    @Override
    public boolean checkInsurer(String email) throws SQLException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Insurer where email=:email");
        query.setParameter("email", email);
        Insurer insurer = (Insurer) query.uniqueResult();
        session.close();
        if(insurer == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Insurer loginInsurer(String email, String password) throws SQLException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Insurer where email=:email and password=:password");
        query.setParameter("email", email);
        query.setParameter("password", password);
        Insurer insurer = (Insurer) query.uniqueResult();
        session.close();
        return insurer;
    }

    @Override
    public int parsePhone(String phone) {
        String numb = "0123456789";
        String phoneString = "";
        if(phoneString != phone) {
            for (int i = 4; i < phone.length(); i++) {
                for (int j = 0; j < 10; j++) {
                    if(phone.charAt(i) == numb.charAt(j)) {
                        phoneString += numb.charAt(j);
                    }
                }
            }
            return Integer.parseInt(phoneString);
        }
        return 0;
    }
}
