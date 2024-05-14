package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Collaborator;
import pt.ipp.isep.dei.esoft.project.domain.Job;
import pt.ipp.isep.dei.esoft.project.domain.Skill;
import pt.ipp.isep.dei.esoft.project.repository.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RegistCollaboratorController {
    private final Repositories repositories = Repositories.getInstance();

    private CollaboratorsRepository collaboratorsRepository;
    private JobsRepository jobsRepository;
    private Job job;
    private List<Job> jobSelected;
    private List<Skill> skillsToAssign;

    public RegistCollaboratorController() {
        getJobsRepository();
        getCollaboratorsRepository();
    }
    public RegistCollaboratorController(CollaboratorsRepository collaboratorsRepository, JobsRepository jobsRepository) {
        this.collaboratorsRepository = collaboratorsRepository;
        this.jobsRepository = jobsRepository;
    }
    private JobsRepository getJobsRepository() {
        if (jobsRepository == null) {
            Repositories repositories = Repositories.getInstance();

            jobsRepository = repositories.getJobsRepository();
        }
        return jobsRepository;
    }
    private CollaboratorsRepository getCollaboratorsRepository(){
        if (collaboratorsRepository == null) {
            Repositories repositories = Repositories.getInstance();

            //Get the TaskCategoryRepository
            collaboratorsRepository = repositories.getCollaboratorsRepository();
        }
        return collaboratorsRepository;
    }

    public List<Collaborator> getCollaborators(){
        List<Collaborator> collaboratorsList = collaboratorsRepository.getCollaboratorsList();
        return collaboratorsList;
    }
    public void setJobSelected(Job job){
        this.job = job;
    }
    public Optional<Job> createJob(String name) {
        Optional<Job> newJob;
        try {
            newJob = jobsRepository.add(new Job(name));
        } catch (IllegalArgumentException e) {
            return Optional.empty();
        }
        return  newJob;
    }
    public void storeJob(List<Skill> skillsToAssign){
        this.skillsToAssign = skillsToAssign;
    }
    /*
    public void addSkills(){
        for (Skill skill:
                skillsToAssign) {
            collaboratorSelected.addSkill(skill);
        }
    }

     */
}