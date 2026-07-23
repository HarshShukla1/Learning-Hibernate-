package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Aleins a1 = new Aleins();
        Laptop l1 = new Laptop();
        l1.setLid(1);
        l1.setBrand("Asus");
        l1.setModel("ROG");
        l1.setRam(16);

        Laptop l2 = new Laptop();
        l2.setLid(2);
        l2.setBrand("Lenovo");
        l2.setModel("Thinkpad");
        l2.setRam(16);

        Laptop l3 = new Laptop();
        l3.setLid(3);
        l3.setBrand("Asus");
        l3.setModel("ROG");
        l3.setRam(32);

        Aleins a2 = new Aleins();

        a1.setAid(100);
        a1.setAname("Harsh");
        a1.setTech("java");

        a2.setAid(101);
        a2.setAname("Ayush");
        a2.setTech("c++");

        Aleins a3 = new Aleins();

        a3.setAid(102);
        a3.setAname("Abhishek");
        a3.setTech("REACT");


        a1.setLaptops(Arrays.asList(l1,l2));
        a2.setLaptops(Arrays.asList(l2,l3));
        a3.setLaptops(Arrays.asList(l1));

        l1.setAleins(Arrays.asList(a1,a2));
        l2.setAleins(Arrays.asList(a2,a3));
        l3.setAleins(Arrays.asList(a1));




//    Student s1 = new Student();
//  s1.setSname("Harsh");
//   s1.setsAge(24);
//  s1.setRollNo(1);

   // Student s2 = null;


//        Configuration cfg = new Configuration();
//        cfg.addAnnotatedClass(org.example.Student.class);
//        cfg.configure();
        SessionFactory sf = new Configuration()
                .addAnnotatedClass(org.example.Aleins.class)
                .addAnnotatedClass(org.example.Laptop.class)
                .configure()
                .buildSessionFactory();       //cfg.buildSessionFactory();
        Session session = sf.openSession();
        //session.merge(s1); //to update a record

        //s1 = session.get(Student.class,3);
        Transaction transaction = session.beginTransaction();
        session.persist(l1);
        session.persist(a1);
        session.persist(a2);
        session.persist(a3);
        session.persist(l2);
        session.persist(l3);

        //transaction is needed to add the data it is not required for fetching the data
       // session.remove(s1); //to delete a record
        // to fetch the data just commment out the treansaction
       // session.persist(s1);
        transaction.commit();

        Aleins a5 = session.get(Aleins.class,102);
        System.out.println(a5);

        //s2 = session.get(Student.class,3); //to access a particular record
        session.close();
        sf.close();
        //System.out.println(s1);
      //  System.out.println(s1);

    }
}