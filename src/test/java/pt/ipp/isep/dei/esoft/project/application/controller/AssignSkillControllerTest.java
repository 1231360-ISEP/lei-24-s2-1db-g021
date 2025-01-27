package pt.ipp.isep.dei.esoft.project.application.controller;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.Collaborator;
import pt.ipp.isep.dei.esoft.project.domain.Skill;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AssignSkillControllerTest {
    @Test
    void assignSkillsToCollaborator(){
        Collaborator c1 = new Collaborator("tomaspintomoreira28@gmail.com");
        Collaborator c2 = new Collaborator("1231087@isep.ipp.pt.com");

        Repositories.getInstance().getCollaboratorsRepository().add(c1);
        Repositories.getInstance().getCollaboratorsRepository().add(c2);

        Skill s1 = new Skill("Dedicação");
        Skill s2 = new Skill("Carta Barco");

        Repositories.getInstance().getSkillsRepository().add(s1);
        Repositories.getInstance().getSkillsRepository().add(s2);

        List<Skill> skillList = new ArrayList<>();
        skillList.add(s1);
        skillList.add(s2);

        AssignSkillController assignSkillController = new AssignSkillController();
        assignSkillController.storeSkills(skillList);
        assignSkillController.setCollaboratorSelected(c1);
        assignSkillController.addSkills();
    }
    @Test
    void assignTheSameSkillToCollaborator(){
        Collaborator c1 = new Collaborator("tomaspintomoreira28@gmail.com");
        Collaborator c2 = new Collaborator("1231087@isep.ipp.pt.com");

        Repositories.getInstance().getCollaboratorsRepository().add(c1);
        Repositories.getInstance().getCollaboratorsRepository().add(c2);

        Skill s1 = new Skill("Dedicação");
        Skill s2 = new Skill("Carta Barco");

        Repositories.getInstance().getSkillsRepository().add(s1);
        Repositories.getInstance().getSkillsRepository().add(s2);

        c1.addSkill(s1);

        List<Skill> skillList = new ArrayList<>();
        skillList.add(s1);

        AssignSkillController assignSkillController = new AssignSkillController();
        assignSkillController.storeSkills(skillList);
        assignSkillController.setCollaboratorSelected(c1);
        assignSkillController.addSkills();

        List<Skill> expected = new ArrayList<Skill>();
        expected.add(s1);

        assertEquals(expected, c1.getSkills());
    }
    @Test
    void noAssignSkillsSelected(){
        Collaborator c1 = new Collaborator("tomaspintomoreira28@gmail.com");

        Repositories.getInstance().getCollaboratorsRepository().add(c1);

        List<Skill> skillList = new ArrayList<>();

        AssignSkillController assignSkillController = new AssignSkillController();
        assignSkillController.storeSkills(skillList);
        assignSkillController.setCollaboratorSelected(c1);
        assignSkillController.addSkills();

        List<Skill> expected = null;
        assertEquals(expected, c1.getSkills());
    }
}