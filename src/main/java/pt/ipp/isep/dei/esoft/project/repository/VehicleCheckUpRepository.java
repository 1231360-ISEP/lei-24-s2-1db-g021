package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.VehicleCheckUp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VehicleCheckUpRepository {
    private final List<VehicleCheckUp> vehiclesCheckUpList;

    public VehicleCheckUpRepository() {
        vehiclesCheckUpList = new ArrayList<>();
    }

    public Optional<VehicleCheckUp> add(VehicleCheckUp vehicleCheckUp) {

        Optional<VehicleCheckUp> newVehicleCheckUp = Optional.empty();
        boolean operationSuccess = false;

        if (validateVehicleCheckUp(vehicleCheckUp)) {
            newVehicleCheckUp = Optional.of(vehicleCheckUp.clone());
            operationSuccess = vehiclesCheckUpList.add(newVehicleCheckUp.get());
        }

        if (!operationSuccess) {
            newVehicleCheckUp = Optional.empty();
        }

        return newVehicleCheckUp;
    }

    private boolean validateVehicleCheckUp(VehicleCheckUp vehicle) {
        return !vehiclesCheckUpList.contains(vehicle);
    }

    /**
     * This method returns a defensive (immutable) copy of the list of vehicles check-ups.
     *
     * @return The list of vehicles check-ups.
     */
    public List<VehicleCheckUp> getVehiclesList() {
        //This is a defensive copy, so that the repository cannot be modified from the outside.
        return List.copyOf(vehiclesCheckUpList);
    }

    public boolean remove(VehicleCheckUp vehicleCheckUp) {
        return vehiclesCheckUpList.remove(vehicleCheckUp);
    }
}
