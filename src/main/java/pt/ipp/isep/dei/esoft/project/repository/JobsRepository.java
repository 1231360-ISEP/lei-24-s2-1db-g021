package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Job;
import pt.ipp.isep.dei.esoft.project.domain.Skill;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JobsRepository {
    private final List<Job> jobsList;

    public JobsRepository() {
        jobsList = new ArrayList<>();
    }

    public Optional<Job> add(Job job) {

        Optional<Job> newJob = Optional.empty();
        boolean operationSuccess = false;

        if (validateJob(job)) {
            newJob = Optional.of(job.clone());
            operationSuccess = jobsList.add(newJob.get());
        }

        if (!operationSuccess) {
            newJob = Optional.empty();
        }

        return newJob;
    }

    private boolean validateJob(Job job) {
        return !jobsList.contains(job);
    }

    /**
     * This method returns a defensive (immutable) copy of the list of jobs.
     *
     * @return The list of jobs.
     */
    public List<Job> getJobsList() {
        //This is a defensive copy, so that the repository cannot be modified from the outside.
        return List.copyOf(jobsList);
    }

    public boolean remove(Job job) {
        return jobsList.remove(job);
    }
}