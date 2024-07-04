package com.example.ecf_gestion_personnel.model.map;

import com.example.ecf_gestion_personnel.model.Department;

public class DepartmentMapper {
    public static Department toDTO(Department department) {
        Department departmentDTO = new Department();
        departmentDTO.setId(department.getId());
        departmentDTO.setName(department.getName());
        return departmentDTO;
    }
}
