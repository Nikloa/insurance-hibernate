package ru.vironit.app.dao.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import ru.vironit.app.entities.*;


public class HibernateUtil {

    private static SessionFactory sessionFactory;

    private HibernateUtil(){}

    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null) {
            try {
                /*
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Admin.class);
                configuration.addAnnotatedClass(Client.class);
                configuration.addAnnotatedClass(Contract.class);
                configuration.addAnnotatedClass(InsuranceType.class);
                configuration.addAnnotatedClass(Insurer.class);
                configuration.addAnnotatedClass(Licence.class);
                configuration.addAnnotatedClass(Offer.class);
                configuration.addAnnotatedClass(Passport.class);
                configuration.addAnnotatedClass(Review.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
                 */
                sessionFactory = new Configuration().configure().buildSessionFactory();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
