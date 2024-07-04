package com.example.ecf_gestion_personnel.repository.impl;

import com.example.ecf_gestion_personnel.model.Department;
import com.example.ecf_gestion_personnel.repository.AbstractRepository;
import org.hibernate.SessionFactory;

import java.util.List;

public class DepartmentRepository extends AbstractRepository<Department, Integer> {

    public DepartmentRepository(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Department find(Integer id) {
        session = sessionFactory.openSession();
        Department department = session.get(Department.class, id);
        session.close();
        return department;
    }

    @Override
    public List<Department> findAll() {
        session = sessionFactory.openSession();
        List<Department> departments = session.createQuery("from Department", Department.class).getResultList();
        session.close();
        return departments;
    }
}
