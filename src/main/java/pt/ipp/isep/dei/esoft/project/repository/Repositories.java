package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.application.session.ApplicationSession;

public class Repositories {

    private static Repositories instance;
    private final SkillsRepository skillsRepository;
    private final CollaboratorsRepository collaboratorsRepository;
    private final TeamRepository teamRepository;
    private final OrganizationRepository organizationRepository;
    private final TaskCategoryRepository taskCategoryRepository;
    private final AuthenticationRepository authenticationRepository;

    private Repositories() {
        skillsRepository = new SkillsRepository();
        collaboratorsRepository = new CollaboratorsRepository();
        teamRepository = new TeamRepository();
        organizationRepository = new OrganizationRepository();
        taskCategoryRepository = new TaskCategoryRepository();
        authenticationRepository = new AuthenticationRepository();
    }

    public static Repositories getInstance() {
        if (instance == null) {
            synchronized (Repositories.class) {
                instance = new Repositories();
            }
        }
        return instance;
    }

    public OrganizationRepository getOrganizationRepository() {
        return organizationRepository;
    }

    public TaskCategoryRepository getTaskCategoryRepository() {
        return taskCategoryRepository;
    }

    public AuthenticationRepository getAuthenticationRepository() {
        return authenticationRepository;
    }

    public SkillsRepository getSkillsRepository() { return skillsRepository;}

    public CollaboratorsRepository getCollaboratorsRepository() { return collaboratorsRepository; }

    public TeamRepository getTeamRepository() { return teamRepository; }

}