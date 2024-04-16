package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class OrganizationTest {

    @Test
    void testEqualsSameObject() {
        Organization organization = new Organization("123456789");
        assertEquals(organization, organization);
    }

    @Test
    void testEqualsDifferentClass() {
        Organization organization = new Organization("123456789");
        assertNotEquals("", organization);
    }

    @Test
    void testEqualsNull() {
        Organization organization = new Organization("123456789");
        assertNotEquals(null, organization);
    }

    @Test
    void testEqualsDifferentObject() {
        Organization organization = new Organization("123456789");
        Organization organization1 = new Organization("123456789");
        assertEquals(organization, organization1);
    }

    @Test
    void testHashCodeSameObject() {
        Organization organization = new Organization("123456789");
        assertEquals(organization.hashCode(), organization.hashCode());
    }

    @Test
    void testHashCodeDifferentObject() {
        Organization organization = new Organization("123456789");
        Organization organization1 = new Organization("123456789");
        assertEquals(organization.hashCode(), organization1.hashCode());
    }

    @Test
        //same hashcode
    void testHashCodeSameObjectSameVATNumber() {
        Organization organization = new Organization("123456789");
        Organization organization1 = new Organization("123456789");
        assertEquals(organization.hashCode(), organization1.hashCode());
    }

    @Test
    void ensureHashCodeFailsForDifferentVatNumbers() {
        Organization organization = new Organization("123456789");
        Organization organization1 = new Organization("123456788");
        assertNotEquals(organization.hashCode(), organization1.hashCode());
    }

    @Test
    void ensureEqualsFailsForDifferentObjectType() {
        Organization organization = new Organization("123456789");
        Organization organization1 = new Organization("123456788");
        assertNotEquals(organization, organization1);
    }

    @Test
    void ensureEqualsFailsWhenComparingNull() {
        Organization organization = new Organization("123456789");
        assertNotEquals(organization, null);
    }

    @Test
    void ensureEqualsSuccessWhenComparingSameObject() {
        Organization organization = new Organization("123456789");
        assertEquals(organization, organization);
    }

    @Test
    void testThatCreateTaskWorks() {
        Organization organization = new Organization("123456789");

        Collaborator collaborator = new Collaborator("collaborator",1,1,"lamas", 987654321,"collaborator@this.app", 987654321, 987654321);
        TaskCategory taskCategory = new TaskCategory("Task Category Description");

        Task expected = new Task("Task Description", "Task Category Description", "informal description",
                "technical description", 1, 1d, taskCategory, collaborator);

        Optional<Task> task =
                organization.createTask("Task Description", "Task Category Description", "informal description",
                        "technical description", 1, 1d, taskCategory, collaborator);

        assertNotNull(task);
        assertTrue(task.isPresent());
        assertEquals(expected, task.get());
    }

    @Test
    void ensureAddingDuplicateTaskFails() {
        //Arrange
        Organization organization = new Organization("123456789");
        Collaborator collaborator = new Collaborator("collaborator",1,1,"lamas", 987654321,"collaborator@this.app", 987654321, 987654321);
        TaskCategory taskCategory = new TaskCategory("Task Category Description");
        //Add the first task
        Optional<Task> originalTask =
                organization.createTask("Task Description", "Task Category Description", "informal description",
                        "technical description", 1, 1d, taskCategory, collaborator);

        //Act
        Optional<Task> duplicateTask =
                organization.createTask("Task Description", "Task Category Description", "informal description",
                        "technical description", 1, 1d, taskCategory, collaborator);

        //Assert
        assertTrue(duplicateTask.isEmpty());
    }


    @Test
    void ensureEmploysFails() {
        Organization organization = new Organization("123456789");
        Collaborator collaborator = new Collaborator("collaborator",1,1,"lamas", 987654321,"collaborator@this.app", 987654321, 987654321);

        assertFalse(organization.employs(collaborator));

    }

    @Test
    void ensureEmploysSuccess() {
        Organization organization = new Organization("123456789");
        Collaborator collaborator = new Collaborator("collaborator",1,1,"lamas", 987654321,"collaborator@this.app", 987654321, 987654321);
        organization.addCollaborator(collaborator);
        assertTrue(organization.employs(collaborator));
    }

    @Test
    void ensureAnyCollaboratorHasEmailFails() {
        Organization organization = new Organization("123456789");
        Collaborator collaborator = new Collaborator("collaborator",1,1,"lamas", 987654321,"collaborator@this.app", 987654321, 987654321);
        organization.addCollaborator(collaborator);
        assertFalse(organization.anyCollaboratorHasEmail("jane.doe@this.company.com"));
    }

    @Test
    void ensureAnyCollaboratorHasEmailWorks() {
        Organization organization = new Organization("123456789");
        Collaborator collaborator = new Collaborator("collaborator",1,1,"lamas", 987654321,"collaborator@this.app", 987654321, 987654321);
        organization.addCollaborator(collaborator);
        assertTrue(organization.anyCollaboratorHasEmail("john.doe@this.company.com"));
    }

    @Test
    void ensureAddDuplicateCollaboratorFails() {
        Organization organization = new Organization("123456789");
        Collaborator collaborator = new Collaborator("collaborator",1,1,"lamas", 987654321,"collaborator@this.app", 987654321, 987654321);
        assertTrue(organization.addCollaborator(collaborator));
        assertFalse(organization.addCollaborator(collaborator));
    }

    @Test
    void ensureAddEmployeeWorks() {
        Organization organization = new Organization("123456789");
        Collaborator collaborator = new Collaborator("collaborator",1,1,"lamas", 987654321,"collaborator@this.app", 987654321, 987654321);
        assertTrue(organization.addCollaborator(collaborator));
    }

    @Test
    void ensureCloneWorks() {
        Organization organization = new Organization("123456789");
        Collaborator collaborator = new Collaborator("collaborator",1,1,"lamas", 987654321,"collaborator@this.app", 987654321, 987654321);
        organization.addCollaborator(collaborator);
        organization.createTask("Task Description", "Task Category Description", "informal description",
                "technical description", 1, 1d, new TaskCategory("Task Category Description"), collaborator);

        Organization clone = organization.clone();
        assertEquals(organization, clone);
    }
}