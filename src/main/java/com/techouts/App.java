package com.techouts;

import com.techouts.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class App
{
    public static void main( String[] args )
    {
        Configuration cfg = new Configuration ().configure ("hibernate.cfg.xml");


        SessionFactory sessionFactory = cfg.buildSessionFactory ();


        try {

            Session session = sessionFactory.openSession ();

            Transaction tx = session.beginTransaction ();

            User user = new User ();
            user.setName ("mahesh");
            user.setEmail ("mahesh@gmail.com");
            user.setPassword ("Mahesh123");

            session.persist (user);

            tx.commit ();

            session.close ();

            System.out.println ("Transaction successful!!!");

        } finally {

            sessionFactory.close ();
        }
    }
}
