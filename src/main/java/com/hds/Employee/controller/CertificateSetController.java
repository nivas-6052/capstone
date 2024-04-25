package com.hds.Employee.controller;


import com.hds.Employee.model.CertificateSet;
import com.hds.Employee.service.CertificateSetService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/CertificationList")

@CrossOrigin(origins = "http://localhost:4200")
@SwaggerDefinition(tags = {
        @Tag(name = "Certifications List", description = "Endpoints for the list of all certificates")})
public class CertificateSetController {
    @Autowired
    private final CertificateSetService certificatesetService;

    public CertificateSetController(CertificateSetService certificatesetService) {
        this.certificatesetService = certificatesetService;
    }


    @ApiOperation(value = "Get all certificates", notes = "Retrieves a list of all certificates.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list of certificates"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    @GetMapping()
    public ResponseEntity<List<CertificateSet>> getAllCertificates() {
        try {
            List<CertificateSet> certificates = certificatesetService.getAllCertificates();
            return new ResponseEntity<>(certificates, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Create a certificate", notes = "Creates a new certificate.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Certificate created successfully"),
            @ApiResponse(code = 400, message = "Invalid request"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    @PostMapping()
    public ResponseEntity<CertificateSet> createCertificate(@RequestBody CertificateSet certificate) {
        try {
            CertificateSet createdCertificate = certificatesetService.createCertificate(certificate);
            return new ResponseEntity<>(createdCertificate, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
