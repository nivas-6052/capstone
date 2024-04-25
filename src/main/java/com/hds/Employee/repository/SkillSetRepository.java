package com.hds.Employee.repository;

import com.hds.Employee.model.SkillSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillSetRepository extends JpaRepository<SkillSet, Integer> {


    List<SkillSet> findByCop(String cop);

    List<SkillSet> findByCopAndSubCop(String cop, String subCop);

    List<SkillSet> findByCopAndSubCopAndSkillName(String cop, String subCop, String skillName);
}
