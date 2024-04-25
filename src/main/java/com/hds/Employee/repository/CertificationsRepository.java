package com.hds.Employee.repository;

import com.hds.Employee.model.Certifications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CertificationsRepository extends JpaRepository<Certifications, Long> {

    List<Certifications> findByEmpId(Long empId);
}
