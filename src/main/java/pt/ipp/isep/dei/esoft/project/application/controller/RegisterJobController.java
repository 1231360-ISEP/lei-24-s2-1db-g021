package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Collaborator;
import pt.ipp.isep.dei.esoft.project.domain.Job;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.JobsRepository;
import pt.isep.lei.esoft.auth.domain.model.Email;

import java.util.List;
import java.util.Optional;

public class RegisterJobController {

    private JobsRepository jobsRepository;

    public RegisterJobController() {
        getJobsRepository();
    }

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
     * @param name is the name of the job that it's going to be created
     *             if the job name is valid,
     * @return the new job name
     *             if not it throws a IllegalArgumentException
     */
    public Optional<Job> createJob(String name) {
        Optional<Job> newJob;
        try {
            newJob = jobsRepository.add(new Job(name));
        } catch (IllegalArgumentException e) {
            return Optional.empty();
        }
        return  newJob;
    }

    public List<Job> getJobsList() {
        return jobsRepository.getJobsList();
    }
}
