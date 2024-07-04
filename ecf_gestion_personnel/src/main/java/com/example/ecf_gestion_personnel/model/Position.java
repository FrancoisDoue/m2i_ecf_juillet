package com.example.ecf_gestion_personnel.model;

import com.example.ecf_gestion_personnel.model.map.PositionMapper;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Position implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true, name = "job_title")
    private String jobTitle;

    @OneToMany(mappedBy = "position", fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    private List<Employee> employees;

    public List<Employee> getEmployees() {
        if (employees == null) return null;
        return employees.stream().map(Employee::toDTO).toList();
    }

    public Position toDTO() {
        return PositionMapper.toDTO(this);
    }

    @PreRemove
    public void preRemove() {
        System.out.println("on preRemove Position");
        if (employees != null)
            employees.forEach(e -> e.setPosition(null));
    }

}
