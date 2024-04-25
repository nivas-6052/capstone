package com.hds.Employee.controller;

import com.hds.Employee.model.SkillEmployee;
import com.hds.Employee.service.SkillEmployeeService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/skillemp")
@CrossOrigin(origins = "http://localhost:4200")
@SwaggerDefinition(tags = {
        @Tag(name = "Employee Skill Management", description = "Endpoints for employees and their skills")})
public class SkillEmployeeController {

    private SkillEmployeeService skillemployeeService;

    @Autowired
    public SkillEmployeeController(SkillEmployeeService skillemployeeService) {
        this.skillemployeeService = skillemployeeService;
    }

    @ApiOperation(value = "Create new skill employee details", notes = "Creates a new skill employee details.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Skill employee details created successfully"),
            @ApiResponse(code = 400, message = "Invalid request"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    @PostMapping()
    public ResponseEntity<SkillEmployee> createSkillemployee(@RequestBody SkillEmployee employee) {
        try {
            SkillEmployee createdEmployee = skillemployeeService.createSkillEmployee(employee);
            return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @ApiOperation(value = "Update skill employee details by ID", notes = "Updates skill employee details for a given ID.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Skill employee details updated successfully"),
            @ApiResponse(code = 404, message = "Skill employee details not found")
    })
    @PutMapping("/{id}")
    public ResponseEntity<SkillEmployee> updateSkillemployee(@PathVariable Long id, @RequestBody SkillEmployee employeeDetails) {
        try {
            SkillEmployee updatedSkillEmployee = skillemployeeService.updateSkillEmployee(id, employeeDetails);
            if (updatedSkillEmployee == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return ResponseEntity.ok(updatedSkillEmployee);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Get skill employee details by employee ID and skill name", notes = "Retrieves skill employee details for a given employee ID and skill name.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved skill employee details"),
            @ApiResponse(code = 404, message = "Skill employee details not found")
    })
    @GetMapping("/skillversion")
    public ResponseEntity<List<SkillEmployee>> getSkillSet(
            @RequestParam("empId") Long empId,
            @RequestParam("skillName") String skillName) {
        try {
            List<SkillEmployee> skillEmployee = skillemployeeService.getSkillListBySkillVersion(empId, skillName);
            if (!skillEmployee.isEmpty()) {
                return ResponseEntity.ok(skillEmployee);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Get skill employee details by employee ID, skill name, and skill version", notes = "Retrieves skill employee details for a given employee ID, skill name, and skill version.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved skill employee details"),
            @ApiResponse(code = 404, message = "Skill employee details not found")
    })
    @GetMapping("/employeeskill")
    public ResponseEntity<SkillEmployee> getSkillSet(
            @RequestParam("empId") Long empId,
            @RequestParam("skillName") String skillName,
            @RequestParam("skillVersion") String skillVersion) {
        try {
            SkillEmployee skillEmployee = skillemployeeService.getSkillListByEmpid(empId, skillName, skillVersion);
            if (skillEmployee != null) {
                return ResponseEntity.ok(skillEmployee);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Get all skill employees", notes = "Retrieves a list of all skill employees.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list of skill employees"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    @GetMapping()
    public ResponseEntity<List<SkillEmployee>> getAllSkillemployees() {
        try {
            List<SkillEmployee> skillEmployees = skillemployeeService.getAllSkillEmployees();
            return ResponseEntity.ok(skillEmployees);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Get skill employees by employee ID", notes = "Retrieves skill employees for a given employee ID.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved skill employees"),
            @ApiResponse(code = 404, message = "Skill employees not found")
    })
    @GetMapping("/empid")
    public ResponseEntity<List<SkillEmployee>> getEmployeeSkills(@RequestParam("empId") Long empId) {
        try {
            List<SkillEmployee> skillEmployees = skillemployeeService.getEmployeeSkills(empId);
            if (!skillEmployees.isEmpty()) {
                return ResponseEntity.ok(skillEmployees);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
