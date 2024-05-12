package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.repository.CollaboratorsRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

public class AssignSkillController {
    public void getCollaborators(){
        Repositories repositories = Repositories.getInstance();
        CollaboratorsRepository collaboratorsRepository = repositories.getCollaboratorsRepository();

    }
}
