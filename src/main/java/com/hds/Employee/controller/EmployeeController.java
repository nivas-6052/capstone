package com.hds.Employee.controller;

import com.hds.Employee.model.Employee;
import com.hds.Employee.service.EmployeeService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
@Api(tags = "Employee API")
@CrossOrigin(origins = "http://localhost:4200")
@SwaggerDefinition(tags = {
        @Tag(name = "Employee Management", description = "Endpoints for managing employee details")})
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @ApiOperation(value = "Get all employee details", notes = "Retrieves a list of all employee details.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list of employee details"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    @GetMapping()
    public ResponseEntity<List<Employee>> getAllDetails() {
        try {
            List<Employee> employees = employeeService.getAllDetails();
            return ResponseEntity.ok(employees);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @ApiOperation(value = "Create new employee details", notes = "Creates a new employee details.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Employee details created successfully"),
            @ApiResponse(code = 400, message = "Invalid request"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    @PostMapping()
    public ResponseEntity<Employee> createDetails(@RequestBody Employee employee) {
        try {
            Employee createdEmployee = employeeService.createDetails(employee);
            return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @ApiOperation(value = "Get employee details by ID", notes = "Retrieves employee details for a given employee ID.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved employee details"),
            @ApiResponse(code = 404, message = "Employee details not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getDetailsById(@PathVariable Long id) {
        try {
            Employee employee = employeeService.getDetailsById(id);
            if (employee == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return ResponseEntity.ok(employee);
        } catch (Exception e) {
             e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
