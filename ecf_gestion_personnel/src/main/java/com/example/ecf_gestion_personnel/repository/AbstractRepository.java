package com.example.ecf_gestion_personnel.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public abstract class AbstractRepository<T, ID> {
    protected SessionFactory sessionFactory;
    protected Session session;

    public AbstractRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public T create(T entity) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            session.persist(entity);
            session.getTransaction().commit();
            return entity;
        } catch (RuntimeException e) {
            System.out.println("Exception occured: " + e);
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
    }

    public T update(T entity) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            session.merge(entity);
            session.getTransaction().commit();
            return entity;
        } catch (RuntimeException e) {
            System.out.println("Exception occured: " + e);
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
    }

    public void delete(T entity) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            session.remove(entity);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            System.out.println("Exception occured: " + e);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    public abstract T find(ID id);

    public abstract List<T> findAll();
}
