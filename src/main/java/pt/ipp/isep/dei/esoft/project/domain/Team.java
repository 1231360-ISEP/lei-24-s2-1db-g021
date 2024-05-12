package pt.ipp.isep.dei.esoft.project.domain;

import java.util.List;
import java.util.Objects;

public class Team {
    private String name;
    private int minSizeTeam;
    private int maxSizeTeam;
    private List<Collaborator> collaboratorsList;
    private List<Skill> skillsSelected;

    public Team(String name, int minSizeTeam, int maxSizeTeam, List<Collaborator> collaboratorsList, List<Skill> skillsSelected) {
        this.setName(name);
        this.setMinSizeTeam(minSizeTeam);
        this.setMaxSizeTeam(maxSizeTeam);
        this.setCollaboratorsList(collaboratorsList);
        this.setSkillsSelected(skillsSelected);
    }
    public String getName() {
        return name;
    }

    /**
     * @param name is the name of the team,
     *             if the name was a valid name, set the name,
     *             if it was null or empty, it throws a IllegalArgumentException,
     */
    public void setName(String name) {
        if (name == null || name.isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    public List<Collaborator> getCollaboratorsList() {
        return collaboratorsList;
    }

    public void setCollaboratorsList(List<Collaborator> collaboratorsList) {
        this.collaboratorsList = collaboratorsList;
    }

    public List<Skill> getSkillsSelected() {
        return skillsSelected;
    }

    public void setSkillsSelected(List<Skill> skillsSelected) {
        this.skillsSelected = skillsSelected;
    }

    public int getMinSizeTeam() {
        return minSizeTeam;
    }

    /**
     * @param minSizeTeam is the Minimum Size of the Team,
     *                    if the Minimum Size was valid, it sets the Minimum Size of the Team,
     *                    if not it throws a IllegalArgumentException.
     */
    public void setMinSizeTeam(int minSizeTeam) {
        if (minSizeTeam < 0) {
            throw new IllegalArgumentException("Minimum team size cannot be negative.");
        }
        this.minSizeTeam = minSizeTeam;
    }

    public int getMaxSizeTeam() {
        return maxSizeTeam;
    }

    /**
     * @param maxSizeTeam is the Maximum Size of the Team,
     *                    if the Maximum Size was valid, it sets the Maximum Size of the Team,
     *                    if not it throws a IllegalArgumentException.
     */
    public void setMaxSizeTeam(int maxSizeTeam) {
        if (maxSizeTeam < 0) {
            throw new IllegalArgumentException("Maximum team size cannot be negative.");
        }
        this.maxSizeTeam = maxSizeTeam;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return minSizeTeam == team.minSizeTeam && maxSizeTeam == team.maxSizeTeam && Objects.equals(name, team.name) && Objects.equals(collaboratorsList, team.collaboratorsList) && Objects.equals(skillsSelected, team.skillsSelected);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, minSizeTeam, maxSizeTeam, collaboratorsList, skillsSelected);
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", minSizeTeam=" + minSizeTeam +
                ", maxSizeTeam=" + maxSizeTeam +
                ", collaboratorsList=" + collaboratorsList +
                ", skillsSelected=" + skillsSelected +
                '}';
    }

    public Team clone() {
        return new Team(this.name, this.minSizeTeam, this.maxSizeTeam, this.collaboratorsList, this.skillsSelected);
    }

    /**
     * getTeamCollaboratorsList is a method that will return the list of Collaborators in Team.
     *
     * @return teamCollaboratorsList
     */
    public List<Collaborator> getTeamCollaboratorsList() {
        List<Collaborator> teamCollaborators = selectedCollaboratorsBySkills();
        return teamCollaboratorsList(teamCollaborators);

    }

    /**
     * selectedCollaboratorsBySkills is a method that returns the Collaborators
     * that were selected by their Skills.
     *
     * @return collaboratorsList
     */
    private List<Collaborator> selectedCollaboratorsBySkills() {
        return collaboratorsList.stream()
                .filter(this::hasSelectedSkills)
                .toList();
    }

    private List<Collaborator> teamCollaboratorsList(List<Collaborator> collaboratorsList) {
        return collaboratorsList;
    }

    /**
     *
     * @param collaborator is the collaborator selected,
     *                     this method will verify if collaborator has the skills neeed,
     *                     if collaborator has the skills needed it
     * @return the collaborator selected
     */
    private boolean hasSelectedSkills(Collaborator collaborator) {
        return collaborator.getSkills().containsAll(skillsSelected);
    }

    /**
     * isTeamSizeWithinBounds is a method that will verify
     * if the Team Size is between the Minimum and Maximum number of team members.
     *
     * @return the interval of Minimum and Maximum Size of the Team
     */
    public boolean isTeamSizeWithinBounds() {
        int teamSize = collaboratorsList.size();
        return teamSize >= minSizeTeam && teamSize <= maxSizeTeam;
    }




}