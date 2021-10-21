package ru.vironit.app.dao.implementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import ru.vironit.app.dao.interfaces.ConnectionPool;
import ru.vironit.app.dao.interfaces.OfferInterface;
import ru.vironit.app.dao.utils.DatabasePool;
import ru.vironit.app.dao.utils.HibernateUtil;
import ru.vironit.app.entities.Client;
import ru.vironit.app.entities.Offer;
import ru.vironit.app.entities.Role;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OfferImplementation implements OfferInterface {

    @Override
    public void addOffer(Offer offer) throws SQLException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(offer);
        transaction.commit();
        session.close();
    }


    @Override
    public Offer extractOffer(int id) throws SQLException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Offer offer = session.get(Offer.class, id);
        transaction.commit();
        session.close();
        return offer;
    }

    @Override
    public void updateOffer(Offer offer, int id) throws SQLException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(offer);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteOffer(int id) throws SQLException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Offer offer = session.get(Offer.class, id);
        session.delete(offer);
        transaction.commit();
        session.close();
    }

    @Override
    public ArrayList<Offer> listOffer() throws SQLException {
        //SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List offers = session.createQuery("from Offer").list();
        transaction.commit();
        session.close();
        return (ArrayList<Offer>) offers;
    }

    @Override
    public ArrayList<Offer> listInsurerOffer(int insurerId) throws SQLException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Offer where insurerId=:insurerId");
        query.setParameter("insurerId", insurerId);
        ArrayList<Offer> list = (ArrayList<Offer>) query.list();
        session.close();
        return list;
    }

    @Override
    public ArrayList<Offer> listTypeOffer(int insuranceTypeId) throws SQLException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Offer where insuranceTypeId=:insuranceTypeId");
        query.setParameter("insuranceTypeId", insuranceTypeId);
        ArrayList<Offer> list = (ArrayList<Offer>) query.list();
        session.close();
        return list;
    }
}
