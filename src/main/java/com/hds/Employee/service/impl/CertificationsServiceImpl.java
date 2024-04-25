package com.hds.Employee.service.impl;

import com.hds.Employee.model.Certifications;
import com.hds.Employee.repository.CertificationsRepository;
import com.hds.Employee.service.CertificationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CertificationsServiceImpl implements CertificationsService {
    private final CertificationsRepository certificationRepository;

    @Autowired
    public CertificationsServiceImpl(CertificationsRepository certificationRepository) {
        this.certificationRepository = certificationRepository;
    }

    public List<Certifications> getAllCertifications() {
        return certificationRepository.findAll();
    }

    public Certifications addCertification(Certifications certification) {
        return certificationRepository.save(certification);
    }

    public List<Certifications> getEmployeeCertifications(Long empId) {
        return certificationRepository.findByEmpId(empId);
    }

}
