package com.hds.Employee.service.impl;

import com.hds.Employee.model.SkillSet;
import com.hds.Employee.repository.SkillSetRepository;
import com.hds.Employee.service.SkillSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillSetServiceImpl implements SkillSetService {

    private SkillSetRepository skillsetRepository;

    @Autowired
    public SkillSetServiceImpl(SkillSetRepository skillsetRepository) {
        this.skillsetRepository = skillsetRepository;
    }

    public SkillSet createSkillSet(SkillSet skillset) {
        return skillsetRepository.save(skillset);
    }

    public List<SkillSet> getAllSkillSets() {
        return skillsetRepository.findAll();
    }

    public List<SkillSet> getSkillsSubCop(String cop) {
        return skillsetRepository.findByCop(cop);
    }

    ;

    public List<SkillSet> getSkillsSkillName(String cop, String subCop) {
        return skillsetRepository.findByCopAndSubCop(cop, subCop);
    }

    public List<SkillSet> getSkillsVersion(String cop, String subCop, String skillName) {
        return skillsetRepository.findByCopAndSubCopAndSkillName(cop, subCop, skillName);
    }

}
