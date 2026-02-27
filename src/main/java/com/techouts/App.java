package com.techouts;

import com.techouts.entities.Product;
import com.techouts.utils.enums.Category;
import com.techouts.utils.hibernateutil.HibernateUtil;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class App {

    public static void main(String[] args) {

        List<Product> products = Arrays.asList(

                new Product("iPhone 15 Pro", 999.99f, 25,
                        "Latest Apple smartphone with advanced camera system.",
                        Category.ELECTRONICS,
                        "https://images.unsplash.com/photo-1695048133142-1a20484a0c35"),

                new Product("Samsung 55\" 4K Smart TV", 699.99f, 18,
                        "Ultra HD Smart LED TV with streaming apps.",
                        Category.ELECTRONICS,
                        "https://images.unsplash.com/photo-1593784991095-a205069470b6"),

                new Product("Sony Wireless Headphones", 199.99f, 45,
                        "Noise-cancelling over-ear Bluetooth headphones.",
                        Category.ELECTRONICS,
                        "https://images.unsplash.com/photo-1518444065439-e933c06ce9cd"),

                new Product("Gaming Laptop RTX 4060", 1299.99f, 10,
                        "High-performance gaming laptop with RTX graphics.",
                        Category.ELECTRONICS,
                        "https://images.unsplash.com/photo-1517336714731-489689fd1ca8"),

                new Product("Men's Running Shoes", 79.99f, 60,
                        "Lightweight breathable running shoes.",
                        Category.FASHION,
                        "https://images.unsplash.com/photo-1542291026-7eec264c27ff"),

                new Product("Women's Handbag", 59.99f, 35,
                        "Stylish leather handbag for daily use.",
                        Category.FASHION,
                        "https://images.unsplash.com/photo-1584917865442-de89df76afd3"),

                new Product("Men's Casual T-Shirt", 19.99f, 120,
                        "Comfortable cotton casual t-shirt.",
                        Category.FASHION,
                        "https://images.unsplash.com/photo-1520975916090-3105956dac38"),

                new Product("Air Fryer 5L", 89.99f, 30,
                        "Healthy cooking air fryer.",
                        Category.HOME_GARDEN,
                        "https://images.unsplash.com/photo-1604908176997-125f25cc6f3d"),

                new Product("Wooden Dining Table", 399.99f, 8,
                        "Solid wood dining table for 6 people.",
                        Category.HOME_GARDEN,
                        "https://images.unsplash.com/photo-1505691938895-1758d7feb511"),

                new Product("Office Chair Ergonomic", 149.99f, 22,
                        "Adjustable ergonomic office chair.",
                        Category.HOME_GARDEN,
                        "https://images.unsplash.com/photo-1580480055273-228ff5388ef8"),

                new Product("Vitamin C Serum", 19.99f, 100,
                        "Brightening skincare serum.",
                        Category.HEALTH_BEAUTY,
                        "https://images.unsplash.com/photo-1608248597279-f99d160bfcbc"),

                new Product("Hair Dryer Professional", 39.99f, 55,
                        "Fast-drying salon-quality hair dryer.",
                        Category.HEALTH_BEAUTY,
                        "https://images.unsplash.com/photo-1585238342028-4e7c1a0b1e66"),

                new Product("Electric Toothbrush", 49.99f, 75,
                        "Rechargeable electric toothbrush.",
                        Category.HEALTH_BEAUTY,
                        "https://images.unsplash.com/photo-1559599101-f09722fb4948"),

                new Product("LEGO Classic Set", 39.99f, 60,
                        "Creative building blocks set.",
                        Category.TOYS_KIDS,
                        "https://images.unsplash.com/photo-1587654780291-39c9404d746b"),

                new Product("Remote Control Car", 29.99f, 90,
                        "High-speed RC car for kids.",
                        Category.TOYS_KIDS,
                        "https://images.unsplash.com/photo-1596462502278-27bfdc403348"),

                new Product("Barbie Doll", 24.99f, 70,
                        "Classic Barbie doll with accessories.",
                        Category.TOYS_KIDS,
                        "https://images.unsplash.com/photo-1587300003388-59208cc962cb"),

                new Product("Mountain Bike 29\"", 499.99f, 15,
                        "Durable aluminum mountain bike.",
                        Category.SPORTS_OUTDOORS,
                        "https://images.unsplash.com/photo-1507035895480-2b3156c31fc8"),

                new Product("Yoga Mat Premium", 29.99f, 70,
                        "Eco-friendly non-slip yoga mat.",
                        Category.SPORTS_OUTDOORS,
                        "https://images.unsplash.com/photo-1599058917212-d750089bc07e"),

                new Product("Football Size 5", 19.99f, 110,
                        "Professional training football.",
                        Category.SPORTS_OUTDOORS,
                        "https://images.unsplash.com/photo-1517649763962-0c623066013b"),

                new Product("Camping Tent 4-Person", 129.99f, 20,
                        "Waterproof outdoor camping tent.",
                        Category.SPORTS_OUTDOORS,
                        "https://images.unsplash.com/photo-1504280390368-361c6d9f38f4"),

                new Product("Organic Basmati Rice 5kg", 24.99f, 80,
                        "Premium long-grain rice.",
                        Category.GROCERIES,
                        "https://images.unsplash.com/photo-1586201375761-83865001e17b"),

                new Product("Arabica Coffee Beans 1kg", 18.99f, 95,
                        "Fresh roasted premium coffee beans.",
                        Category.GROCERIES,
                        "https://images.unsplash.com/photo-1509042239860-f550ce710b93"),

                new Product("Olive Oil Extra Virgin", 14.99f, 65,
                        "Cold-pressed extra virgin olive oil.",
                        Category.GROCERIES,
                        "https://images.unsplash.com/photo-1474979266404-7eaacbcd87c5"),

                new Product("Atomic Habits Book", 14.99f, 120,
                        "Self-improvement bestseller.",
                        Category.BOOKS_MEDIA,
                        "https://images.unsplash.com/photo-1512820790803-83ca734da794"),

                new Product("Noise Cancelling Earbuds", 89.99f, 50,
                        "True wireless noise-cancelling earbuds.",
                        Category.ELECTRONICS,
                        "https://images.unsplash.com/photo-1585386959984-a4155224a1ad"),

                new Product("Bluetooth Speaker", 59.99f, 50,
                        "Portable waterproof speaker.",
                        Category.ELECTRONICS,
                        "https://images.unsplash.com/photo-1583225153295-dfa4c0c7d5c6"),

                new Product("Cookware Set 10pcs", 119.99f, 25,
                        "Non-stick cookware set.",
                        Category.HOME_GARDEN,
                        "https://images.unsplash.com/photo-1584990347449-ae0b3a3e2a13"),

                new Product("Face Moisturizer Cream", 22.99f, 85,
                        "Hydrating daily face cream.",
                        Category.HEALTH_BEAUTY,
                        "https://images.unsplash.com/photo-1556228453-efd6c1ff04f6"),

                new Product("Children Story Book", 9.99f, 150,
                        "Illustrated bedtime story book.",
                        Category.BOOKS_MEDIA,
                        "https://images.unsplash.com/photo-1544947950-fa07a98d237f"),

                new Product("Fitness Dumbbell Set", 79.99f, 40,
                        "Adjustable home gym dumbbells.",
                        Category.SPORTS_OUTDOORS,
                        "https://images.unsplash.com/photo-1599058945522-28d584b6f0ff")

        );

        try (Session session = HibernateUtil.getHibernateSession()) {

            Transaction tx = session.beginTransaction();

            for (Product product : products) {
                session.persist(product);
            }

            tx.commit();

            session.close();

            System.out.println("Transaction successful!!!");

        }
    }
}
