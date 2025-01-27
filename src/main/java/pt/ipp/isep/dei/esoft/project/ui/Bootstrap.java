package pt.ipp.isep.dei.esoft.project.ui;

import pt.ipp.isep.dei.esoft.project.application.controller.authorization.AuthenticationController;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.*;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Bootstrap implements Runnable {

    //Add some task categories to the repository as bootstrap
    public void run() {
        /*addTaskCategories();
        addOrganization();
        addUsers();*/
        addVehicles(true);
    }

    private void addOrganization() {
        //TODO: add organizations bootstrap here
        CollaboratorsRepository collaboratorsRepository = Repositories.getInstance().getCollaboratorsRepository();

        Date bornDate = new Date(1234, Calendar.MAY, 6);
        Date admDate = new Date(6543, Calendar.FEBRUARY, 1);
        ZipCode zipCode = new ZipCode(4200,400);
        Address address = new Address(123, zipCode);
        Collaborator admin =  new Collaborator("admin", bornDate, admDate, address, 123456789,"admin@this.app", 123456789, 123456789);
        Collaborator collaborator = new Collaborator("collaborator",bornDate,admDate, address, 987654321,"collaborator@this.app", 987654321, 987654321);

        collaboratorsRepository.add(admin);
        collaboratorsRepository.add(collaborator);
    }

    private void addSkills(){
        SkillsRepository skillsRepository = Repositories.getInstance().getSkillsRepository();

        Skill s1 = new Skill("Carta Carro");
        Skill s2 = new Skill("Carta Mota");
        Skill s3 = new Skill("Carta Barco");

        skillsRepository.add(s1);
        skillsRepository.add(s2);
        skillsRepository.add(s3);
    }
    private void addVehicles(boolean addCheckupstoo){
        VehiclesRepository vehiclesRepository = Repositories.getInstance().getVehiclesRepository();
        Date d1 = new GregorianCalendar(2005, Calendar.FEBRUARY, 28).getTime();
        PlateCertification p1 = new PlateCertification("Ford", "Fiesta", "Car", 100000, 100000, d1, "12-AB-34");
        Vehicle v1 = new Vehicle(1149, d1,200, p1);
        Date d2 = new GregorianCalendar(2006, Calendar.JUNE, 7).getTime();
        PlateCertification p2 = new PlateCertification("Renault", "Twingo", "Car", 120000, 120009, d2, "12-AC-34");
        Vehicle v2 = new Vehicle(1400, d2,1000, p2);
        Date d3 = new GregorianCalendar(2024, Calendar.NOVEMBER, 18).getTime();
        PlateCertification p3 = new PlateCertification("Mercedes-Benz", "V 220", "Car", 150000, 150060, d3, "62-GB-34");
        Vehicle v3 = new Vehicle(10010, d3,1000, p3);
        vehiclesRepository.add(v1);
        vehiclesRepository.add(v2);
        vehiclesRepository.add(v3);
        if (addCheckupstoo){
            VehicleCheckUpRepository vehicleCheckUpRepository = Repositories.getInstance().getVehicleCheckUpRepository();
            VehicleCheckUp v1c1 = new VehicleCheckUp(new GregorianCalendar(2023, Calendar.JUNE,15).getTime(), new Address(731, new ZipCode(4500,034)),675,v1);
            VehicleCheckUp v1c2 = new VehicleCheckUp(new GregorianCalendar(2024, Calendar.JANUARY,21).getTime(), new Address(731, new ZipCode(4500,034)),893,v1);
            VehicleCheckUp v1c3 = new VehicleCheckUp(new GregorianCalendar(2024, Calendar.DECEMBER,16).getTime(), new Address(731, new ZipCode(4500,034)),1250,v1);
            vehicleCheckUpRepository.add(v1c1);
            vehicleCheckUpRepository.add(v1c2);
            vehicleCheckUpRepository.add(v1c3);
        }
    }
    private void addTaskCategories() {
        //TODO: add bootstrap Task Categories here

        SkillsRepository skillsRepository = Repositories.getInstance().getSkillsRepository();
        skillsRepository.add(new Skill("Register Skill: "));

        TaskCategoryRepository taskCategoryRepository = Repositories.getInstance().getTaskCategoryRepository();
        taskCategoryRepository.add(new TaskCategory("Analysis"));
        taskCategoryRepository.add(new TaskCategory("Design"));
        taskCategoryRepository.add(new TaskCategory("Implementation"));
        taskCategoryRepository.add(new TaskCategory("Development"));
        taskCategoryRepository.add(new TaskCategory("Testing"));
        taskCategoryRepository.add(new TaskCategory("Deployment"));
        taskCategoryRepository.add(new TaskCategory("Maintenance"));
    }

    private void addUsers() {
        //TODO: add Authentication users here: should be created for each user in the organization
        AuthenticationRepository authenticationRepository = Repositories.getInstance().getAuthenticationRepository();
        authenticationRepository.addUserRole(AuthenticationController.ROLE_ADMIN, AuthenticationController.ROLE_ADMIN);
        authenticationRepository.addUserRole(AuthenticationController.ROLE_COLLABORATOR,
                AuthenticationController.ROLE_COLLABORATOR);

        authenticationRepository.addUserWithRole("Main Administrator", "admin@this.app", "admin",
                AuthenticationController.ROLE_ADMIN);

        authenticationRepository.addUserWithRole("Collaborator", "collaborator@this.app", "pwd",
                AuthenticationController.ROLE_COLLABORATOR);
    }
}