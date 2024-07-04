package com.example.ecf_gestion_personnel.model.map;

import com.example.ecf_gestion_personnel.model.Employee;

public class EmployeeMapper {
    public static Employee toDTO(Employee employee) {
        return Employee.builder()
                .id(employee.getId())
                .firstname(employee.getFirstname())
                .lastname(employee.getLastname())
                .email(employee.getEmail())
                .phone(employee.getPhone())
                .build();
    }
}
