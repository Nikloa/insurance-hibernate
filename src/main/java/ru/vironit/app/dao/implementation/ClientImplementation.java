package ru.vironit.app.dao.implementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import ru.vironit.app.dao.interfaces.ClientInterface;
import ru.vironit.app.dao.utils.DatabasePool;
import ru.vironit.app.dao.utils.HibernateUtil;
import ru.vironit.app.entities.Client;
import ru.vironit.app.entities.Insurer;
import ru.vironit.app.entities.Role;

import java.sql.*;

public class ClientImplementation implements ClientInterface {

    @Override
    public void addClient(Client client) throws SQLException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(client);
        transaction.commit();
        session.close();
    }

    @Override
    public Client extractClient(int id) throws SQLException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Client client = session.get(Client.class, id);
        client.setRole(Role.CLIENT);
        transaction.commit();
        session.close();
        return client;
    }

    @Override
    public void updateClient(Client client, int id) throws SQLException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(client);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteClient(int id) throws SQLException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Client client = session.get(Client.class, id);
        session.delete(client);
        transaction.commit();
        session.close();
    }

    @Override
    public boolean checkClient(String email) throws SQLException {
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
    public Client loginClient(String email, String password) throws SQLException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Client where email=:email and password=:password");
        query.setParameter("email", email);
        query.setParameter("password", password);
        Client client = (Client) query.uniqueResult();
        session.close();
        return client;
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
