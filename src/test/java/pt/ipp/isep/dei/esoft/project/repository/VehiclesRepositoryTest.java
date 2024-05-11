package pt.ipp.isep.dei.esoft.project.repository;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.PlateCertification;
import pt.ipp.isep.dei.esoft.project.domain.Vehicle;

import java.text.ParseException;
import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VehiclesRepositoryTest {
    @Test
    void ensureNewVehicleSuccessfullyAdded() throws ParseException {
        // Arrange
        String ExampleDate = "2006-03-23";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateTest = sdf.parse(ExampleDate);

        String ExampleDatePC = "2005-02-01";
        SimpleDateFormat sdfPC = new SimpleDateFormat("yyyy-MM-dd");
        Date dateTestPC = sdfPC.parse(ExampleDatePC);

        PlateCertification plateCertification = new PlateCertification("Renault","Clio","Electric",900,1200,dateTestPC,"72-XQ-70");
        VehiclesRepository vehiclesRepository = new VehiclesRepository();
        Vehicle vehicle = new Vehicle(1000,dateTest,5000,plateCertification);

        // Act
        Optional<Vehicle> addedVehicle = vehiclesRepository.add(vehicle);

        // Assert
        assertTrue(addedVehicle.isPresent());
        assertEquals(vehicle, addedVehicle.get());
    }

    @Test
    void ensureAddingDuplicateVehicleFails() throws ParseException {
        // Arrange
        String ExampleDate = "2006-03-23";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateTest = sdf.parse(ExampleDate);

        String ExampleDatePC = "2005-02-01";
        SimpleDateFormat sdfPC = new SimpleDateFormat("yyyy-MM-dd");
        Date dateTestPC = sdfPC.parse(ExampleDatePC);

        PlateCertification plateCertification = new PlateCertification("Renault","Clio","Electric",900,1200,dateTestPC,"72-XQ-70");
        VehiclesRepository vehiclesRepository = new VehiclesRepository();
        Vehicle vehicle = new Vehicle(1000,dateTest,5000,plateCertification);

        // Act
        Optional<Vehicle> addedFirstVehicle = vehiclesRepository.add(vehicle);
        Optional<Vehicle> addedSecondVehicle = vehiclesRepository.add(vehicle);

        // Assert
        assertTrue(addedFirstVehicle.isPresent());
        assertTrue(addedSecondVehicle.isEmpty());
    }

    @Test
    void ensurePlateCertificationsListIsNotNull() {
        // Arrange
        VehiclesRepository vehiclesRepository = new VehiclesRepository();

        // Act
        List<Vehicle> vehiclesList = vehiclesRepository.getVehiclesList();

        // Assert
        assertTrue(vehiclesList.isEmpty());

    }
}
