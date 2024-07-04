package com.example.ecf_gestion_personnel.controller;

import com.example.ecf_gestion_personnel.model.Employee;
import com.example.ecf_gestion_personnel.service.EmployeeService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Path("/employees")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmployeeResource {

    private final EmployeeService employeeService;

    @Inject
    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GET
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GET
    @Path("/search")
    public List<Employee> getEmployeesByCriteria(
            @QueryParam("position") String position,
            @QueryParam("department") String department,
            @QueryParam("firstname") String firstname,
            @QueryParam("lastname") String lastname
    ) {
        List<Employee> employees = employeeService.getAllEmployees();
        if (position != null && !position.isEmpty())
            employees = employees.stream().filter(e -> e.getPosition().getJobTitle().toLowerCase().contains(position.toLowerCase())).toList();
        if (department != null && !department.isEmpty())
            employees = employees.stream().filter(e -> e.getDepartment().getName().toLowerCase().contains(department.toLowerCase())).toList();
        if (firstname != null && !firstname.isEmpty())
            employees = employees.stream().filter(e -> e.getFirstname().toLowerCase().contains(firstname.toLowerCase())).toList();
        if (lastname != null && !lastname.isEmpty())
            employees = employees.stream().filter(e -> e.getLastname().toLowerCase().contains(lastname.toLowerCase())).toList();
        return employees;
    }

    @POST
    public Response createEmployee(Employee employee) {
        Employee createdEmployee = employeeService.createEmployee(employee);
        return Response.status(Response.Status.CREATED).entity(createdEmployee).build();
    }

    @GET
    @Path("/{id}")
    public Employee getEmployee(@PathParam("id") int id) {
        return employeeService.getEmployeeById(id);
    }

    @PUT
    @Path("/{id}")
    public Employee updateEmployee(@PathParam("id") int id, Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }

    @PATCH
    @Path("/{id}")
    public Employee patchEmployee(@PathParam("id") int id, Employee employee) {
        return employeeService.patchEmployee(id, employee);
    }

    @DELETE
    @Path("/{id}")
    public Response deleteEmployee(@PathParam("id") int id) {
        employeeService.deleteEmployee(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

}
