package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Vehicle;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.VehiclesRepository;

import java.util.ArrayList;
import java.util.List;

public class ListVehiclesCheckupController {
    private VehiclesRepository vehiclesRepository;

    public ListVehiclesCheckupController() {
        getVehiclesRepository();
    }

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

    public List<Vehicle> getVehiclesNeedingCheckup(){
        List<Vehicle> vehicles = vehiclesRepository.getVehiclesList();
        List<Vehicle> vehiclesNeedingIt = new ArrayList<Vehicle>();
        for (Vehicle vehicle:
             vehicles) {
                if(isVehicleCloseToExceedCheckup(vehicle)){
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
