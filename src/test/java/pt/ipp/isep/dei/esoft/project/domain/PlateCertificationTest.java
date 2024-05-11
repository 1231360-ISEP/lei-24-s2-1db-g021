package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class PlateCertificationTest {
    @Test
    void testEqualsSameObject() throws ParseException {
        // Arrange
        String ExampleDate = "2005-01-02";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateTest = sdf.parse(ExampleDate);

        PlateCertification plateCertification = new PlateCertification("Renault","Clio","Electric",900,1200,dateTest,"72-XQ-70");

        // Act
        boolean result = plateCertification.equals(plateCertification);

        // Assert
        assertTrue(result, "Plate Certification should be equal to itself.");
    }

    @Test
    void testEqualsDifferentClass() throws ParseException {
        // Arrange
        String ExampleDate = "2005-01-02";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateTest = sdf.parse(ExampleDate);

        PlateCertification plateCertification = new PlateCertification("Renault","Clio","Electric",900,1200,dateTest,"72-XQ-70");

        // Act
        boolean result = plateCertification.equals("");

        // Assert
        assertFalse(result, "Plate Certification should not be equal to an object of a different class.");

    }

    @Test
    void testEqualsNull() throws ParseException {
        // Arrange
        String ExampleDate = "2005-01-02";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateTest = sdf.parse(ExampleDate);

        PlateCertification plateCertification1 = new PlateCertification("Renault","Clio","Electric",900,1200,dateTest,"72-XQ-70");

        // Act
        boolean result = plateCertification1.equals(null);

        // Assert
        assertFalse(result, "Plate Certification should not be equal to null.");
    }
    @Test
    void testEqualsDifferentObject() throws ParseException {
        // Arrange
        String ExampleDate = "2005-01-02";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateTest = sdf.parse(ExampleDate);

        String ExampleDate2 = "2006-08-10";
        Date dateTest2 = sdf.parse(ExampleDate2);

        PlateCertification plateCertification1 = new PlateCertification("Renault","Clio","Electric",900,1200,dateTest,"72-XQ-70");
        PlateCertification plateCertification2 = new PlateCertification("Mercedes","Benz","Hybrid",1050,1400,dateTest2,"53-NA-63");

        // Act and Assert
        assertNotEquals(plateCertification1, plateCertification2);
    }
    @Test
    void testEqualsSameObjectDifferentName() throws ParseException {
        // Arrange
        String ExampleDate = "2005-01-02";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateTest = sdf.parse(ExampleDate);

        String ExampleDate2 = "2006-08-10";
        Date dateTest2 = sdf.parse(ExampleDate2);

        PlateCertification plateCertification1 = new PlateCertification("Renault","Clio","Electric",900,1200,dateTest,"72-XQ-70");
        PlateCertification plateCertification2 = new PlateCertification("Mercedes","Benz","Hybrid",1050,1400,dateTest2,"53-NA-63");

        // Act
        boolean result = plateCertification1.equals(plateCertification2);

        // Assert
        assertFalse(result, "Plate Certifications with different values should not be equal.");
    }

    @Test
    void testEqualsDifferentObjectsSameName() throws ParseException {
        // Arrange
        String ExampleDate = "2005-01-02";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateTest = sdf.parse(ExampleDate);

        PlateCertification plateCertification1 = new PlateCertification("Renault","Clio","Electric",900,1200,dateTest,"72-XQ-70");
        PlateCertification plateCertification2 = new PlateCertification("Renault","Clio","Electric",900,1200,dateTest,"72-XQ-70");

        // Act
        boolean result = plateCertification1.equals(plateCertification2);

        // Assert
        assertTrue(result, "Plate Certifications with same values should be equal.");
    }
    @Test
    void testHashCodeSameObject() throws ParseException {
        // Arrange
        String ExampleDate = "2005-01-02";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateTest = sdf.parse(ExampleDate);

        PlateCertification plateCertification = new PlateCertification("Renault","Clio","Electric",900,1200,dateTest,"72-XQ-70");

        // Act and Assert
        assertEquals(plateCertification.hashCode(), plateCertification.hashCode());
    }

    @Test
    void testHashCodeDifferentObject() throws ParseException {
        // Arrange
        String ExampleDate = "2005-01-02";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateTest = sdf.parse(ExampleDate);

        String ExampleDate2 = "2006-08-10";
        Date dateTest2 = sdf.parse(ExampleDate2);

        PlateCertification plateCertification1 = new PlateCertification("Renault","Clio","Electric",900,1200,dateTest,"72-XQ-70");
        PlateCertification plateCertification2 = new PlateCertification("Mercedes","Benz","Hybrid",1050,1400,dateTest2,"53-NA-63");

        // Act and Assert
        assertNotEquals(plateCertification1.hashCode(), plateCertification2.hashCode());
    }

    @Test
    void testHashCodeSameObjectDifferentName() throws ParseException {
        // Arrange
        String ExampleDate = "2005-01-02";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateTest = sdf.parse(ExampleDate);

        String ExampleDate2 = "2006-08-10";
        Date dateTest2 = sdf.parse(ExampleDate2);

        PlateCertification plateCertification1 = new PlateCertification("Renault","Clio","Electric",900,1200,dateTest,"72-XQ-70");
        PlateCertification plateCertification2 = new PlateCertification("Mercedes","Benz","Hybrid",1050,1400,dateTest2,"53-NA-63");

        // Act and Assert
        assertNotEquals(plateCertification1.hashCode(), plateCertification2.hashCode());
    }

    @Test
    void testHashCodeSameObjectSameName() throws ParseException {
        // Arrange
        String ExampleDate = "2005-01-02";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateTest = sdf.parse(ExampleDate);

        PlateCertification plateCertification1 = new PlateCertification("Renault","Clio","Electric",900,1200,dateTest,"72-XQ-70");
        PlateCertification plateCertification2 = new PlateCertification("Renault","Clio","Electric",900,1200,dateTest,"72-XQ-70");

        // Act and Assert
        assertEquals(plateCertification1.hashCode(), plateCertification2.hashCode());
    }

    @Test
    void ensureCloneWorks() throws ParseException {
        // Arrange
        String ExampleDate = "2005-01-02";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateTest = sdf.parse(ExampleDate);

        PlateCertification plateCertification = new PlateCertification("Renault","Clio","Electric",900,1200,dateTest,"72-XQ-70");
        PlateCertification clone = plateCertification.clone();

        // Act and Assert
        assertEquals(plateCertification, clone);
    }
}
