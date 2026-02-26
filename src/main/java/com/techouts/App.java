package com.techouts;

import com.techouts.entities.Product;
import com.techouts.utils.enums.Category;
import com.techouts.utils.hibernateutil.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class App {

    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();

        products.add(new Product("Smartphone X1", 699.99f, 50, "Latest smartphone with OLED display", Category.ELECTRONICS, "https://images.pexels.com/photos/1092671/pexels-photo-1092671.jpeg")); // phone :contentReference[oaicite:1]{index=1}
        products.add(new Product("Laptop Pro 15", 1299.99f, 30, "High performance laptop for professionals", Category.ELECTRONICS, "https://images.pexels.com/photos/18105/pexels-photo.jpg")); // laptop :contentReference[oaicite:2]{index=2}
        products.add(new Product("Wireless Headphones", 199.99f, 100, "Noise cancelling over-ear headphones", Category.ELECTRONICS, "https://images.pexels.com/photos/339465/pexels-photo-339465.jpeg")); // headphones :contentReference[oaicite:3]{index=3}
        products.add(new Product("Fitness Tracker", 99.99f, 75, "Track your activity and sleep", Category.HEALTH_BEAUTY, "https://images.pexels.com/photos/266678/pexels-photo-266678.jpeg")); // fitness wearable :contentReference[oaicite:4]{index=4}
        products.add(new Product("Smartwatch S3", 249.99f, 40, "Smartwatch with health monitoring", Category.ELECTRONICS, "https://images.pexels.com/photos/277406/pexels-photo-277406.jpeg")); // smartwatch :contentReference[oaicite:5]{index=5}

        products.add(new Product("Cotton T-Shirt", 19.99f, 200, "Comfortable cotton t-shirt", Category.FASHION, "https://images.pexels.com/photos/428338/pexels-photo-428338.jpeg")); // clothes :contentReference[oaicite:6]{index=6}
        products.add(new Product("Jeans Slim Fit", 49.99f, 120, "Stylish slim fit jeans", Category.FASHION, "https://images.pexels.com/photos/2983464/pexels-photo-2983464.jpeg")); // jeans :contentReference[oaicite:7]{index=7}
        products.add(new Product("Leather Jacket", 199.99f, 25, "Premium leather jacket", Category.FASHION, "https://images.pexels.com/photos/994517/pexels-photo-994517.jpeg")); // jacket :contentReference[oaicite:8]{index=8}

        products.add(new Product("Yoga Mat", 25.99f, 100, "Eco-friendly yoga mat", Category.SPORTS_OUTDOORS, "https://images.pexels.com/photos/4324025/pexels-photo-4324025.jpeg")); // yoga gear :contentReference[oaicite:9]{index=9}
        products.add(new Product("Mountain Bike", 499.99f, 15, "Durable mountain bike for adventure", Category.SPORTS_OUTDOORS, "https://images.pexels.com/photos/276517/pexels-photo-276517.jpeg")); // bike :contentReference[oaicite:10]{index=10}

        products.add(new Product("Organic Honey", 12.99f, 150, "Pure organic honey", Category.GROCERIES, "https://images.pexels.com/photos/128321/pexels-photo-128321.jpeg")); // groceries :contentReference[oaicite:11]{index=11}
        products.add(new Product("Coffee Beans 1kg", 24.99f, 80, "Premium roasted coffee beans", Category.GROCERIES, "https://images.pexels.com/photos/585750/pexels-photo-585750.jpeg")); // coffee :contentReference[oaicite:12]{index=12}

        products.add(new Product("Science Fiction Novel", 14.99f, 60, "Bestselling sci-fi novel", Category.BOOKS_MEDIA, "https://images.pexels.com/photos/46274/pexels-photo-46274.jpeg")); // books :contentReference[oaicite:13]{index=13}
        products.add(new Product("Cookbook Deluxe", 29.99f, 40, "Delicious recipes from around the world", Category.BOOKS_MEDIA, "https://images.pexels.com/photos/590493/pexels-photo-590493.jpeg")); // cookbook :contentReference[oaicite:14]{index=14}

        products.add(new Product("Perfume Luxury", 79.99f, 35, "Premium fragrance for men and women", Category.HEALTH_BEAUTY, "https://images.pexels.com/photos/2362454/pexels-photo-2362454.jpeg")); // perfume :contentReference[oaicite:15]{index=15}
        products.add(new Product("Hair Dryer Pro", 49.99f, 70, "Fast drying professional hair dryer", Category.HEALTH_BEAUTY, "https://images.pexels.com/photos/367986/pexels-photo-367986.jpeg")); // hair dryer :contentReference[oaicite:16]{index=16}

        products.add(new Product("Desk Lamp LED", 34.99f, 50, "Adjustable LED desk lamp", Category.HOME_GARDEN, "https://images.pexels.com/photos/590493/pexels-photo-590493.jpeg")); // lamp (reuse) :contentReference[oaicite:17]{index=17}
        products.add(new Product("Sneakers Running", 59.99f, 80, "Lightweight running sneakers", Category.FASHION, "https://images.pexels.com/photos/19090/pexels-photo.jpg")); // shoes :contentReference[oaicite:18]{index=18}
        products.add(new Product("Kids Puzzle", 19.99f, 100, "Fun educational puzzle for kids", Category.TOYS_KIDS, "https://images.pexels.com/photos/1735480/pexels-photo-1735480.jpeg")); // toys :contentReference[oaicite:19]{index=19}

        products.add(new Product("Misc Gadget", 9.99f, 200, "Useful everyday gadget", Category.OTHERS, "https://images.pexels.com/photos/1714208/pexels-photo-1714208.jpeg")); // miscellaneous :contentReference[oaicite:20]{index=20}


        try (Session session = HibernateUtil.getHibernateSession()) {

            Transaction tx = session.beginTransaction();

            for(Product product : products) {
                session.persist(product);
            }

            tx.commit();

            session.close();

            System.out.println("Transaction successful!!!");

        }
    }
}
