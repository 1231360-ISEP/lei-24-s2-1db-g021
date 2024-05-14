package pt.ipp.isep.dei.esoft.project.repository;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.Job;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class JobsRepositoryTest {
    @Test
    void ensureNewJobSuccessfullyAdded() {
        // Arrange
        JobsRepository jobsRepository = new JobsRepository();
        Job job = new Job("Budget Manager");

        // Act
        Optional<Job> addedJob = jobsRepository.add(job);

        // Assert
        assertTrue(addedJob.isPresent());
        assertEquals(job, addedJob.get());
    }

    @Test
    void ensureAddingDuplicateJobFails() {
        // Arrange
        JobsRepository jobsRepository = new JobsRepository();
        Job job = new Job("Budget Manager");

        // Act
        Optional<Job> addedFirstJob = jobsRepository.add(job);
        Optional<Job> addedSecondJob = jobsRepository.add(job);

        // Assert
        assertTrue(addedFirstJob.isPresent());
        assertTrue(addedSecondJob.isEmpty());
    }

    @Test
    void ensureJobsListIsNotNull() {
        // Arrange
        JobsRepository jobsRepository = new JobsRepository();

        // Act
        List<Job> jobsList = jobsRepository.getJobsList();

        // Assert
        assertTrue(jobsList.isEmpty());
    }

    @Test
    void ensureGetJobsReturnsAnImmutableList() {
        // Arrange
        JobsRepository jobsRepository = new JobsRepository();
        Job job = new Job("Gardener");

        // Act
        jobsRepository.add(job);
        List<Job> jobsList = jobsRepository.getJobsList();

        // Assert
        assertThrows(UnsupportedOperationException.class,
                () -> jobsList.add(new Job("Bricklayer")));
    }

    @Test
    void ensureRemovingJobFromListWorks() {
        // Arrange
        JobsRepository jobsRepository = new JobsRepository();
        Job job = new Job("Gardener");

        // Act
        jobsRepository.add(job);
        boolean removed = jobsRepository.remove(job);

        // Assert
        assertTrue(removed);
        assertFalse(jobsRepository.getJobsList().contains(job));
    }
}