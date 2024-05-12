package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Collaborator;
import pt.ipp.isep.dei.esoft.project.domain.Skill;
import pt.ipp.isep.dei.esoft.project.repository.CollaboratorsRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.SkillsRepository;

import java.util.ArrayList;
import java.util.List;

public class AssignSkillController {
    private Collaborator collaboratorSelected;
    private List<Skill> skillsToAssign;
    private final Repositories repositories = Repositories.getInstance();
    public List<Collaborator> getCollaborators(){
        CollaboratorsRepository collaboratorsRepository = repositories.getCollaboratorsRepository();
        List<Collaborator> collaboratorsList = collaboratorsRepository.getCollaboratorsList();
        return collaboratorsList;
    }
    public void setCollaboratorSelected(Collaborator collaborator){
        this.collaboratorSelected = collaborator;
    }
    public List<Skill> getSkills(){
        SkillsRepository skillsRepository = repositories.getSkillsRepository();
        return skillsRepository.getSkillsList();
    }
    public void storeSkills(List<Skill> skillsToAssign){
        this.skillsToAssign = skillsToAssign;
    }
    public void addSkills(){
        for (Skill skill:
             skillsToAssign) {
            collaboratorSelected.addSkill(skill);
        }
    }
}
