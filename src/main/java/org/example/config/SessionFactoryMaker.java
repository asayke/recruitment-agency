package org.example.config;

import org.example.entity.Candidate;
import org.example.entity.Vacancy;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryMaker {
    private static SessionFactory factory;

    private static void configureFactory() {
        try {
            factory = new Configuration()
                    .addAnnotatedClass(Candidate.class)
                    .addAnnotatedClass(Vacancy.class)
                    .configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static org.hibernate.SessionFactory getFactory() {
        if (factory == null) configureFactory();

        return factory;
    }
}