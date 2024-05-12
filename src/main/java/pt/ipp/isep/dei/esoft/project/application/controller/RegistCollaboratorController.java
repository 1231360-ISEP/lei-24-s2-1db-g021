package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Collaborator;
import pt.ipp.isep.dei.esoft.project.domain.Task;
import pt.ipp.isep.dei.esoft.project.domain.TaskCategory;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.TaskCategoryRepository;
import pt.ipp.isep.dei.esoft.project.repository.TasksRepository;
import pt.isep.lei.esoft.auth.domain.model.Email;

import java.util.List;
import java.util.Optional;

public class RegistCollaboratorController {

    private TaskCategoryRepository taskCategoryRepository;
    private AuthenticationRepository authenticationRepository;
    private TasksRepository tasksRepository;


    //Repository instances are obtained from the Repositories class
    public RegistCollaboratorController() {
        getTaskCategoryRepository();
        getAuthenticationRepository();
        getTaskRepository();
    }

    //Allows receiving the repositories as parameters for testing purposes
    public RegistCollaboratorController(TaskCategoryRepository taskCategoryRepository,
                                        AuthenticationRepository authenticationRepository,
                                        TasksRepository tasksRepository) {
        this.taskCategoryRepository = taskCategoryRepository;
        this.authenticationRepository = authenticationRepository;
        this.tasksRepository = tasksRepository;
    }

    private TaskCategoryRepository getTaskCategoryRepository() {
        if (taskCategoryRepository == null) {
            Repositories repositories = Repositories.getInstance();

            //Get the TaskCategoryRepository
            taskCategoryRepository = repositories.getTaskCategoryRepository();
        }
        return taskCategoryRepository;
    }

    private AuthenticationRepository getAuthenticationRepository() {
        if (authenticationRepository == null) {
            Repositories repositories = Repositories.getInstance();

            //Get the AuthenticationRepository
            authenticationRepository = repositories.getAuthenticationRepository();
        }
        return authenticationRepository;
    }

    private TasksRepository getTaskRepository() {
        if (tasksRepository == null) {
            Repositories repositories = Repositories.getInstance();

            tasksRepository = repositories.getTaskRepository();
        }

        return tasksRepository;
    }

    public Optional<Task> createTask(String reference, String description, String informalDescription,
                                     String technicalDescription, int duration, double cost,
                                     String taskCategoryDescription) {

        TaskCategory taskCategory = getTaskCategoryByDescription(taskCategoryDescription);

        Collaborator collaborator = getCollaboratorFromSession();

        Optional<Task> newTask = Optional.empty();

        newTask = getTaskRepository().add(new Task(
                reference, description, informalDescription,
                technicalDescription, duration, cost,
                taskCategory, collaborator
        ));

        return newTask;
    }

    private Collaborator getCollaboratorFromSession() {
        Email email = getAuthenticationRepository().getCurrentUserSession().getUserId();
        return new Collaborator(email.getEmail());
    }


    private TaskCategory getTaskCategoryByDescription(String taskCategoryDescription) {
        TaskCategoryRepository taskCategoryRepository = getTaskCategoryRepository();

        //Get the TaskCategory by its description
        TaskCategory taskCategoryByDescription =
                getTaskCategoryRepository().getTaskCategoryByDescription(taskCategoryDescription);
        return taskCategoryByDescription;

    }

    //return the list of task categories
    public List<TaskCategory> getTaskCategories() {
        TaskCategoryRepository taskCategoryRepository = getTaskCategoryRepository();
        return taskCategoryRepository.getTaskCategories();
    }
}