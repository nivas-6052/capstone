package com.hds.Employee.service;

import com.hds.Employee.model.SkillSet;

import java.util.List;

public interface SkillSetService {
    SkillSet createSkillSet(SkillSet skillSet);

    List<SkillSet> getAllSkillSets();

    List<SkillSet> getSkillsSubCop(String cop);

    List<SkillSet> getSkillsSkillName(String cop, String subCop);

    List<SkillSet> getSkillsVersion(String cop, String subCop, String skillName);
}
