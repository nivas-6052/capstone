package com.hds.Employee.service.impl;
import static org.junit.jupiter.api.Assertions.*;

        import com.hds.Employee.model.CertificateSet;
        import com.hds.Employee.repository.CertificateSetRepository;
        import org.junit.jupiter.api.BeforeEach;
        import org.junit.jupiter.api.Test;
        import org.mockito.InjectMocks;
        import org.mockito.Mock;
        import org.mockito.MockitoAnnotations;

        import java.util.Arrays;
        import java.util.List;

        import static org.junit.jupiter.api.Assertions.assertEquals;
        import static org.mockito.Mockito.*;

class CertificateSetServiceImplTest {

    @Mock
    private CertificateSetRepository certificateSetRepository;

    @InjectMocks
    private CertificateSetServiceImpl certificateSetService;

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
        when(certificateSetRepository.findAll()).thenReturn(certificates);

        // Act
        List<CertificateSet> result = certificateSetService.getAllCertificates();

        // Assert
        assertEquals(certificates.size(), result.size());
        assertEquals(certificates, result);
    }

    @Test
    void createCertificate_ReturnsCreatedCertificate() {
        // Arrange
        CertificateSet certificate = new CertificateSet(null, "Certificate 1", "Description 1", "Vendor 1", "COP 1", "SubCOP 1", "Category 1");
        CertificateSet createdCertificate = new CertificateSet(1, "Certificate 1", "Description 1", "Vendor 1", "COP 1", "SubCOP 1", "Category 1");
        when(certificateSetRepository.save(certificate)).thenReturn(createdCertificate);

        // Act
        CertificateSet result = certificateSetService.createCertificate(certificate);

        // Assert
        assertEquals(createdCertificate, result);
    }
}
