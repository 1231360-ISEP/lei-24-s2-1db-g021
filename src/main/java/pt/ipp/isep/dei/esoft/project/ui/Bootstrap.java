package pt.ipp.isep.dei.esoft.project.ui;

import pt.ipp.isep.dei.esoft.project.application.controller.authorization.AuthenticationController;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.*;

import java.util.Calendar;
import java.util.Date;

public class Bootstrap implements Runnable {

    //Add some task categories to the repository as bootstrap
    public void run() {
        addTaskCategories();
        addOrganization();
        addUsers();
    }

    private void addOrganization() {
        //TODO: add organizations bootstrap here
        //get organization repository
        OrganizationRepository organizationRepository = Repositories.getInstance().getOrganizationRepository();
        Organization organization = new Organization("This Company");
        Date bornDate = new Date(1234, Calendar.MAY, 6);
        Date admDate = new Date(6543, Calendar.FEBRUARY, 1);
        ZipCode zipCode = new ZipCode(4200,400);
        Address address = new Address(123, zipCode);
        organization.addCollaborator(new Collaborator("admin", bornDate, admDate, address, 123456789,"admin@this.app", 123456789, 123456789));
        organization.addCollaborator(new Collaborator("collaborator",bornDate,admDate, address, 987654321,"collaborator@this.app", 987654321, 987654321));
        organizationRepository.add(organization);
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