package com.example.ecf_gestion_personnel.model;

import com.example.ecf_gestion_personnel.model.map.EmployeeMapper;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Employee implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String firstname;
    @Column(nullable = false)
    private String lastname;
    @Column(nullable = false)
    private String email;
    private String phone;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(foreignKey = @ForeignKey(
            name = "fk_employee_position",
            foreignKeyDefinition = "FOREIGN KEY (position_id) REFERENCES Position (id) ON UPDATE RESTRICT ON DELETE SET NULL"
        ),
        name = "position_id"
    )
    private Position position;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(foreignKey = @ForeignKey(
            name = "fk_employee_department",
            foreignKeyDefinition = "FOREIGN KEY (department_id) REFERENCES Department (id) ON UPDATE RESTRICT ON DELETE SET NULL"
        ),
        name = "department_id"
    )
    private Department department;

    public Position getPosition() {
        if (position == null) return null;
        return position.toDTO();
    }

    public Department getDepartment() {
        if (department == null) return null;
        return department.toDTO();
    }

    public Employee toDTO() {
        return EmployeeMapper.toDTO(this);
    }

}
