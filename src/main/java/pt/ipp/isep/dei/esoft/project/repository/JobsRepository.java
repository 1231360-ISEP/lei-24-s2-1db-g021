package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Job;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JobsRepository {
    private final List<Job> jobsList;

    /**
     * Constructs a new JobsRepository object.
     */
    public JobsRepository() {
        jobsList = new ArrayList<>();
    }

    /**
     * Adds a new Job to the repository.
     *
     * @param job The Job object to be added.
     * @return An Optional containing the newly added Job, or empty if the operation fails.
     */
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
     * Retrieves a defensive (immutable) copy of the list of jobs.
     *
     * @return The list of jobs.
     */
    public List<Job> getJobsList() {
        // This is a defensive copy, so that the repository cannot be modified from the outside.
        return List.copyOf(jobsList);
    }

    /**
     * Removes a Job from the repository.
     *
     * @param job The Job object to be removed.
     * @return True if the Job was successfully removed, false otherwise.
     */
    public boolean remove(Job job) {
        return jobsList.remove(job);
    }
}