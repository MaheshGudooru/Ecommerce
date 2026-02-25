package com.techouts;

import com.techouts.entities.User;
import com.techouts.utils.hibernateutil.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class App
{
    public static void main( String[] args )
    {

        try(Session session = HibernateUtil.getHibernateSession ()) {

            Transaction tx = session.beginTransaction ();

            User user = new User ();
            user.setName ("mahesh");
            user.setEmail ("mahesh@gmail.com");
            user.setPassword ("Mahesh123");

            session.persist (user);

            tx.commit ();

            session.close ();

            System.out.println ("Transaction successful!!!");

        }
    }
}
