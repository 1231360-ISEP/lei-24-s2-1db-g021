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

    /**
     * This constructor instantiates with the default Collaborators and Skills Repositories
     */
    public AssignSkillController() {
        getSkillsRepository();
        getCollaboratorsRepository();
    }

    /**
     * This constructor instantiates with custom Collaborators and Skills Repositories
     * @param collaboratorsRepository the Collaborators Repository
     * @param skillsRepository the Skills Repository
     */
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
            skillsRepository = repositories.getSkillsRepository();
        }
        return skillsRepository;
    }

    /**
     * This method gets the collaborators added on the repository
     * @return the all collaborators list
     */
    public List<Collaborator> getCollaborators(){
        List<Collaborator> collaboratorsList = collaboratorsRepository.getCollaboratorsList();
        return collaboratorsList;
    }

    /**
     * This method sets the collaborator to, in the future, assign the skills
     * @param collaborator the collaborator to assign skills to
     */
    public void setCollaboratorSelected(Collaborator collaborator){
        this.collaboratorSelected = collaborator;
    }

    /**
     * This method returns the list of skills.
     * @return The list of all skills
     */
    public List<Skill> getSkills(){
        return skillsRepository.getSkillsList();
    }

    /**
     * This method store the skills to assign to the collaborator previously selected
     * @param skillsToAssign a list containing the skills to assign
     */
    public void storeSkills(List<Skill> skillsToAssign){
        this.skillsToAssign = skillsToAssign;
    }

    /**
     * This method add the skills previously stored on storeSkills()
     */
    public void addSkills(){
        for (Skill skill:
             skillsToAssign) {
            if(!collaboratorSelected.isSkillAssigned(skill)){
                collaboratorSelected.addSkill(skill);
            }
        }
    }
}
