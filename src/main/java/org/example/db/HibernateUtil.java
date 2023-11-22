package org.example.db;

import org.example.db.entities.EmployeeEntity;
import org.example.db.entities.PatientEntity;
import org.example.db.entities.WardEntity;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(EmployeeEntity.class);
                configuration.addAnnotatedClass(PatientEntity.class);
                configuration.addAnnotatedClass(WardEntity.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        return sessionFactory;
    }
}
