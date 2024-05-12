package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.VehiclesRepository;

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
}
