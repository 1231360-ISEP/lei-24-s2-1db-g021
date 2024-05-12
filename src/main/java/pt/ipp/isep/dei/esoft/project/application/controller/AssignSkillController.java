package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Collaborator;
import pt.ipp.isep.dei.esoft.project.domain.Skill;
import pt.ipp.isep.dei.esoft.project.repository.*;

import java.util.ArrayList;
import java.util.List;

public class AssignSkillController {
    private CollaboratorsRepository collaboratorsRepository;
    private SkillsRepository skillsRepository;
    private Collaborator collaboratorSelected;
    private List<Skill> skillsToAssign;

    public AssignSkillController() {
        getSkillsRepository();
        getCollaboratorsRepository();
    }
    public AssignSkillController(CollaboratorsRepository collaboratorsRepository, SkillsRepository skillsRepository) {
        this.collaboratorsRepository = collaboratorsRepository;
        this.skillsRepository = skillsRepository;
    }
    private CollaboratorsRepository getCollaboratorsRepository(){
        if (collaboratorsRepository == null) {
            Repositories repositories = Repositories.getInstance();
            collaboratorsRepository = repositories.getCollaboratorsRepository();
        }
        return collaboratorsRepository;
    }
    private SkillsRepository getSkillsRepository(){
        if (skillsRepository == null) {
            Repositories repositories = Repositories.getInstance();

            //Get the TaskCategoryRepository
            skillsRepository = repositories.getSkillsRepository();
        }
        return skillsRepository;
    }

    public List<Collaborator> getCollaborators(){
        List<Collaborator> collaboratorsList = collaboratorsRepository.getCollaboratorsList();
        return collaboratorsList;
    }
    public void setCollaboratorSelected(Collaborator collaborator){
        this.collaboratorSelected = collaborator;
    }
    public List<Skill> getSkills(){
        return skillsRepository.getSkillsList();
    }
    public void storeSkills(List<Skill> skillsToAssign){
        this.skillsToAssign = skillsToAssign;
    }
    public void addSkills(){
        for (Skill skill:
             skillsToAssign) {
            if(!collaboratorSelected.isSkillAssigned(skill)){
                collaboratorSelected.addSkill(skill);
            }
        }
    }
}
