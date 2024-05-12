package pt.ipp.isep.dei.esoft.project.application.controller;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.Collaborator;
import pt.ipp.isep.dei.esoft.project.domain.Skill;
import pt.ipp.isep.dei.esoft.project.repository.CollaboratorsRepository;
import pt.ipp.isep.dei.esoft.project.repository.SkillsRepository;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class GenerateTeamProposalControllerTest {

    @Test
    void generateTeamProposal() {
        CollaboratorsRepository collaboratorsRepository = new CollaboratorsRepository();
        SkillsRepository skillsRepository = new SkillsRepository();
        GenerateTeamProposalController generateTeamProposalController = new GenerateTeamProposalController(collaboratorsRepository, skillsRepository);
        Collaborator collaborator1 = new Collaborator("collaborator1@a.a");
        Collaborator collaborator2 = new Collaborator("collaborator2@a.a");
        Collaborator collaborator3 = new Collaborator("collaborator3@a.a");
        Collaborator collaborator4 = new Collaborator("collaborator4@a.a");
        Collaborator collaborator5 = new Collaborator("collaborator5@a.a");
        Skill skill1 = new Skill("andar");
        Skill skill2 = new Skill("voar");
        Skill skill3 = new Skill("comer");
        collaborator1.addSkill(skill1);
        collaborator2.addSkill(skill1);
        collaborator3.addSkill(skill1);
        collaborator4.addSkill(skill1);
        collaborator3.addSkill(skill2);
        collaborator5.addSkill(skill3);
        collaboratorsRepository.add(collaborator1);
        collaboratorsRepository.add(collaborator2);
        collaboratorsRepository.add(collaborator3);
        collaboratorsRepository.add(collaborator4);
        collaboratorsRepository.add(collaborator5);
        skillsRepository.add(skill1);
        skillsRepository.add(skill2);
        skillsRepository.add(skill3);
        int maxTeam = 3;
        int minTeam = 2;
        List<Skill> skillRequirements = new ArrayList<>(Arrays.asList(skill1, skill2));

        Optional<List<Collaborator>> result = generateTeamProposalController.generateTeamProposal(maxTeam, minTeam, skillRequirements);

        assertTrue(result.isPresent());
    }

    @Test
    void generateTeamProposalFailsWithouEnoughMembers() {
        CollaboratorsRepository collaboratorsRepository = new CollaboratorsRepository();
        SkillsRepository skillsRepository = new SkillsRepository();
        GenerateTeamProposalController generateTeamProposalController = new GenerateTeamProposalController(collaboratorsRepository, skillsRepository);
        Collaborator collaborator1 = new Collaborator("collaborator1@a.a");
        Collaborator collaborator2 = new Collaborator("collaborator2@a.a");
        Collaborator collaborator3 = new Collaborator("collaborator3@a.a");
        Collaborator collaborator4 = new Collaborator("collaborator4@a.a");
        Collaborator collaborator5 = new Collaborator("collaborator5@a.a");
        Skill skill1 = new Skill("andar");
        Skill skill2 = new Skill("voar");
        Skill skill3 = new Skill("comer");
        collaborator1.addSkill(skill1);
        collaborator5.addSkill(skill3);
        collaboratorsRepository.add(collaborator1);
        collaboratorsRepository.add(collaborator2);
        collaboratorsRepository.add(collaborator3);
        collaboratorsRepository.add(collaborator4);
        collaboratorsRepository.add(collaborator5);
        skillsRepository.add(skill1);
        skillsRepository.add(skill2);
        skillsRepository.add(skill3);
        int maxTeam = 3;
        int minTeam = 2;
        List<Skill> skillRequirements = new ArrayList<>(Arrays.asList(skill1, skill2));

        Optional<List<Collaborator>> result = generateTeamProposalController.generateTeamProposal(maxTeam, minTeam, skillRequirements);

        assertTrue(result.isEmpty());
    }

}
