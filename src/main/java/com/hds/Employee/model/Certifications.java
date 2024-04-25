package com.hds.Employee.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Emp_Certifications")
public class Certifications {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Emp_id")//unique = true, insertable =false, updatable = false)
    private Long empId;
    @Column(name = "Cert_Number")
    private Integer certNumber;


    @Column(name = "Acquired_date")
    private Date issuedDate;
    @Column(name = "Expire_date")
    private Date expiredDate;
    @Column(name = "certificate_name")
    private String certificateName;
    @Column(name = "Verification_url")
    private String verificationUrl;
    @Column(name = "vendor")
    private String vendor;
    @Column(name = "Accreditation")
    private String accreditation;

    public Certifications() {
    }

    public Certifications(Long id, Long empId, Integer certNumber, Date issuedDate, Date expiredDate, String certificateName, String verificationUrl, String vendor, String accreditation) {
        this.id = id;
        this.empId = empId;
        this.certNumber = certNumber;
        this.issuedDate = issuedDate;
        this.expiredDate = expiredDate;
        this.certificateName = certificateName;
        this.verificationUrl = verificationUrl;
        this.vendor = vendor;
        this.accreditation = accreditation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public Integer getCertNumber() {
        return certNumber;
    }

    public void setCertNumber(Integer certNumber) {
        this.certNumber = certNumber;
    }

    public Date getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(Date issuedDate) {
        this.issuedDate = issuedDate;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public String getCertificateName() {
        return certificateName;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }

    public String getVerificationUrl() {
        return verificationUrl;
    }

    public void setVerificationUrl(String verificationUrl) {
        this.verificationUrl = verificationUrl;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getAccreditation() {
        return accreditation;
    }

    public void setAccreditation(String accreditation) {
        this.accreditation = accreditation;
    }

    @Override
    public String toString() {
        return "Certifications{" +
                "id=" + id +
                ", empId=" + empId +
                ", certNumber=" + certNumber +
                ", issuedDate=" + issuedDate +
                ", expiredDate=" + expiredDate +
                ", certificateName='" + certificateName + '\'' +
                ", verificationUrl='" + verificationUrl + '\'' +
                ", vendor='" + vendor + '\'' +
                ", accreditation='" + accreditation + '\'' +
                '}';
    }
}
