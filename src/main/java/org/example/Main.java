package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Aleins a1 = new Aleins();
        Laptop l1 = new Laptop();
        l1.setBrand("Asus");
        l1.setModel("ROG");
        l1.setRam(16);
        a1.setAid(100);
        a1.setAname("Harsh");
        a1.setTech("java");
        a1.setLaptop(l1);


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
                .configure()
                .buildSessionFactory();       //cfg.buildSessionFactory();
        Session session = sf.openSession();
        //session.merge(s1); //to update a record

        //s1 = session.get(Student.class,3);
        Transaction transaction = session.beginTransaction();
        session.persist(a1);
        //transaction is needed to add the data it is not required for fetching the data
       // session.remove(s1); //to delete a record
        // to fetch the data just commment out the treansaction
       // session.persist(s1);
        transaction.commit();

        //s2 = session.get(Student.class,3); //to access a particular record
        session.close();
        sf.close();
        //System.out.println(s1);
      //  System.out.println(s1);

    }
}