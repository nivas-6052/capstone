package com.hds.Employee.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @Column(name = "Emp_id", nullable = false, unique = true)
    private Long empId;
    @Column(name = "Emp_name")
    private String fullName;
    @NotBlank
    @Size(max = 50)
    @Email
    @Column(name = "Email")
    private String email;

    @NotBlank
    @Size(max = 120)
    @Column(name = "Password")
    private String password;

    @OneToMany(targetEntity = SkillEmployee.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "Emp_id", referencedColumnName = "Emp_id")
    private List<SkillEmployee> SkillEmployees;

    @OneToMany(targetEntity = Certifications.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "Emp_id", referencedColumnName = "Emp_id")
    private List<Certifications> certificationsList;

    public Employee() {
    }

    public Employee(Long empId, String fullName, String email, String password) {
        this.empId = empId;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
