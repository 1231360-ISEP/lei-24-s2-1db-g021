package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Objects;

public class Job {
    private String name;

    public Job(String name) {
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()){
            throw new IllegalArgumentException("Job name can't be empty. Please, try again.");
        }
        this.name = name;
    }

    @Override
    public String toString() {
        return "Job{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return Objects.equals(name, job.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    public Job clone() {
        return new Job(this.name);
    }
}
