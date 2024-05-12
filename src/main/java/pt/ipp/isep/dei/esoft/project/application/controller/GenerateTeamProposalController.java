package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Collaborator;
import pt.ipp.isep.dei.esoft.project.domain.Skill;
import pt.ipp.isep.dei.esoft.project.repository.CollaboratorsRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.SkillsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GenerateTeamProposalController {

    private CollaboratorsRepository collaboratorsRepository;
    private SkillsRepository skillsRepository;

    public GenerateTeamProposalController() {
        getCollaboratorsRepository();
        getSkillsRepository();
    }

    public GenerateTeamProposalController(
            CollaboratorsRepository collaboratorsRepository,
            SkillsRepository skillsRepository
    ) {
        this.collaboratorsRepository = collaboratorsRepository;
        this.skillsRepository = skillsRepository;
    }

    private CollaboratorsRepository getCollaboratorsRepository() {
        if (collaboratorsRepository == null) {
            Repositories repositories = Repositories.getInstance();

            collaboratorsRepository = repositories.getCollaboratorsRepository();
        }

        return collaboratorsRepository;
    }

    private SkillsRepository getSkillsRepository() {
        if (skillsRepository == null) {
            Repositories repositories = Repositories.getInstance();

            skillsRepository = repositories.getSkillsRepository();
        }

        return skillsRepository;
    }

    /**
     *
     * @return If successful it returns a list of collaborator as a representation
     * of the proposed team.
     * If the minTeamSize is not reached it returns an empty Optional.
     * If the maxTeamSize is reached the addition of new collaborators to the team is stopped.
     *
     * @param maxTeamSize Maximum team size
     * @param minTeamSize Minimum team size
     * @param skillRequirements Skills required to make the team
     */
    public Optional<List<Collaborator>> generateTeamProposal(int maxTeamSize, int minTeamSize, List<Skill> skillRequirements) {
        List<Collaborator> listCollaborators = collaboratorsRepository.getCollaboratorsList();
        List<Skill> remainingSkills = new ArrayList<>(skillRequirements);
        List<Collaborator> team = new ArrayList<>();

        for (int i = 0; i < listCollaborators.size() && team.size() < maxTeamSize; i++) {
            if(listCollaborators.get(i).getSkills() != null)
                for (Skill collaboratorSkill : listCollaborators.get(i).getSkills()) {
                    if (remainingSkills.contains(collaboratorSkill)) {
                        team.add(listCollaborators.get(i));
                        remainingSkills.remove(collaboratorSkill);
                    }
                }
        }

        if (team.size() < minTeamSize)
            return Optional.empty();

        return Optional.of(team);
    }

}
