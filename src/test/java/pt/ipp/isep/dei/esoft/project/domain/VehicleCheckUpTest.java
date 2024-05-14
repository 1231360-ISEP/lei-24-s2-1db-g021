package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

class VehicleCheckUpTest {
    @Test
    @DisplayName("Throw an Exception when kms are negative")
    void throwExceptionWhenKmsAreNegative(){
        Date d = new GregorianCalendar(2025, GregorianCalendar.NOVEMBER, 20).getTime();
        ZipCode zc = new ZipCode(4500,034);
        Address ad = new Address(725,zc);
        float kms = -100200;
        Date vehicleDate = new Date();
        PlateCertification plateCertification = new PlateCertification("a", "a", "a", 1, 1, vehicleDate, "");
        Vehicle vehicle = new Vehicle(1, new Date(), 20, plateCertification);

        assertThrows(IllegalArgumentException.class, () ->
                new VehicleCheckUp(d,ad, kms, vehicle)
        );
    }
    @Test
    @DisplayName("setKms() returning false when is negative")
    void setKmsReturnFalseWhenIsNegative(){
        Date d = new GregorianCalendar(2025,GregorianCalendar.MAY,12).getTime();
        ZipCode zc = new ZipCode(4500,034);
        Address ad = new Address(725,zc);
        float kms = 100200;
        Date vehicleDate = new Date();
        PlateCertification plateCertification = new PlateCertification("a", "a", "a", 1, 1, vehicleDate, "");
        Vehicle vehicle = new Vehicle(1, new Date(), 20, plateCertification);

        VehicleCheckUp vcu = new VehicleCheckUp(d,ad, kms, vehicle);

        float negativeKms = -1 * kms;
        assertFalse(vcu.setKms(negativeKms));
    }
}