package pt.ipp.isep.dei.esoft.project.repository;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.PlateCertification;

import java.text.ParseException;
import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlateCertificationsRepositoryTest {
    @Test
    void ensureNewPlateCertificationSuccessfullyAdded() throws ParseException {
        // Arrange
        String ExampleDate = "2005-01-02";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateTest = sdf.parse(ExampleDate);


        PlateCertificationsRepository plateCertificationsRepository = new PlateCertificationsRepository();
        PlateCertification plateCertification = new PlateCertification("Renault","Clio","Electric",900,1200,dateTest,"72-XQ-70");

        // Act
        Optional<PlateCertification> addedPlateCertification = plateCertificationsRepository.add(plateCertification);

        // Assert
        assertTrue(addedPlateCertification.isPresent());
        assertEquals(plateCertification, addedPlateCertification.get());
    }

    @Test
    void ensureAddingDuplicatePlateCertificationFails() throws ParseException {
        // Arrange
        String ExampleDate = "2005-01-02";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateTest = sdf.parse(ExampleDate);

        PlateCertificationsRepository plateCertificationsRepository = new PlateCertificationsRepository();
        PlateCertification plateCertification = new PlateCertification("Renault","Clio","Electric",900,1200,dateTest,"72-XQ-70");

        // Act
        Optional<PlateCertification> addedFirstPlateCertification = plateCertificationsRepository.add(plateCertification);
        Optional<PlateCertification> addedSecondPlateCertification = plateCertificationsRepository.add(plateCertification);

        // Assert
        assertTrue(addedFirstPlateCertification.isPresent());
        assertTrue(addedSecondPlateCertification.isEmpty());
    }

    @Test
    void ensurePlateCertificationsListIsNotNull() {
        // Arrange
        PlateCertificationsRepository plateCertificationsRepository = new PlateCertificationsRepository();

        // Act
        List<PlateCertification> plateCertificationsList = plateCertificationsRepository.getPlateCertificationsList();

        // Assert
        assertTrue(plateCertificationsList.isEmpty());

    }
}
