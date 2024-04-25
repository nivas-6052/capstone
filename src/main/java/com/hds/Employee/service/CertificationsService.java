package com.hds.Employee.service;

import com.hds.Employee.model.Certifications;

import java.util.List;

public interface CertificationsService {
    List<Certifications> getAllCertifications();

    Certifications addCertification(Certifications certification);

    List<Certifications> getEmployeeCertifications(Long empId);
}
