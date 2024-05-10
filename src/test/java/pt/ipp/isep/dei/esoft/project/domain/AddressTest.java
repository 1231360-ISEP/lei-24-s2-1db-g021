package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest {
    @Test
    void ensureAddressHasValidValues() {
        // Arrange
        int doorNumber = 1;
        ZipCode zipCode = new ZipCode(1234, 567);

        // Act
        Address address = new Address(doorNumber, zipCode);

        // Assert
        assertEquals(doorNumber, address.getDoorNumber());
        assertEquals(zipCode, address.getZipCode());
    }

    @Test
    void ensureGettersAndSettersWorkCorrectly() {
        // Arrange
        int doorNumber = 1;
        ZipCode zipCode = new ZipCode(1234, 567);
        Address address = new Address(doorNumber, zipCode);

        // Act
        int newDoorNumber = 2;
        ZipCode newZipCode = new ZipCode(3456, 789);
        address.setDoorNumber(newDoorNumber);
        address.setZipCode(newZipCode);

        // Assert
        assertEquals(newDoorNumber, address.getDoorNumber());
        assertEquals(newZipCode, address.getZipCode());
    }

    @Test
    void ensureEqualsAndHashCodeWorkCorrectly() {
        // Arrange
        Address address1 = new Address(1, new ZipCode(1234, 567));
        Address address2 = new Address(1, new ZipCode(1234, 567));
        Address address3 = new Address(2, new ZipCode(3456, 789));

        // Assert
        assertEquals(address1, address2);
        assertNotEquals(address1, address3);
        assertEquals(address1.hashCode(), address2.hashCode());
    }

    @Test
    void ensureToStringWorksCorrectly() {
        // Arrange
        int doorNumber = 1;
        ZipCode zipCode = new ZipCode(1234, 567);
        Address address = new Address(doorNumber, zipCode);

        // Assert
        assertEquals("Address{doorNumber=1, zipCode=ZipCode{local=1234, street=567}}", address.toString());
    }
}