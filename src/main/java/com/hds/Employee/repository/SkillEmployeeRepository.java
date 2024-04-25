package com.hds.Employee.repository;

import com.hds.Employee.model.SkillEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillEmployeeRepository extends JpaRepository<SkillEmployee, Long> {

    List<SkillEmployee> findByEmpId(Long empId);

    SkillEmployee findByEmpIdAndSkillNameAndSkillVersion(Long empId, String skillName, String skillVersion);

    List<SkillEmployee> findByEmpIdAndSkillName(Long empId, String skillName);
}
