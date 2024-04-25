package com.hds.Employee.repository;

import com.hds.Employee.model.CertificateSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificateSetRepository extends JpaRepository<CertificateSet, Long> {

}
