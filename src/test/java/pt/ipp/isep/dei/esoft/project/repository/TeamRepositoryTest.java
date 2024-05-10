package pt.ipp.isep.dei.esoft.project.repository;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.Collaborator;
import pt.ipp.isep.dei.esoft.project.domain.Skill;
import pt.ipp.isep.dei.esoft.project.domain.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class TeamRepositoryTest {

    @Test
    void ensureNewTeamSuccessfullyAdded() {
        // Arrange
        TeamRepository teamRepository = new TeamRepository();
        List<Collaborator> collaborators = new ArrayList<>();
        List<Skill> skillsSelected = new ArrayList<>();
        Team team = new Team("Team A", 1, 5, collaborators, skillsSelected);

        // Act
        Optional<Team> addedTeam = teamRepository.add(team);

        // Assert
        assertTrue(addedTeam.isPresent());
        assertEquals(team, addedTeam.get());
        assertEquals(1, teamRepository.getTeam().size());
    }

    @Test
    void ensureAddDuplicateTeamFails() {
        // Arrange
        TeamRepository teamRepository = new TeamRepository();
        List<Collaborator> collaborators = new ArrayList<>();
        List<Skill> skillsSelected = new ArrayList<>();
        Team team = new Team("Team A", 1, 5, collaborators, skillsSelected);

        // Act
        teamRepository.add(team);
        Optional<Team> addedTeam = teamRepository.add(team);

        // Assert
        assertFalse(addedTeam.isPresent());
        assertEquals(1, teamRepository.getTeam().size());
    }

    @Test
    void ensureTeamsListIsNotNull() {
        // Arrange
        TeamRepository teamRepository = new TeamRepository();

        // Act
        List<Team> teamList = teamRepository.getTeam();

        // Assert
        assertTrue(teamList.isEmpty());

    }

}