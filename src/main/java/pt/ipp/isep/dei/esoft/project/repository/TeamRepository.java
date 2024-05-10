package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TeamRepository {

    private final List<Team> teamsList;

    public TeamRepository() {
        teamsList = new ArrayList<>();
    }

    public Optional<Team> add(Team team) {

        Optional<Team> newTeam = Optional.empty();
        boolean operationSuccess = false;

        if (validateTeam(team)) {
            newTeam = Optional.of(team.clone());
            operationSuccess = teamsList.add(newTeam.get());
        }

        if (!operationSuccess) {
            newTeam = Optional.empty();
        }

        return newTeam;
    }

    private boolean validateTeam(Team team) {
        boolean isValid = !teamsList.contains(team);
        return isValid;
    }

    /**
     * This method returns a defensive (immutable) copy of the list of teams.
     *
     * @return The list of teams.
     */
    public List<Team> getTeam() {
        //This is a defensive copy, so that the repository cannot be modified from the outside.
        return List.copyOf(teamsList);
    }

}