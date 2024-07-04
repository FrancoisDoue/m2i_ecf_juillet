package com.example.ecf_gestion_personnel.model;

import com.example.ecf_gestion_personnel.model.map.DepartmentMapper;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.annotation.PreDestroy;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Department implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "department", fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    private List<Employee> employees;

    public List<Employee> getEmployees() {
        if (employees == null) return null;
        return employees.stream().map(Employee::toDTO).toList();
    }

    public Department toDTO() {
        return DepartmentMapper.toDTO(this);
    }

    @PreDestroy
    public void preDestroy() {
        if (employees != null)
            employees.forEach(e -> e.setDepartment(null));
    }
}
