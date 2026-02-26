package com.techouts.utils.hibernateutil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public final class HibernateUtil {

    private HibernateUtil() {
    }

    private static SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
            .buildSessionFactory();

    public static Session getHibernateSession() {

        return sessionFactory.openSession();
    }

    public static void shutdown() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }

}
