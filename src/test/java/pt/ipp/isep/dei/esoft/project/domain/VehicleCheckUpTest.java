package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

class VehicleCheckUpTest {

    @Test
    @DisplayName("Throw an Exception when date surpassed the actual date")
    void throwExceptionWhenDateSurpassed() {
        Date d = new GregorianCalendar(2005, GregorianCalendar.NOVEMBER, 20).getTime();
        ZipCode zc = new ZipCode(4500,034);
        Address ad = new Address(725,zc);
        float kms = 100200;

        assertThrows(IllegalArgumentException.class, () ->
                new VehicleCheckUp(d,ad, kms)
        );
    }
    @Test
    @DisplayName("Throw an Exception when kms are negative")
    void throwExceptionWhenKmsAreNegative(){
        Date d = new GregorianCalendar(2025, GregorianCalendar.NOVEMBER, 20).getTime();
        ZipCode zc = new ZipCode(4500,034);
        Address ad = new Address(725,zc);
        float kms = -100200;

        assertThrows(IllegalArgumentException.class, () ->
                new VehicleCheckUp(d,ad, kms)
        );
    }
    @Test
    @DisplayName("setDate() returning false when date is surpassed")
    void setDateReturnFalseWhenDateSurpassed(){
        Date d = new GregorianCalendar(2005, GregorianCalendar.NOVEMBER, 20).getTime();
        ZipCode zc = new ZipCode(4500,034);
        Address ad = new Address(725,zc);
        float kms = 100200;

        VehicleCheckUp vcu = new VehicleCheckUp(new Date(),ad, kms);
        assertFalse(vcu.setDate(d));
    }
    @Test
    @DisplayName("setKms() returning false when is negative")
    void setKmsReturnFalseWhenIsNegative(){
        Date d = new GregorianCalendar(2025,GregorianCalendar.MAY,12).getTime();
        ZipCode zc = new ZipCode(4500,034);
        Address ad = new Address(725,zc);
        float kms = 100200;

        VehicleCheckUp vcu = new VehicleCheckUp(d,ad, kms);

        float negativeKms = -1 * kms;
        assertFalse(vcu.setKms(negativeKms));
    }
}