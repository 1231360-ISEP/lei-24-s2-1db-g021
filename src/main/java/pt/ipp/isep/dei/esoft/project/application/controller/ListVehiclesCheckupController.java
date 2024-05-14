package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Vehicle;
import pt.ipp.isep.dei.esoft.project.domain.VehicleCheckUp;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.VehicleCheckUpRepository;
import pt.ipp.isep.dei.esoft.project.repository.VehiclesRepository;

import java.util.*;

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
     * @return a Map containing the vehicles needing or almost needing a check-up
     */
    public Map<Vehicle, VehicleCheckUp[]> getVehiclesNeedingCheckup(){
        List<Vehicle> vehicles = vehiclesRepository.getVehiclesList();
        Map<Vehicle, VehicleCheckUp[]> vehiclesNeedingIt = new HashMap<>();
        for (Vehicle vehicle:
             vehicles) {
                if(isVehicleNeedingOrAlmostCheckup(vehicle)){
                    List<VehicleCheckUp> vehicleCheckUps = vehiclesCheckUpsRepository.getVehicleCheckUps(vehicle);
                    VehicleCheckUp[] lastNextCheckups = getNextAndLastCheckup(vehicleCheckUps);
                    vehiclesNeedingIt.put(vehicle, lastNextCheckups);
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
    private VehicleCheckUp[] getNextAndLastCheckup(List<VehicleCheckUp> vehicleCheckUpList){
        VehicleCheckUp lastCheckup = null;
        VehicleCheckUp nextCheckup = null;
        Date momentDate = new Date();
        for (VehicleCheckUp vehCheckUp:
             vehicleCheckUpList) {
            if (nextCheckup == null) {
                nextCheckup = vehCheckUp;
            }
            if (lastCheckup == null) {
                lastCheckup = vehCheckUp;
            }
            if(vehCheckUp.getDate().after(lastCheckup.getDate()) && vehCheckUp.getDate().before(momentDate))
                lastCheckup = vehCheckUp;
            if(vehCheckUp.getDate().before(nextCheckup.getDate()) && vehCheckUp.getDate().after(momentDate))
                nextCheckup = vehCheckUp;
        }
        return new VehicleCheckUp[]{lastCheckup, nextCheckup};
    }
}
