package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.Collaborator;
import pt.ipp.isep.dei.esoft.project.domain.Skill;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TeamTest {

    @Test
    void ensureTeamNameCannotBeEmpty() {
        // Arrange
        List<Collaborator> collaborators = new ArrayList<>();
        List<Skill> skills = new ArrayList<>();

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> new Team("",1,4, collaborators, skills));
    }

    @Test
    void ensureGetTeamReturnsSelectedCollaboratorsBySkills() {
        // Arrange
        Collaborator collaborator1 = new Collaborator("John Doe");
        collaborator1.addSkill(new Skill("Tree Pruner"));
        Collaborator collaborator2 = new Collaborator("Jane Doe");
        collaborator2.addSkill(new Skill("Light Vehicle Driving Licence"));
        Collaborator collaborator3 = new Collaborator("Ken Doe");
        collaborator3.addSkill(new Skill("Tree Pruner"));
        List<Collaborator> collaborators = List.of(collaborator1, collaborator2, collaborator3);

        List<Skill> skillsSelected = List.of(new Skill("Tree Pruner"));

        Team team = new Team("Team A", 1,4, collaborators, skillsSelected);

        // Act
        List<Collaborator> teamMembers = team.getTeam();

        // Assert
        assertEquals(2, teamMembers.size());
    }

    @Test
    void ensureTeamHasValidMinAndMaxNumberOfCollaborators() {
        // Arrange
        List<Collaborator> collaborators = new ArrayList<>();
        collaborators.add(new Collaborator("John Doe"));
        List<Skill> skills = new ArrayList<>();
        skills.add(new Skill("Tree Pruner"));

        // Act
        Team team = new Team("Team A",1, 5, collaborators, skills);

        // Assert
        assertTrue(team.isTeamSizeWithinBounds());
    }
    @Test
    void ensureTeamHasInvalidMinAndMaxNumberOfCollaborators() {
        // Arrange
        List<Collaborator> collaborators = new ArrayList<>();
        collaborators.add(new Collaborator("John Doe"));
        collaborators.add(new Collaborator("Jane Smith"));
        collaborators.add(new Collaborator("Ken Doe "));
        collaborators.add(new Collaborator("Chin Doe"));
        collaborators.add(new Collaborator("Jony Doe"));
        collaborators.add(new Collaborator("Leo Doe"));
        List<Skill> skills = new ArrayList<>();
        skills.add(new Skill("Tree Pruner"));

        // Act
        Team team = new Team("Team A",1, 5, collaborators, skills);

        // Assert
        assertFalse(team.isTeamSizeWithinBounds());
    }



}