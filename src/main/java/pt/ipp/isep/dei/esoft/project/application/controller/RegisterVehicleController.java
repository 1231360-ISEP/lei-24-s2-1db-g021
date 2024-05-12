package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Collaborator;
import pt.ipp.isep.dei.esoft.project.domain.Job;
import pt.ipp.isep.dei.esoft.project.domain.Vehicle;
import pt.ipp.isep.dei.esoft.project.domain.PlateCertification;
import pt.ipp.isep.dei.esoft.project.repository.*;
import pt.isep.lei.esoft.auth.domain.model.Email;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class RegisterVehicleController {
    private VehiclesRepository vehiclesRepository;
    private PlateCertificationsRepository plateCertificationsRepository;

    public RegisterVehicleController() {
        getVehiclesRepository();
        //getPlateCertificationsRepository();
    }

    /*private PlateCertificationsRepository getPlateCertificationsRepository() {
        if (plateCertificationsRepository == null) {
            Repositories repositories = Repositories.getInstance();
            plateCertificationsRepository = repositories.getPlateCertificationsRepository();
        }
        return plateCertificationsRepository;
    }*/

    public RegisterVehicleController(VehiclesRepository vehiclesRepository, PlateCertificationsRepository plateCertificationsRepository) {
        this.vehiclesRepository = vehiclesRepository;
        this.plateCertificationsRepository = plateCertificationsRepository;
    }

    private VehiclesRepository getVehiclesRepository() {
        if (vehiclesRepository == null) {
            Repositories repositories = Repositories.getInstance();
            vehiclesRepository = repositories.getVehiclesRepository();
        }
        return vehiclesRepository;
    }

    /**
     *
     * @param currentKm represents the vehicle's current km
     * @param acquisitionDate represents the date on which the vehicle was acquired by MusgoSublime
     * @param maintenance represents the distance, in km, that a given vehicle must go for inspection
     * @param plateCertification represents the vehicle plate
     *                           if the vehicle has all attributes valid,
     * @return the new vehicle
     *          if not it throws a IllegalArgumentException
     */
    public Optional<Vehicle> createVehicle(double currentKm, Date acquisitionDate, double maintenance, PlateCertification plateCertification) {
        Optional<Vehicle> newVehicle;
        try {
            newVehicle = vehiclesRepository.add(new Vehicle(currentKm,acquisitionDate,maintenance,plateCertification));
        } catch (IllegalArgumentException e) {
            return Optional.empty();
        }
        return  newVehicle;
    }

    public List<Vehicle> getVehiclesList() {
        return vehiclesRepository.getVehiclesList();
    }

    public List<PlateCertification> getPlateCertificationsList() {
        return plateCertificationsRepository.getPlateCertificationsList();
    }

}
