package ru.vironit.app.dao.implementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.vironit.app.dao.interfaces.ReviewInterface;
import ru.vironit.app.dao.utils.DatabasePool;
import ru.vironit.app.dao.utils.HibernateUtil;
import ru.vironit.app.entities.Client;
import ru.vironit.app.entities.Review;
import ru.vironit.app.entities.Role;

import java.sql.*;

public class ReviewImplementation implements ReviewInterface {

    @Override
    public void addReview(Review review) throws SQLException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(review);
        transaction.commit();
        session.close();
    }


    @Override
    public Review extractReview(int id) throws SQLException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Review review = session.get(Review.class, id);
        transaction.commit();
        session.close();
        return review;
    }

    @Override
    public void updateReview(Review review, int id) throws SQLException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(review);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteReview(int id) throws SQLException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Review review = session.get(Review.class, id);
        session.delete(review);
        transaction.commit();
        session.close();
    }
}
