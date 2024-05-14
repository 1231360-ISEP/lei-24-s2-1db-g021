package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Job;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.JobsRepository;

import java.util.List;
import java.util.Optional;

public class RegisterJobController {

    private JobsRepository jobsRepository;

    /**
     * Constructs a new RegisterJobController object.
     */
    public RegisterJobController() {
        getJobsRepository();
    }

    /**
     * Constructs a new RegisterJobController object with a specified JobsRepository.
     *
     * @param jobsRepository The JobsRepository to be used by the controller.
     */
    public RegisterJobController(JobsRepository jobsRepository) {
        this.jobsRepository = jobsRepository;
    }

    private JobsRepository getJobsRepository() {
        if (jobsRepository == null) {
            Repositories repositories = Repositories.getInstance();
            jobsRepository = repositories.getJobsRepository();
        }
        return jobsRepository;
    }

    /**
     * Creates a new Job with the given name.
     *
     * @param name The name of the job to be created.
     * @return An Optional containing the newly created Job, or empty if the operation fails.
     */
    public Optional<Job> createJob(String name) {
        Optional<Job> newJob;
        try {
            newJob = jobsRepository.add(new Job(name));
        } catch (IllegalArgumentException e) {
            return Optional.empty();
        }
        return newJob;
    }

    /**
     * Retrieves the list of all jobs.
     *
     * @return The list of all jobs.
     */
    public List<Job> getJobsList() {
        return jobsRepository.getJobsList();
    }
}