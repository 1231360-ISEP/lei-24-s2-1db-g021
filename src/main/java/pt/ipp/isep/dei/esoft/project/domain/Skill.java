package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Objects;

public class Skill {
    private final String reference;
    private String name;
    private TaskCategory taskCategory;
    private Collaborator collaborator;

    public Skill(String reference, String name, TaskCategory taskCategory, Collaborator collaborator) {

        validateReference(reference);
        this.reference = reference;
        this.name = name;
        this.taskCategory = taskCategory;
        this.collaborator = collaborator;
    }

    private void validateReference(String reference) {
        //TODO: missing from the diagrams
        if (reference == null || reference.isEmpty()) {
            throw new IllegalArgumentException("Reference cannot be null or empty.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Skill)) {
            return false;
        }
        Skill skill = (Skill) o;
        return reference.equals(skill.reference) && collaborator.equals(skill.collaborator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reference, collaborator);
    }

    public Skill clone() {
        return new Skill(this.reference, this.name, this.taskCategory, this.collaborator);
    }
}