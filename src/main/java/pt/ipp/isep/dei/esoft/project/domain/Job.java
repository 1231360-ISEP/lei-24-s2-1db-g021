package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Objects;

import static java.lang.Character.isLetter;
import static java.lang.Character.isWhitespace;

public class Job {
    private String name;

    /**
     * Creates a new instance of Job Class.
     * @param name
     */
    public Job(String name) {
        this.setName(name);
    }

    /**
     * Returns the value of the attribute name.
     * @return the name value.
     */
    public String getName() {
        return name;
    }

    /**
     * @param name it's the name of the job that a Collaborator can have,
     *             if the name is valid, set the name,
     *             if it's null or empty, it throws a IllegalArgumentException,
     *             if name contain special characters or digits, it throws a IllegalArgumentException.
     */
    public void setName(String name) {
        if (name == null || name.isEmpty()){
            throw new IllegalArgumentException("Job name can't be empty. Please, try again.");
        }

        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (!isLetter(c) && !isWhitespace(c)) {
                throw new IllegalArgumentException("Invalid job name. A job name can’t have special characters or digits. Please, try again.");
            }
        }
        this.name = name;
    }

    /**
     * Returns a String representation of the Job object.
     * This representation includes relevant information about the Job object.
     * @return String representation of the Job object.
     */
    @Override
    public String toString() {
        return "Job{" +
                "name='" + name + '\'' +
                '}';
    }

    /**
     * Compare this Job object with another for equality.
     * @param o The object to be compared.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return Objects.equals(name, job.name);
    }

    /**
     * Returns a hash code for the Job object.
     * This method is supported to facilitate the use of objects in hash-based data structures such as HashMap.
     * @return A hash code for the object.
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    /**
     * Creates and returns a copy of this Job object.
     * @return A copy of this object.
     */
    public Job clone() {
        return new Job(this.name);
    }
}