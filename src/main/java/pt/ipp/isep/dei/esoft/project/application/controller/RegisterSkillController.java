package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Collaborator;
import pt.ipp.isep.dei.esoft.project.domain.Skill;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.SkillsRepository;
import pt.isep.lei.esoft.auth.domain.model.Email;

import java.util.List;
import java.util.Optional;

public class RegisterSkillController {

    private SkillsRepository skillsRepository;

    public RegisterSkillController() {
        getSkillsRepository();
    }

    public RegisterSkillController(SkillsRepository skillsRepository) {
        this.skillsRepository = skillsRepository;
    }

    private SkillsRepository getSkillsRepository() {
        if (skillsRepository == null) {
            Repositories repositories = Repositories.getInstance();

            skillsRepository = repositories.getSkillsRepository();
        }
        return skillsRepository;
    }

    /**
     * @param name is the name of the skill that will be created
     *             if the skill was a valid name,
     * @return the new skill
     *             if not, it throws a IllegalArgumentException
     */
    public Optional<Skill> createSkill(String name) {
        Optional<Skill> newSkill;
        try {
            newSkill = skillsRepository.add(new Skill(name));
        } catch (IllegalArgumentException e) {
            return Optional.empty();
        }
        return  newSkill;
    }

    public List<Skill> getSkillsList() {
        return skillsRepository.getSkillsList();
    }
}