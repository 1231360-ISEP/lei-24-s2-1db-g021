package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class VehiclesTest {
    @Test
    public void testConstruction() throws ParseException {
        //Arrange
        String ExampleDate = "2005-01-02";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateTest = sdf.parse(ExampleDate);

        PlateCertification plateCertification = new PlateCertification("Renault","Clio","Electric",900,1200,dateTest,"72-XQ-70");
        Vehicle vehicle = new Vehicle(10000, new Date(), 2000, plateCertification);

        //Act and assert
        assertEquals(10000, vehicle.getCurrentKm(), 0);
        assertNotNull(vehicle.getAcquisitionDate());
        assertEquals(2000, vehicle.getMaintenance(), 0);
        assertEquals(plateCertification, vehicle.getPlateCertification());
    }

    @Test
    public void testSetCurrentKm_NegativeValue() throws ParseException {
        //Arrange
        String ExampleDate = "2005-01-02";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateTest = sdf.parse(ExampleDate);

        PlateCertification plateCertification = new PlateCertification("Renault","Clio","Electric",900,1200,dateTest,"72-XQ-70");
        Vehicle vehicle = new Vehicle(10000, new Date(), 2000, plateCertification);

        //Act and assert (ensure that an exception is launched)
        vehicle.setCurrentKm(-100);
    }

    @Test
    public void testSetMaintenance_NegativeValue() throws ParseException {
        //Arrange
        String ExampleDate = "2005-01-02";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateTest = sdf.parse(ExampleDate);

        PlateCertification plateCertification = new PlateCertification("Renault","Clio","Electric",900,1200,dateTest,"72-XQ-70");
        Vehicle vehicle = new Vehicle(10000, new Date(), 2000, plateCertification);

        //Act and assert (ensure that an exception is launched)
        vehicle.setMaintenance(-200);
    }

    @Test
    public void testSetMaintenance_ZeroValue() throws ParseException {
        //Arrange
        String ExampleDate = "2005-01-02";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateTest = sdf.parse(ExampleDate);

        PlateCertification plateCertification = new PlateCertification("Renault","Clio","Electric",900,1200,dateTest,"72-XQ-70");
        Vehicle vehicle = new Vehicle(10000, new Date(), 2000, plateCertification);

        //Act and assert (ensure that an exception is launched)
        vehicle.setMaintenance(0);
    }

    @Test
    public void testEqualsAndHashCode() throws ParseException {
        //Arrange
        String ExampleDate = "2005-01-02";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateTest = sdf.parse(ExampleDate);

        String ExampleDate2 = "2006-08-10";
        Date dateTest2 = sdf.parse(ExampleDate2);

        PlateCertification plateCertification1 = new PlateCertification("Renault","Clio","Electric",900,1200,dateTest,"72-XQ-70");
        PlateCertification plateCertification2 = new PlateCertification("Mercedes","Benz","Hybrid",1050,1400,dateTest2,"53-NA-63");

        Vehicle vehicle1 = new Vehicle(10000, new Date(), 2000, plateCertification1);
        Vehicle vehicle2 = new Vehicle(10000, new Date(), 2000, plateCertification1);
        Vehicle vehicle3 = new Vehicle(20000, new Date(), 2500, plateCertification2);

        //Act and assert
        assertEquals(vehicle1, vehicle2);
        assertNotEquals(vehicle1, vehicle3);
        assertEquals(vehicle1.hashCode(), vehicle2.hashCode());
        assertNotEquals(vehicle1.hashCode(), vehicle3.hashCode());
    }
}