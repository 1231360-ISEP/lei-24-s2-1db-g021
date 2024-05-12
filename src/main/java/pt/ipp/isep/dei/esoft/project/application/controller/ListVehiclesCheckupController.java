package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Vehicle;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.VehiclesRepository;

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

    public void getVehiclesNeedingCheckup(){
        List<Vehicle> vehicles = vehiclesRepository.getVehiclesList();
        for (Vehicle vehicle:
             vehicles) {

        }
    }

    private boolean isVehicleNeedingOrAlmostCheckup(Vehicle vehicle){
        return true;
    }
    private boolean didVehExceededCheckup(Vehicle vehicle){
        double maintenance = vehicle.getMaintenance();
        double currentKm = vehicle.getCurrentKm();
        return false;
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
