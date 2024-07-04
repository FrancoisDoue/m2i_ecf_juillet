package com.example.ecf_gestion_personnel.controller;

import com.example.ecf_gestion_personnel.model.Department;
import com.example.ecf_gestion_personnel.model.Employee;
import com.example.ecf_gestion_personnel.model.map.DepartmentMapper;
import com.example.ecf_gestion_personnel.service.DepartmentService;
import com.example.ecf_gestion_personnel.service.EmployeeService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/departments")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DepartmentResource {

    private final DepartmentService departmentService;
    private final EmployeeService employeeService;

    @Inject
    public DepartmentResource(DepartmentService departmentService, EmployeeService employeeService) {
        this.departmentService = departmentService;
        this.employeeService = employeeService;
    }

    @GET
    public List<Department> getAll() {
        return departmentService.getAllDepartments();
    }

    @POST
    public Response createDepartment(Department department) {
        Department createdDepartment = departmentService.createDepartment(department);
        return Response.status(Response.Status.CREATED).entity(createdDepartment).build();
    }

    @GET
    @Path("/{id}")
    public Department getDepartment(@PathParam("id") int id) {
        return departmentService.getDepartmentById(id);
    }

    @PUT
    @Path("/{id}")
    public Department updateDepartment(@PathParam("id") int id, Department department) {
        return departmentService.updateDepartment(id, department);
    }

    @DELETE
    @Path("/{id}")
    public Response deleteDepartment(@PathParam("id") int id) {
        departmentService.deleteDepartment(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

//    @POST
//    @Path("/{id}/add")
//    public Response addEmployee(@PathParam("id") int id, Employee employee) {
//        employee = employeeService.getEmployeeById(employee.getId());
//        if (employee == null) return Response.status(Response.Status.NOT_FOUND).build();
//        Department dep = departmentService.addEmployeToDepartment(id, employee);
//        return Response
//                .status(Response.Status.CREATED)
//                .entity(dep)
//                .build();
//    }

}
