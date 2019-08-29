package com.databasesandlife.hibernatereconnectdemo;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class App {
    @SuppressWarnings("InfiniteLoopStatement") 
    public static void main(String[] args) throws Exception {
        while (true) {
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                // start a transaction
                final Transaction transaction = session.beginTransaction();
                boolean committed = false;
                try {
                    // save the student objects
                    var query = session.createQuery(
                        "select count(*) from MyThing thing");
                    Long count = (Long) query.uniqueResult();
                    System.out.println("Count=" + count);
                    
                    transaction.commit();
                    committed = true;
                }
                finally { if (!committed) transaction.rollback(); }
            }
            Thread.sleep(5_000L);
        }
    }
}