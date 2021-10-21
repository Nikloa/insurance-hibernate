package ru.vironit.app.dao.implementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ru.vironit.app.dao.interfaces.AdminInterface;
import ru.vironit.app.dao.utils.DatabasePool;
import ru.vironit.app.dao.utils.HibernateUtil;
import ru.vironit.app.entities.Admin;
import ru.vironit.app.entities.Client;
import ru.vironit.app.entities.Role;

import java.sql.*;

public class AdminImplementation implements AdminInterface {

    @Override
    public void addAdmin(Admin admin) throws SQLException {
        //sessionFactory = new Configuration().configure().buildSessionFactory();
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(admin);
        transaction.commit();
        session.close();
    }

    @Override
    public Admin extractAdmin(int id) throws SQLException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Admin admin = session.get(Admin.class, id);
        admin.setRole(Role.ADMIN);
        transaction.commit();
        session.close();
        return admin;
    }

    @Override
    public void updateAdmin(Admin admin, int id) throws SQLException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(admin);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteAdmin(int id) throws SQLException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Admin admin = session.get(Admin.class, id);
        session.delete(admin);
        transaction.commit();
        session.close();
    }

    @Override
    public boolean checkAdmin(String email) throws SQLException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Client where email=:email");
        query.setParameter("email", email);
        Client client = (Client) query.uniqueResult();
        session.close();
        if(client == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Admin loginAdmin(String email, String password) throws SQLException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Admin where email=:email and password=:password");
        query.setParameter("email", email);
        query.setParameter("password", password);
        Admin admin = (Admin) query.uniqueResult();
        session.close();
        return admin;
    }
}
