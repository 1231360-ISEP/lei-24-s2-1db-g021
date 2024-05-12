package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class PlateCertificationTest {
    @Test
    public void testPlateCertificationConstructor() throws ParseException {
        //Arrange
        String exampleDate = "2005-01-02";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateTest = sdf.parse(exampleDate);

        //Act
        PlateCertification plateCertification = new PlateCertification("Renault","Clio","Electric",900,1200,dateTest,"72-XQ-70");

        //Assert
        assertEquals("Renault", plateCertification.getBrand());
        assertEquals("Clio", plateCertification.getModel());
        assertEquals("Electric", plateCertification.getType());
        assertEquals(900, plateCertification.getTare());
        assertEquals(1200, plateCertification.getGrossWeight());
        assertEquals(dateTest, plateCertification.getRegisterDate());
        assertEquals("72-XQ-70", plateCertification.getPlate());
    }

    @Test
    public void testSetTare_NegativeValue() throws ParseException {
        //Arrange
        String exampleDate = "2005-01-02";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateTest = sdf.parse(exampleDate);
        PlateCertification plateCertification = new PlateCertification("Renault","Clio","Electric",900,1200,dateTest,"72-XQ-70");

        //Act and assert (ensure that an exception is launched)
        assertThrows(IllegalArgumentException.class, () -> plateCertification.setTare(-100));
    }

    @Test
    public void testSetTare_ZeroValue() throws ParseException {
        //Arrange
        String exampleDate = "2005-01-02";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateTest = sdf.parse(exampleDate);
        PlateCertification plateCertification = new PlateCertification("Renault","Clio","Electric",900,1200,dateTest,"72-XQ-70");

        //Act and assert (ensure that an exception is launched)
        assertThrows(IllegalArgumentException.class, () -> plateCertification.setTare(0));
    }

    @Test
    public void testSetGrossWeight_NegativeValue() throws ParseException {
        //Arrange
        String exampleDate = "2005-01-02";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateTest = sdf.parse(exampleDate);
        PlateCertification plateCertification = new PlateCertification("Renault","Clio","Electric",900,1200,dateTest,"72-XQ-70");

        //Act and assert (ensure that an exception is launched)
        assertThrows(IllegalArgumentException.class, () -> plateCertification.setGrossWeight(-200));
    }

    @Test
    public void testSetGrossWeight_ZeroValue() throws ParseException {
        //Arrange
        String exampleDate = "2005-01-02";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateTest = sdf.parse(exampleDate);
        PlateCertification plateCertification = new PlateCertification("Renault","Clio","Electric",900,1200,dateTest,"72-XQ-70");

        //Act and assert (ensure that an exception is launched)
        assertThrows(IllegalArgumentException.class, () -> plateCertification.setGrossWeight(0));
    }

    @Test
    public void testSetPlateWithNull() throws ParseException {
        //Arrange
        String exampleDate = "2005-01-02";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateTest = sdf.parse(exampleDate);
        PlateCertification plateCertification = new PlateCertification("Renault","Clio","Electric",900,1200,dateTest,"72-XQ-70");

        //Act and assert (ensure that an exception is launched)
        assertThrows(IllegalArgumentException.class, () -> plateCertification.setPlate(null));
    }

    @Test
    public void testSetPlateWithEmpty() throws ParseException {
        //Arrange
        String exampleDate = "2005-01-02";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateTest = sdf.parse(exampleDate);
        PlateCertification plateCertification = new PlateCertification("Renault","Clio","Electric",900,1200,dateTest,"72-XQ-70");

        //Act and assert (ensure that an exception is launched)
        assertThrows(IllegalArgumentException.class, () -> plateCertification.setPlate(""));
    }

    @Test
    public void testSetModelWithNull() throws ParseException {
        //Arrange
        String exampleDate = "2005-01-02";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateTest = sdf.parse(exampleDate);
        PlateCertification plateCertification = new PlateCertification("Renault","Clio","Electric",900,1200,dateTest,"72-XQ-70");

        //Act and assert (ensure that an exception is launched)
        assertThrows(IllegalArgumentException.class, () -> plateCertification.setModel(null));
    }

    @Test
    public void testSetModelWithEmpty() throws ParseException {
        //Arrange
        String exampleDate = "2005-01-02";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateTest = sdf.parse(exampleDate);
        PlateCertification plateCertification = new PlateCertification("Renault","Clio","Electric",900,1200,dateTest,"72-XQ-70");

        //Act and assert (ensure that an exception is launched)
        assertThrows(IllegalArgumentException.class, () -> plateCertification.setModel(""));
    }

    @Test
    public void testSetBrandWithNull() throws ParseException {
        //Arrange
        String exampleDate = "2005-01-02";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateTest = sdf.parse(exampleDate);
        PlateCertification plateCertification = new PlateCertification("Renault","Clio","Electric",900,1200,dateTest,"72-XQ-70");

        //Act and assert (ensure that an exception is launched)
        assertThrows(IllegalArgumentException.class, () -> plateCertification.setBrand(null));
    }

    @Test
    public void testSetBrandWithEmpty() throws ParseException {
        //Arrange
        String exampleDate = "2005-01-02";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateTest = sdf.parse(exampleDate);
        PlateCertification plateCertification = new PlateCertification("Renault","Clio","Electric",900,1200,dateTest,"72-XQ-70");

        //Act and assert (ensure that an exception is launched)
        assertThrows(IllegalArgumentException.class, () -> plateCertification.setBrand(""));
    }

    @Test
    public void testSetTypeWithNull() throws ParseException {
        //Arrange
        String exampleDate = "2005-01-02";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateTest = sdf.parse(exampleDate);
        PlateCertification plateCertification = new PlateCertification("Renault","Clio","Electric",900,1200,dateTest,"72-XQ-70");

        //Act and assert (ensure that an exception is launched)
        assertThrows(IllegalArgumentException.class, () -> plateCertification.setType(null));
    }

    @Test
    public void testSetTypeWithEmpty() throws ParseException {
        //Arrange
        String exampleDate = "2005-01-02";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateTest = sdf.parse(exampleDate);
        PlateCertification plateCertification = new PlateCertification("Renault","Clio","Electric",900,1200,dateTest,"72-XQ-70");

        //Act and assert (ensure that an exception is launched)
        assertThrows(IllegalArgumentException.class, () -> plateCertification.setType(""));
    }

    @Test
    public void testEqualsAndHashCode() throws ParseException {
        //Arrange
        String exampleDate1 = "2005-01-02";
        String exampleDate2 = "2006-08-10";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateTest1 = sdf.parse(exampleDate1);
        Date dateTest2 = sdf.parse(exampleDate2);

        PlateCertification plateCertification1 = new PlateCertification("Renault","Clio","Electric",900,1200,dateTest1,"72-XQ-70");
        PlateCertification plateCertification2 = new PlateCertification("Renault","Clio","Electric",900,1200,dateTest1,"72-XQ-70");
        PlateCertification plateCertification3 = new PlateCertification("Mercedes","Benz","Hybrid",1050,1400,dateTest2,"53-NA-63");

        //Act and assert
        assertEquals(plateCertification1, plateCertification2);
        assertNotEquals(plateCertification1, plateCertification3);
        assertEquals(plateCertification1.hashCode(), plateCertification2.hashCode());
        assertNotEquals(plateCertification1.hashCode(), plateCertification3.hashCode());
    }
}