package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Vehicle;
import pt.ipp.isep.dei.esoft.project.domain.VehicleCheckUp;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.VehicleCheckUpRepository;
import pt.ipp.isep.dei.esoft.project.repository.VehiclesRepository;

import java.util.ArrayList;
import java.util.List;

public class ListVehiclesCheckupController {
    private VehiclesRepository vehiclesRepository;
    private VehicleCheckUpRepository vehiclesCheckUpsRepository;

    /**
     * This constructor instantiates it with the default vehicle and vehicles check-ups repositories.
     */
    public ListVehiclesCheckupController() {
        getVehiclesRepository();
        getVehiclesCheckUpsRepository();
    }

    /**
     * This constructor instantiates it with the custom vehicles and vehicles check-ups repositories.
     * @param vehiclesRepository the custom vehicle repository
     * @param vehicleCheckUpRepository the custom vehicles check-ups repository
     */
    public ListVehiclesCheckupController(VehiclesRepository vehiclesRepository, VehicleCheckUpRepository vehicleCheckUpRepository) {
        this.vehiclesRepository = vehiclesRepository;
        this.vehiclesCheckUpsRepository = vehicleCheckUpRepository;
    }
    private VehiclesRepository getVehiclesRepository(){
        if (vehiclesRepository == null) {
            Repositories repositories = Repositories.getInstance();
            vehiclesRepository = repositories.getVehiclesRepository();
        }
        return vehiclesRepository;
    }
    private VehicleCheckUpRepository getVehiclesCheckUpsRepository(){
        if (vehiclesCheckUpsRepository == null) {
            Repositories repositories = Repositories.getInstance();
            vehiclesCheckUpsRepository = repositories.getVehicleCheckUpRepository();
        }
        return vehiclesCheckUpsRepository;
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
        return currentKm > maintenanceGoal;
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

    private List<VehicleCheckUp> getVehicleCheckUps(Vehicle vehicle){
        List<VehicleCheckUp> vehicleCheckUps = new ArrayList<VehicleCheckUp>();
        List<VehicleCheckUp> vehiclesCheckUpsList = vehiclesCheckUpsRepository.getVehiclesCheckUpsList();
        for (VehicleCheckUp vehCheckUp:
                vehiclesCheckUpsList) {
            if(vehCheckUp.getVehicle() == vehicle){
                vehicleCheckUps.add(vehCheckUp);
            }
        }
        return  vehicleCheckUps;
    }
}
