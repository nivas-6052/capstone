package com.hds.Employee.service;

import com.hds.Employee.model.SkillEmployee;

import java.util.List;

public interface SkillEmployeeService {
    List<SkillEmployee> getAllSkillEmployees();

    SkillEmployee createSkillEmployee(SkillEmployee employee);

    SkillEmployee updateSkillEmployee(Long id, SkillEmployee employeeDetails);

    SkillEmployee getSkillListByEmpid(Long empId, String skillName, String skillVersion);

    List<SkillEmployee> getEmployeeSkills(Long empId);

    List<SkillEmployee> getSkillListBySkillVersion(Long empId, String skillName);
}
