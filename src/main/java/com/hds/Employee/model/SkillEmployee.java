package com.hds.Employee.model;

import javax.persistence.*;

@Entity
@Table(name = "skill_employee")
public class SkillEmployee {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Cop")
    private String cop;
    @Column(name = "Subcop")
    private String subCop;


    @Column(name = "Skill_name")
    private String skillName;
    @Column(name = "Skill_version")
    private String skillVersion;
    @Column(name = "rating")
    private String rating;
    @Column(name = "YOE")
    private Integer experience;

    @Column(name = "Last_worked")
    private String lastWorked;
    @Column(name = "Emp_id")
    private Long empId;

    @Column(name = "Emp_name")
    private String fullName;

    public SkillEmployee() {
    }

    public SkillEmployee(Long id, String cop, String subCop, String skillName, String skillVersion, String rating, Integer experience, String lastWorked, Long empId, String fullName) {
        this.id = id;
        this.cop = cop;
        this.subCop = subCop;
        this.skillName = skillName;
        this.skillVersion = skillVersion;
        this.rating = rating;
        this.experience = experience;
        this.lastWorked = lastWorked;
        this.empId = empId;
        this.fullName = fullName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCop() {
        return cop;
    }

    public void setCop(String cop) {
        this.cop = cop;
    }

    public String getSubCop() {
        return subCop;
    }

    public void setSubCop(String subCop) {
        this.subCop = subCop;
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

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public String getLastWorked() {
        return lastWorked;
    }

    public void setLastWorked(String lastWorked) {
        this.lastWorked = lastWorked;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "SkillEmployee{" +
                "id=" + id +
                ", cop='" + cop + '\'' +
                ", subCop='" + subCop + '\'' +
                ", skillName='" + skillName + '\'' +
                ", skillVersion='" + skillVersion + '\'' +
                ", rating='" + rating + '\'' +
                ", experience=" + experience +
                ", lastWorked='" + lastWorked + '\'' +
                ", empId=" + empId +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
