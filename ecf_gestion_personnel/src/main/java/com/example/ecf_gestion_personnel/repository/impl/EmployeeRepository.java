package com.example.ecf_gestion_personnel.repository.impl;

import com.example.ecf_gestion_personnel.model.Employee;
import com.example.ecf_gestion_personnel.repository.AbstractRepository;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.UUID;

public class EmployeeRepository extends AbstractRepository<Employee, Integer> {

    public EmployeeRepository(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Employee find(Integer id) {
        session = sessionFactory.openSession();
        Employee employee = session.get(Employee.class, id);
        session.close();
        return employee;
    }


    @Override
    public List<Employee> findAll() {
        session = sessionFactory.openSession();
        List<Employee> employees = session.createQuery("from Employee", Employee.class).getResultList();
        session.close();
        return employees;
    }
}
