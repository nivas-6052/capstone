package com.hds.Employee.controller;

import static org.junit.jupiter.api.Assertions.*;

        import com.hds.Employee.model.CertificateSet;
        import com.hds.Employee.service.CertificateSetService;
        import org.junit.jupiter.api.BeforeEach;
        import org.junit.jupiter.api.Test;
        import org.mockito.InjectMocks;
        import org.mockito.Mock;
        import org.mockito.MockitoAnnotations;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;

        import java.util.Arrays;
        import java.util.List;

        import static org.junit.jupiter.api.Assertions.assertEquals;
        import static org.mockito.Mockito.*;

class CertificateSetControllerTest {


    @Mock
    private CertificateSetService certificateSetService;

    @InjectMocks
    private CertificateSetController certificateSetController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllCertificates_ReturnsListOfCertificates() {
        // Arrange
        CertificateSet certificate1 = new CertificateSet(1, "Certificate 1", "Description 1", "Vendor 1", "COP 1", "SubCOP 1", "Category 1");
        CertificateSet certificate2 = new CertificateSet(2, "Certificate 2", "Description 2", "Vendor 2", "COP 2", "SubCOP 2", "Category 2");
        List<CertificateSet> certificates = Arrays.asList(certificate1, certificate2);
        when(certificateSetService.getAllCertificates()).thenReturn(certificates);

        // Act
        ResponseEntity<List<CertificateSet>> responseEntity = certificateSetController.getAllCertificates();

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(certificates, responseEntity.getBody());
    }

    @Test
    void createCertificate_ReturnsCreatedCertificate() {
        // Arrange
        CertificateSet certificate = new CertificateSet(null, "Certificate 1", "Description 1", "Vendor 1", "COP 1", "SubCOP 1", "Category 1");
        CertificateSet createdCertificate = new CertificateSet(1, "Certificate 1", "Description 1", "Vendor 1", "COP 1", "SubCOP 1", "Category 1");
        when(certificateSetService.createCertificate(certificate)).thenReturn(createdCertificate);

        // Act
        ResponseEntity<CertificateSet> responseEntity = certificateSetController.createCertificate(certificate);

        // Assert
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(createdCertificate, responseEntity.getBody());
    }
}
