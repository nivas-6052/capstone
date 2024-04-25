package com.hds.Employee.controller;


import com.hds.Employee.model.SkillSet;
import com.hds.Employee.service.SkillSetService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/skilllist")
@CrossOrigin(origins = "http://localhost:4200")
@SwaggerDefinition(tags = {
        @Tag(name = "skill set management", description = "Endpoints for managing list of skills")})
public class SkillSetController {
    private SkillSetService skillsetService;

    @Autowired
    public SkillSetController(SkillSetService skillsetService) {
        this.skillsetService = skillsetService;
    }

    @ApiOperation(value = "Create new skill set details", notes = "Creates a new skill set details.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Skill set details created successfully"),
            @ApiResponse(code = 400, message = "Invalid request"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    @PostMapping()
    public ResponseEntity<SkillSet> createSkillset(@RequestBody SkillSet skillSet) {
        try {
            SkillSet createdSkillSet = skillsetService.createSkillSet(skillSet);
            return new ResponseEntity<>(createdSkillSet, HttpStatus.CREATED);
        } catch (Exception e) {
            // Log the exception
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Get all skill set details", notes = "Retrieves a list of all skill set details.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list of skill set details"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    @GetMapping()
    public ResponseEntity<List<SkillSet>> getSkillsets() {
        try {
            List<SkillSet> skillSets = skillsetService.getAllSkillSets();
            return ResponseEntity.ok(skillSets);
        } catch (Exception e) {
            // Log the exception
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Get skill sets by CoP", notes = "Retrieves skill sets for a given CoP (Community of Practice).")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved skill sets"),
            @ApiResponse(code = 404, message = "Skill sets not found")
    })
    @GetMapping("/cop")
    public ResponseEntity<List<SkillSet>> getSubCop(@RequestParam("cop") String cop) {
        try {
            List<SkillSet> skillSets = skillsetService.getSkillsSubCop(cop);
            if (!skillSets.isEmpty()) {
                return ResponseEntity.ok(skillSets);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            // Log the exception
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Get skill sets by CoP and SubCoP", notes = "Retrieves skill sets for a given CoP (Community of Practice) and SubCoP.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved skill sets"),
            @ApiResponse(code = 404, message = "Skill sets not found")
    })
    @GetMapping("/subcop")
    public ResponseEntity<List<SkillSet>> getSkillName(@RequestParam("cop") String cop, @RequestParam("subcop") String subCop) {
        try {
            List<SkillSet> skillSets = skillsetService.getSkillsSkillName(cop, subCop);
            if (!skillSets.isEmpty()) {
                return ResponseEntity.ok(skillSets);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            // Log the exception
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Get skill sets by CoP, SubCoP, and Skill Name", notes = "Retrieves skill sets for a given CoP (Community of Practice), SubCoP, and Skill Name.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved skill sets"),
            @ApiResponse(code = 404, message = "Skill sets not found")
    })
    @GetMapping("/skillname")
    public ResponseEntity<List<SkillSet>> getVersion(@RequestParam("cop") String cop, @RequestParam("subcop") String subCop, @RequestParam("skillname") String skillName) {
        try {
            List<SkillSet> skillSets = skillsetService.getSkillsVersion(cop, subCop, skillName);
            if (!skillSets.isEmpty()) {
                return ResponseEntity.ok(skillSets);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            // Log the exception
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
