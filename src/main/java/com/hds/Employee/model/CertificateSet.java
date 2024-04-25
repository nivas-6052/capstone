package com.hds.Employee.model;


import javax.persistence.*;


@Entity
@Table(name = "Certification_List")
public class CertificateSet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Cert_id")
    private Integer id;

    @Column(name = "certificate_name")
    private String certificateName;

    @Column(name = "description")
    private String description;

    @Column(name = "vendor")
    private String vendor;

    @Column(name = "cop")
    private String cop;

    @Column(name = "subcop")
    private String subCop;

    @Column(name = "category")
    private String category;

    public CertificateSet(Integer id, String certificateName, String description, String vendor, String cop, String subCop, String category) {
        this.id = id;
        this.certificateName = certificateName;
        this.description = description;
        this.vendor = vendor;
        this.cop = cop;
        this.subCop = subCop;
        this.category = category;
    }





    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCertificateName() {
        return certificateName;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "CertificateSet{" +
                "id=" + id +
                ", certificateName='" + certificateName + '\'' +
                ", description='" + description + '\'' +
                ", vendor='" + vendor + '\'' +
                ", cop='" + cop + '\'' +
                ", subCop='" + subCop + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
