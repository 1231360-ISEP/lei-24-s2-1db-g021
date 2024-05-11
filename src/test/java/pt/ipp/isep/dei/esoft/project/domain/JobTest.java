package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JobTest {
    @Test
    void testEqualsSameObject() {
        // Arrange
        Job job = new Job("Budget Manager");

        // Act
        boolean result = job.equals(job);

        // Assert
        assertTrue(result, "Job should be equal to itself.");
    }

    @Test
    void testEqualsDifferentClass() {
        // Arrange
        Job job = new Job("Budget Manager");

        // Act
        boolean result = job.equals("");

        // Assert
        assertFalse(result, "Job should not be equal to an object of a different class.");

    }

    @Test
    void testEqualsNull() {
        // Arrange
        Job job1 = new Job("Budget Manager");

        // Act
        boolean result = job1.equals(null);

        // Assert
        assertFalse(result, "Job should not be equal to null.");
    }
    @Test
    void testEqualsDifferentObject() {
        // Arrange
        Job job1 = new Job("Budget Manager");
        Job job2 = new Job("Electrician");

        // Act and Assert
        assertNotEquals(job1, job2);
    }
    @Test
    void testEqualsSameObjectDifferentName() {
        // Arrange
        Job job1 = new Job("Budget Manager");
        Job job2 = new Job("Electrician");

        // Act
        boolean result = job1.equals(job2);

        // Assert
        assertFalse(result, "Jobs with different names should not be equal.");
    }

    @Test
    void testEqualsDifferentObjectsSameName() {
        // Arrange
        Job job1 = new Job("Budget Manager");
        Job job2 = new Job("Budget Manager");

        // Act
        boolean result = job1.equals(job2);

        // Assert
        assertTrue(result, "Jobs with same names should be equal.");
    }
    @Test
    void testHashCodeSameObject() {
        // Arrange
        Job job = new Job("Budget Manager");

        // Act and Assert
        assertEquals(job.hashCode(), job.hashCode());
    }

    @Test
    void testHashCodeDifferentObject() {
        // Arrange
        Job job1 = new Job("Budget Manager");
        Job job2 = new Job("Electrician");

        // Act and Assert
        assertNotEquals(job1.hashCode(), job2.hashCode());
    }

    @Test
    void testHashCodeSameObjectDifferentName() {
        // Arrange
        Job job1 = new Job("Budget Manager");
        Job job2 = new Job("Electrician");

        // Act and Assert
        assertNotEquals(job1.hashCode(), job2.hashCode());
    }

    @Test
    void testHashCodeSameObjectSameName() {
        // Arrange
        Job job1 = new Job("Budget Manager");
        Job job2 = new Job("Budget Manager");

        // Act and Assert
        assertEquals(job1.hashCode(), job2.hashCode());
    }

    @Test
    void ensureCloneWorks() {
        // Arrange
        Job job = new Job("Budget Manager");
        Job clone = job.clone();

        // Act and Assert
        assertEquals(job, clone);
    }
}