package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class VehicleCheckUpTest {

    @Test
    void throwExceptionWhenDateIsSurpassed() {
        Date d = new Date(2005,11,20);
        ZipCode zc = new ZipCode(4500,034);
        Address ad = new Address(725,zc);
        float kms = 100200;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                new VehicleCheckUp(d,ad, kms)
        );

        assertEquals("Date has surpassed the actual date.", exception.getMessage());
    }
}