package pt.ipp.isep.dei.esoft.project.domain;

import java.util.List;
import java.util.Objects;

public class Team {
    private String name;
    private List<Collaborator> collaboratorsList;
    private List<Skill> skillsSelected;

    public Team(String name, List<Collaborator> collaboratorsList, List<Skill> skillsSelected) {
        this.setName(name);
        this.setCollaboratorsList(collaboratorsList);
        this.setSkillsSelected(skillsSelected);
    }

    public String getName() {
        return name;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(name, team.name) && Objects.equals(collaboratorsList, team.collaboratorsList) && Objects.equals(skillsSelected, team.skillsSelected);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, collaboratorsList, skillsSelected);
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", collaboratorsList=" + collaboratorsList +
                ", skillsSelected=" + skillsSelected +
                '}';
    }

    public Team clone() {
        return new Team(this.name, this.collaboratorsList, this.skillsSelected);
    }
}