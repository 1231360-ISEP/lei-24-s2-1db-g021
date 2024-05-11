package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VehiclesRepository {
    private final List<Vehicle> vehiclesList;

    public VehiclesRepository() {
        vehiclesList = new ArrayList<>();
    }

    public Optional<Vehicle> add(Vehicle vehicle) {

        Optional<Vehicle> newVehicle = Optional.empty();
        boolean operationSuccess = false;

        if (validateVehicle(vehicle)) {
            newVehicle = Optional.of(vehicle.clone());
            operationSuccess = vehiclesList.add(newVehicle.get());
        }

        if (!operationSuccess) {
            newVehicle = Optional.empty();
        }

        return newVehicle;
    }

    private boolean validateVehicle(Vehicle vehicle) {
        return !vehiclesList.contains(vehicle);
    }

    /**
     * This method returns a defensive (immutable) copy of the list of vehicles.
     *
     * @return The list of vehicles.
     */
    public List<Vehicle> getVehiclesList() {
        //This is a defensive copy, so that the repository cannot be modified from the outside.
        return List.copyOf(vehiclesList);
    }
}