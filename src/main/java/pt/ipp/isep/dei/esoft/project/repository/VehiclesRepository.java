package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VehiclesRepository {
    private final List<Vehicle> vehiclesList;

    /**
     * Constructs a new VehiclesRepository object.
     */
    public VehiclesRepository() {
        vehiclesList = new ArrayList<>();
    }

    /**
     * Adds a new Vehicle to the repository.
     *
     * @param vehicle The Vehicle object to be added.
     * @return An Optional containing the newly added Vehicle, or empty if the operation fails.
     */
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
     * Retrieves a defensive (immutable) copy of the list of vehicles.
     *
     * @return The list of vehicles.
     */
    public List<Vehicle> getVehiclesList() {
        // This is a defensive copy, so that the repository cannot be modified from the outside.
        return List.copyOf(vehiclesList);
    }

    /**
     * Removes a Vehicle from the repository.
     *
     * @param vehicle The Vehicle object to be removed.
     * @return True if the Vehicle was successfully removed, false otherwise.
     */
    public boolean remove(Vehicle vehicle) {
        return vehiclesList.remove(vehicle);
    }
}