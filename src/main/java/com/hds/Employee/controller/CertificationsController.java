package com.hds.Employee.controller;

import com.hds.Employee.model.Certifications;
import com.hds.Employee.service.CertificationsService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/certification")
@CrossOrigin(origins = "http://localhost:4200")

@SwaggerDefinition(tags = {
        @Tag(name = "Employee Certifications", description = "Endpoints for employees and their certificates")})
public class CertificationsController {
    private final CertificationsService certificationsService;

    @Autowired
    public CertificationsController(CertificationsService certificationsService) {
        this.certificationsService = certificationsService;
    }


    @ApiOperation(value = "Get all certifications", notes = "Retrieves a list of all certifications.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list of certifications"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    @GetMapping()
    public ResponseEntity<List<Certifications>> getAllCertifications() {
        try {
            List<Certifications> certificationsList = certificationsService.getAllCertifications();
            return ResponseEntity.ok(certificationsList);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping()
    public ResponseEntity<Certifications> addCertification(@RequestBody Certifications certification) {
        try {
            Certifications savedCertification = certificationsService.addCertification(certification);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedCertification);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Get certifications by employee ID", notes = "Retrieves certifications for a given employee ID.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved certifications"),
            @ApiResponse(code = 404, message = "Certifications not found")
    })
    @GetMapping("/empid")
    public ResponseEntity<List<Certifications>> getEmployeeCertifications(@RequestParam("empId") Long empId) {
        try {
            List<Certifications> certifications = certificationsService.getEmployeeCertifications(empId);
            if (certifications.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return ResponseEntity.ok(certifications);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
