package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Objects;

public class Skill {
    private String name;

    public Skill(String name) {
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    /**
     * @param name is the name of the skill that will be assigned to a Collaborator,
     *             if the name was a valid name, set the name,
     *             if it was null or empty, it throws a IllegalArgumentException,
     *             if name contain special characters or digits, it throws a IllegalArgumentException.
     */
    public void setName(String name) {
        if (name == null || name.isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        for (char c : name.toCharArray()) {
            if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
                throw new IllegalArgumentException("Name cannot contain special characters or digits.");
            }
        }
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Skill skill = (Skill) o;
        return Objects.equals(name, skill.name);
    }

    @Override
    public String toString() {
        return "Skill{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public Skill clone() {
        return new Skill(this.name);
    }
}