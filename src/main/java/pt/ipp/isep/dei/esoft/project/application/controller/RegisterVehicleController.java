package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Vehicle;
import pt.ipp.isep.dei.esoft.project.domain.PlateCertification;
import pt.ipp.isep.dei.esoft.project.repository.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Controller class for registering Vehicle objects.
 */
public class RegisterVehicleController {
    private VehiclesRepository vehiclesRepository;
    private PlateCertificationsRepository plateCertificationsRepository;

    /**
     * Constructs a new RegisterVehicleController object.
     */
    public RegisterVehicleController() {
        getVehiclesRepository();
        getPlateCertificationsRepository();
    }

    /**
     * Constructs a new RegisterVehicleController object with specified repositories.
     *
     * @param vehiclesRepository           The repository for vehicles.
     * @param plateCertificationsRepository The repository for plate certifications.
     */
    public RegisterVehicleController(VehiclesRepository vehiclesRepository, PlateCertificationsRepository plateCertificationsRepository) {
        this.vehiclesRepository = vehiclesRepository;
        this.plateCertificationsRepository = plateCertificationsRepository;
    }

    private PlateCertificationsRepository getPlateCertificationsRepository() {
        if (plateCertificationsRepository == null) {
            Repositories repositories = Repositories.getInstance();
            plateCertificationsRepository = repositories.getPlateCertificationsRepository();
        }
        return plateCertificationsRepository;
    }

    private VehiclesRepository getVehiclesRepository() {
        if (vehiclesRepository == null) {
            Repositories repositories = Repositories.getInstance();
            vehiclesRepository = repositories.getVehiclesRepository();
        }
        return vehiclesRepository;
    }

    /**
     * Creates a new Vehicle with the given attributes.
     *
     * @param currentKm           The current kilometers of the vehicle.
     * @param acquisitionDate     The acquisition date of the vehicle by MusgoSublime.
     * @param maintenance         The distance, in km, that a given vehicle must go for inspection.
     * @param plateCertification  The plate certification of the vehicle.
     * @return An Optional containing the newly created Vehicle, or empty if the operation fails.
     */
    public Optional<Vehicle> createVehicle(double currentKm, Date acquisitionDate, double maintenance, PlateCertification plateCertification) {
        Optional<Vehicle> newVehicle;
        try {
            newVehicle = vehiclesRepository.add(new Vehicle(currentKm, acquisitionDate, maintenance, plateCertification));
        } catch (IllegalArgumentException e) {
            return Optional.empty();
        }
        return newVehicle;
    }

    /**
     * Retrieves the list of all vehicles.
     *
     * @return The list of all vehicles.
     */
    public List<Vehicle> getVehiclesList() {
        return vehiclesRepository.getVehiclesList();
    }

    /**
     * Retrieves the list of all plate certifications.
     *
     * @return The list of all plate certifications.
     */
    public List<PlateCertification> getPlateCertificationsList() {
        return plateCertificationsRepository.getPlateCertificationsList();
    }
}