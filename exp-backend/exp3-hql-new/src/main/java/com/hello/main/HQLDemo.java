package com.hello.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hello.model.Product;

import java.util.List;

public class HQLDemo {

    public static void main(String[] args) {

        SessionFactory factory =
                new Configuration().configure().buildSessionFactory();

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        // Insert records
        session.save(new Product(1,"Laptop",60000,10));
        session.save(new Product(2,"Phone",30000,15));
        session.save(new Product(3,"Tablet",20000,7));
        session.save(new Product(4,"Mouse",1500,25));
        session.save(new Product(5,"Keyboard",2500,30));

        tx.commit();

        System.out.println("\n===== SORTING ASCENDING =====");
        Query<Product> q1 = session.createQuery(
                "from Product order by price asc", Product.class);

        List<Product> list1 = q1.list();

        for(Product p : list1)
            System.out.println(p);


        System.out.println("\n===== SORTING DESCENDING =====");
        Query<Product> q2 = session.createQuery(
                "from Product order by price desc", Product.class);

        List<Product> list2 = q2.list();

        for(Product p : list2)
            System.out.println(p);


        System.out.println("\n===== PAGINATION (First 3 products) =====");
        Query<Product> q3 = session.createQuery(
                "from Product", Product.class);

        q3.setFirstResult(0);
        q3.setMaxResults(3);

        List<Product> list3 = q3.list();

        for(Product p : list3)
            System.out.println(p);


        System.out.println("\n===== COUNT PRODUCTS =====");
        Query<Long> q4 = session.createQuery(
                "select count(*) from Product", Long.class);

        System.out.println("Total Products: " + q4.uniqueResult());


        System.out.println("\n===== MAX PRICE =====");
        Query<Double> q5 = session.createQuery(
                "select max(price) from Product", Double.class);

        System.out.println("Max Price: " + q5.uniqueResult());


        System.out.println("\n===== MIN PRICE =====");
        Query<Double> q6 = session.createQuery(
                "select min(price) from Product", Double.class);

        System.out.println("Min Price: " + q6.uniqueResult());


        System.out.println("\n===== GROUP BY QUANTITY =====");
        Query<Object[]> q7 = session.createQuery(
                "select quantity, count(*) from Product group by quantity",
                Object[].class);

        List<Object[]> list7 = q7.list();

        for(Object[] row : list7)
            System.out.println("Quantity: " + row[0] + " Count: " + row[1]);


        System.out.println("\n===== LIKE QUERY (Names starting with K) =====");
        Query<Product> q8 = session.createQuery(
                "from Product where name like 'K%'", Product.class);

        List<Product> list8 = q8.list();

        for(Product p : list8)
            System.out.println(p);


        session.close();
        factory.close();
    }
}