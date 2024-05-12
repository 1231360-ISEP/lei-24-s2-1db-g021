package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

class VehicleCheckUpTest {

    @Test
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
    void setDateReturnFalseWhenDateSurpassed(){
        Date d = new GregorianCalendar(2005, GregorianCalendar.NOVEMBER, 20).getTime();
        ZipCode zc = new ZipCode(4500,034);
        Address ad = new Address(725,zc);
        float kms = 100200;

        VehicleCheckUp vcu = new VehicleCheckUp(new Date(),ad, kms);
        assertFalse(vcu.setDate(d));
    }
    @Test
    void setKmsReturnFalseWhenIsNegative(){
        Date d = new Date();
        ZipCode zc = new ZipCode(4500,034);
        Address ad = new Address(725,zc);
        float kms = -100200;

        VehicleCheckUp vcu = new VehicleCheckUp(d,ad, kms);
        assertFalse(vcu.setKms(kms));
    }
}