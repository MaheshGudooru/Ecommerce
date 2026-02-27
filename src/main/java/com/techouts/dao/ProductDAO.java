package com.techouts.dao;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.query.Query;

import com.techouts.entities.Product;
import com.techouts.utils.hibernateutil.HibernateUtil;

public class ProductDAO {

    public static List<Product> getProductsList() {

        String hql = "FROM Product";

        try (Session session = HibernateUtil.getHibernateSession()) {

            Query<Product> query = session.createQuery(hql, Product.class);

            return query.setCacheable(true).list();
            
        } catch (Exception e) {
            System.err.println(e);
        }

        return new ArrayList<>();

    }

    public static Product getProductById(int id) {

        try (Session session = HibernateUtil.getHibernateSession()) {

            Product product = session.get(Product.class, id);

            return product;
            
        } catch (Exception e) {
            
            System.err.println(e);

        }

        return null;

    }

}
