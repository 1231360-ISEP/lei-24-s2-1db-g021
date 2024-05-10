package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Skill;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SkillsRepository {

    private final List<Skill> skillsList;

    public SkillsRepository() {
        skillsList = new ArrayList<>();
    }

    public Optional<Skill> add(Skill skill) {

        Optional<Skill> newskill = Optional.empty();
        boolean operationSuccess = false;

        if (validateSkill(skill)) {
            newskill = Optional.of(skill.clone());
            operationSuccess = skillsList.add(newskill.get());
        }

        if (!operationSuccess) {
            newskill = Optional.empty();
        }

        return newskill;
    }

    private boolean validateSkill(Skill skill) {
        boolean isValid = !skillsList.contains(skill);
        return isValid;
    }

    /**
     * This method returns a defensive (immutable) copy of the list of skills.
     *
     * @return The list of skills.
     */
    public List<Skill> getSkillsList() {
        //This is a defensive copy, so that the repository cannot be modified from the outside.
        return List.copyOf(skillsList);
    }


}