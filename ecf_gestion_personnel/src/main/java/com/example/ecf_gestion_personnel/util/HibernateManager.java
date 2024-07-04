package com.example.ecf_gestion_personnel.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public final class HibernateManager {

    private static SessionFactory factory;

    private HibernateManager() {}

    public static synchronized SessionFactory getFactory() {
        if (factory == null) {
            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
            factory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
        }
        return factory;
    }

}
