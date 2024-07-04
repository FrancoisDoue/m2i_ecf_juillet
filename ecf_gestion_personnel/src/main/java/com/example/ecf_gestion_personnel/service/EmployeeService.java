package com.example.ecf_gestion_personnel.service;

import com.example.ecf_gestion_personnel.model.Employee;
import com.example.ecf_gestion_personnel.repository.impl.EmployeeRepository;
import com.example.ecf_gestion_personnel.util.HibernateManager;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService() {
        this.employeeRepository = new EmployeeRepository(HibernateManager.getFactory());
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(int id) {
        return employeeRepository.find(id);
    }

    public Employee createEmployee(Employee employee) {
        int id = employeeRepository.create(employee).getId();
        return employeeRepository.find(id);
    }

    public Employee updateEmployee(int id, Employee employee) {
        employee.setId(id);
        employeeRepository.update(employee);
        return getEmployeeById(id);
    }

    public void deleteEmployee(int id) {
        employeeRepository.delete(
                employeeRepository.find(id)
        );
    }

    public Employee patchEmployee(int id, Employee employee) {
        Employee emp = employeeRepository.find(id);
        if (emp != null) {
            if (employee.getFirstname() != null) emp.setFirstname(employee.getFirstname());
            if (employee.getLastname() != null) emp.setFirstname(employee.getLastname());
            if (employee.getEmail() != null) emp.setEmail(employee.getEmail());
            if (employee.getPhone() != null) emp.setPhone(employee.getPhone());
            if (employee.getDepartment() != null) emp.setDepartment(employee.getDepartment());
            if (employee.getPosition() != null) emp.setPosition(employee.getPosition());
            employeeRepository.update(emp);
            return getEmployeeById(id);
        }
        return null;
    }

}
