package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Vehicle;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.VehiclesRepository;

import java.util.ArrayList;
import java.util.List;

public class ListVehiclesCheckupController {
    private VehiclesRepository vehiclesRepository;

    /**
     * This constructor instantiates it with the default vehicles repository.
     */
    public ListVehiclesCheckupController() {
        getVehiclesRepository();
    }

    /**
     * This constructor instantiates it with the custom vehicles repository.
     * @param vehiclesRepository the custom vehicle repository
     */
    public ListVehiclesCheckupController(VehiclesRepository vehiclesRepository) {
        this.vehiclesRepository = vehiclesRepository;
    }
    private VehiclesRepository getVehiclesRepository(){
        if (vehiclesRepository == null) {
            Repositories repositories = Repositories.getInstance();
            vehiclesRepository = repositories.getVehiclesRepository();
        }
        return vehiclesRepository;
    }

    /**
     * This method gets the vehicles needing or almost needing a check-up
     * @return a list containing the vehicles needing or almost needing a check-up
     */
    public List<Vehicle> getVehiclesNeedingCheckup(){
        List<Vehicle> vehicles = vehiclesRepository.getVehiclesList();
        List<Vehicle> vehiclesNeedingIt = new ArrayList<Vehicle>();
        for (Vehicle vehicle:
             vehicles) {
                if(isVehicleNeedingOrAlmostCheckup(vehicle)){
                    vehiclesNeedingIt.add(vehicle);
                }
        }
        return vehiclesNeedingIt;
    }

    private boolean isVehicleNeedingOrAlmostCheckup(Vehicle vehicle){
        return didVehExceededCheckup(vehicle) || isVehicleCloseToExceedCheckup(vehicle);
    }
    private boolean didVehExceededCheckup(Vehicle vehicle){
        double maintenance = vehicle.getMaintenance();
        double currentKm = vehicle.getCurrentKm();
        double maintenanceGoal = 0;
        while(maintenanceGoal <= currentKm){
            maintenanceGoal += maintenance;
        }
        maintenanceGoal -= maintenance;
        return currentKm > maintenance;
    }
    private boolean isVehicleCloseToExceedCheckup(Vehicle vehicle){
        double maintenance = vehicle.getMaintenance();
        double currentKm = vehicle.getCurrentKm();

        double maintenanceGoal = 0;
        while(maintenanceGoal <= currentKm){
            maintenanceGoal += maintenance;
        }
        double margin = maintenanceGoal * 0.05; //5%
        if(currentKm >= maintenanceGoal - margin){
            return true;
        }
        return false;
    }
}
