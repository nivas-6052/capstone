package com.hds.Employee.service;

import com.hds.Employee.model.CertificateSet;

import java.util.List;

public interface CertificateSetService {
    List<CertificateSet> getAllCertificates();

    CertificateSet createCertificate(CertificateSet certificate);

}
