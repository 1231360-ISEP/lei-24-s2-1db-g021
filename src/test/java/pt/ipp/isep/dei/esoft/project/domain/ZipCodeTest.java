package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.*;

class ZipCodeTest {

    @Test
    void ensureZipCodeHasValidValues() {
        // Arrange
        int validLocal = 1234;
        int validStreet = 456;

        // Act
        ZipCode zipCode = new ZipCode(validLocal, validStreet);

        // Assert
        assertEquals(validLocal, zipCode.getLocal());
        assertEquals(validStreet, zipCode.getStreet());
    }

    @Test
    void ensureThrowsInvalidLocalValueException() {
        // Arrange, Act and Assert
        assertThrows(InvalidParameterException.class, () -> new ZipCode(12345, 456));
    }

    @Test
    void ensureThrowsInvalidStreetValueException() {
        // Arrange, Act and Assert
        assertThrows(InvalidParameterException.class, () -> new ZipCode(1234, 1234));
    }

    @Test
    void ensureEqualsAndHashCodeWorkCorrectly() {
        // Arrange
        ZipCode zipCode1 = new ZipCode(1234, 456);
        ZipCode zipCode2 = new ZipCode(1234, 456);
        ZipCode zipCode3 = new ZipCode(5678, 456);

        // Assert
        assertEquals(zipCode1, zipCode2);
        assertNotEquals(zipCode1, zipCode3);
        assertEquals(zipCode1.hashCode(), zipCode2.hashCode());
    }

    @Test
    void ensureToStringWorksCorrectly() {
        // Arrange
        ZipCode zipCode = new ZipCode(1234, 567);

        // Assert
        assertEquals("ZipCode{local=1234, street=567}", zipCode.toString());
    }
}