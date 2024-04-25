package com.hds.Employee.model;

import javax.persistence.*;

@Entity
@Table(name = "Skill_List")
public class SkillSet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Skill_id")
    private Integer skillId;
    @Column(name = "Skill_name")
    private String skillName;
    @Column(name = "Skill_version")
    private String skillVersion;
    @Column(name = "Category")
    private String category;
    @Column(name = "Subcop")
    private String subCop;

    @Column(name = "Cop")
    private String cop;


    public SkillSet() {
    }

    public SkillSet(Integer skillId, String skillName, String skillVersion, String category, String subCop, String cop) {
        this.skillId = skillId;
        this.skillName = skillName;
        this.skillVersion = skillVersion;
        this.category = category;
        this.subCop = subCop;
        this.cop = cop;
    }

    public Integer getSkillId() {
        return skillId;
    }

    public void setSkillId(Integer skillId) {
        this.skillId = skillId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getSkillVersion() {
        return skillVersion;
    }

    public void setSkillVersion(String skillVersion) {
        this.skillVersion = skillVersion;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubCop() {
        return subCop;
    }

    public void setSubCop(String subCop) {
        this.subCop = subCop;
    }

    public String getCop() {
        return cop;
    }

    public void setCop(String cop) {
        this.cop = cop;
    }

    @Override
    public String toString() {
        return "SkillSet{" +
                "skillId=" + skillId +
                ", skillName='" + skillName + '\'' +
                ", skillVersion='" + skillVersion + '\'' +
                ", category='" + category + '\'' +
                ", subCop='" + subCop + '\'' +
                ", cop='" + cop + '\'' +
                '}';
    }
}