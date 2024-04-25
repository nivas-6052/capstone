package com.hds.Employee.service.impl;

import com.hds.Employee.model.CertificateSet;
import com.hds.Employee.repository.CertificateSetRepository;
import com.hds.Employee.service.CertificateSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CertificateSetServiceImpl implements CertificateSetService {

    private CertificateSetRepository certificateSetRepository;

    @Autowired
    public void CertificateSetServiceImpl(CertificateSetRepository certificateSetRepository) {
        this.certificateSetRepository = certificateSetRepository;
    }

    public List<CertificateSet> getAllCertificates() {
        return certificateSetRepository.findAll();
    }

    public CertificateSet createCertificate(CertificateSet certificate) {
        return certificateSetRepository.save(certificate);
    }
}
