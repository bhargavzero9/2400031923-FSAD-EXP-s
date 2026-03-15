package com.hello.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hello.model.Product;

public class CRUDDemo {

    public static void main(String[] args) {

        SessionFactory factory =
                new Configuration().configure().buildSessionFactory();

        Session session = factory.openSession();

        Transaction tx = session.beginTransaction();

        Product p1 = new Product("Laptop","Dell Laptop",60000.0,10);
        Product p2 = new Product("Phone","Samsung Phone",30000.0,15);

        session.save(p1);
        session.save(p2);

        tx.commit();

        System.out.println("Products Inserted");

        Product product = session.get(Product.class,1);

        System.out.println(product);

        Transaction tx2 = session.beginTransaction();

        product.setPrice(55000.0);

        session.update(product);

        tx2.commit();

        System.out.println("Product Updated");

        session.close();
        factory.close();
    }
}