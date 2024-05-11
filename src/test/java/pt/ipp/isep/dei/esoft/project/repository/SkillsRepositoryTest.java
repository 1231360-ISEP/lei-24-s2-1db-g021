package pt.ipp.isep.dei.esoft.project.repository;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.Skill;
import pt.ipp.isep.dei.esoft.project.domain.TaskCategory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class SkillsRepositoryTest {

    @Test
    void ensureNewSkillSuccessfullyAdded() {
        // Arrange
        SkillsRepository skillsRepository = new SkillsRepository();
        Skill skill = new Skill("Tree Pruner");

        // Act
        Optional<Skill> addedSkill = skillsRepository.add(skill);

        // Assert
        assertTrue(addedSkill.isPresent());
        assertEquals(skill, addedSkill.get());
    }

    @Test
    void ensureAddingDuplicateSkillFails() {
        // Arrange
        SkillsRepository skillsRepository = new SkillsRepository();
        Skill skill = new Skill("Tree Pruner");

        // Act
        Optional<Skill> addedFirstSkill = skillsRepository.add(skill);
        Optional<Skill> addedSecondSkill = skillsRepository.add(skill);

        // Assert
        assertTrue(addedFirstSkill.isPresent());
        assertTrue(addedSecondSkill.isEmpty());
    }

    @Test
    void ensureSkillsListIsNotNull() {
        // Arrange
        SkillsRepository skillsRepository = new SkillsRepository();

        // Act
        List<Skill> skillsList = skillsRepository.getSkillsList();

        // Assert
        assertTrue(skillsList.isEmpty());

    }

/*    @Test
    void ensureRemovingSkillFromListWorks() {
        // Arrange
        SkillsRepository skillsRepository = new SkillsRepository();
        Skill skill1 = new Skill("Tree Pruner");

        // Act
        skillsRepository.add(skill1);
        boolean removed = skillsRepository.remove(skill1);

        // Assert
        assertTrue(removed);
        assertFalse(skillsRepository.getSkillsList().contains(skill1));
    }
*/
}