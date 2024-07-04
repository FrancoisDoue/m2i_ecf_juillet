package com.example.ecf_gestion_personnel.service;

import com.example.ecf_gestion_personnel.model.Department;
import com.example.ecf_gestion_personnel.model.Employee;
import com.example.ecf_gestion_personnel.repository.impl.DepartmentRepository;
import com.example.ecf_gestion_personnel.util.HibernateManager;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService() {
        this.departmentRepository = new DepartmentRepository(HibernateManager.getFactory());
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(int id) {
        return departmentRepository.find(id);
    }

    public Department createDepartment(Department department) {
        return departmentRepository.create(department);
    }

    public Department updateDepartment(int id, Department department) {
        department.setId(id);
        return departmentRepository.update(department);
    }

    public void deleteDepartment(int id) {
        departmentRepository.delete(
                departmentRepository.find(id)
        );
    }

    public Department addEmployeToDepartment(int departmentId, Employee employee) {
        Department department = departmentRepository.find(departmentId);
        department.getEmployees().add(employee);
        departmentRepository.create(department);
        return getDepartmentById(departmentId);
    }

}
