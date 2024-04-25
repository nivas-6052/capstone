package com.hds.Employee.service.impl;

import com.hds.Employee.exception.ResourceNotFoundException;
import com.hds.Employee.model.SkillEmployee;
import com.hds.Employee.repository.SkillEmployeeRepository;
import com.hds.Employee.service.SkillEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillEmployeeServiceImpl implements SkillEmployeeService {


    private SkillEmployeeRepository skillemployeeRepository;

    @Autowired
    public SkillEmployeeServiceImpl(SkillEmployeeRepository skillemployeeRepository) {
        this.skillemployeeRepository = skillemployeeRepository;
    }

    public List<SkillEmployee> getAllSkillEmployees() {
        return skillemployeeRepository.findAll();
    }

    public SkillEmployee createSkillEmployee(SkillEmployee employee) {
        return skillemployeeRepository.save(employee);
    }

    public SkillEmployee updateSkillEmployee(Long id, SkillEmployee employeeDetails) {
        SkillEmployee employee = skillemployeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not exist with id :" + id));
        employee.setRating(employeeDetails.getRating());
        employee.setEmpId(employeeDetails.getEmpId());
        employee.setSkillName(employeeDetails.getSkillName());
        employee.setExperience(employeeDetails.getExperience());
        employee.setLastWorked(employeeDetails.getLastWorked());

        return skillemployeeRepository.save(employee);
    }

    public SkillEmployee getSkillListByEmpid(Long empId, String skillName, String skillVersion) {
        return skillemployeeRepository.findByEmpIdAndSkillNameAndSkillVersion(empId, skillName, skillVersion);
    }

    public List<SkillEmployee> getEmployeeSkills(Long empId) {
        return skillemployeeRepository.findByEmpId(empId);
    }

    public List<SkillEmployee> getSkillListBySkillVersion(Long empId, String skillName) {
        return skillemployeeRepository.findByEmpIdAndSkillName(empId, skillName);
    }


}
