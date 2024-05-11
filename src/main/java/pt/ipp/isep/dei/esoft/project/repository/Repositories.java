package pt.ipp.isep.dei.esoft.project.repository;

public class Repositories {

    private static Repositories instance;
    private final SkillsRepository skillsRepository;
    private final CollaboratorsRepository collaboratorsRepository;
    private final TeamRepository teamRepository;
    private final TaskCategoryRepository taskCategoryRepository;
    private final AuthenticationRepository authenticationRepository;
    private final TasksRepository tasksRepository;

    private Repositories() {
        skillsRepository = new SkillsRepository();
        collaboratorsRepository = new CollaboratorsRepository();
        teamRepository = new TeamRepository();
        taskCategoryRepository = new TaskCategoryRepository();
        authenticationRepository = new AuthenticationRepository();
        tasksRepository = new TasksRepository();
    }

    public static Repositories getInstance() {
        if (instance == null) {
            synchronized (Repositories.class) {
                instance = new Repositories();
            }
        }
        return instance;
    }

    public TaskCategoryRepository getTaskCategoryRepository() {
        return taskCategoryRepository;
    }

    public AuthenticationRepository getAuthenticationRepository() {
        return authenticationRepository;
    }

    public SkillsRepository getSkillsRepository() {
        return skillsRepository;
    }

    public CollaboratorsRepository getCollaboratorsRepository() {
        return collaboratorsRepository;
    }

    public TeamRepository getTeamRepository() {
        return teamRepository;
    }

    public TasksRepository getTaskRepository() {
        return tasksRepository;
    }

}