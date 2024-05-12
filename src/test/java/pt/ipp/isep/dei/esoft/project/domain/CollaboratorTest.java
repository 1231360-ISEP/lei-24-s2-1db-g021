package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CollaboratorTest {

    @Test
    void ensureTwoCollaboratorsWithSameEmailEquals() {
        Collaborator Collaborator1 = new Collaborator("john.doe@this.company.com");
        Collaborator Collaborator2 = new Collaborator("john.doe@this.company.com");
        assertEquals(Collaborator1, Collaborator2);
    }

    @Test
    void ensureCollaboratorWithDifferentEmailNotEquals() {
        Collaborator Collaborator1 = new Collaborator("john.doe@this.company.com");
        Collaborator Collaborator2 = new Collaborator("jane.doe@this.company.com");
        assertNotEquals(Collaborator1, Collaborator2);
    }

    @Test
    void ensureCollaboratorDoesNotEqualNull() {
        Collaborator Collaborator1 = new Collaborator("john.doe@this.company.com");
        assertNotEquals(Collaborator1, null);
    }

    @Test
    void ensureCollaboratorDoesNotEqualOtherObject() {
        Collaborator Collaborator1 = new Collaborator("john.doe@this.company.com");
        assertNotEquals(Collaborator1, new Object());
    }

    @Test
    void ensureTheSameObjectIsEqual() {
        Collaborator Collaborator1 = new Collaborator("john.doe@this.company.com");
        assertEquals(Collaborator1, Collaborator1);
    }

    @Test
    void ensureHashCodeIsEqualForEqualObjects() {
        String email = "john.doe@this.company.com";
        Collaborator Collaborator1 = new Collaborator(email);
        Collaborator Collaborator2 = new Collaborator(email);
        assertEquals(Collaborator1.hashCode(), Collaborator2.hashCode());
    }

    @Test
    void ensureHashCodeIsNotEqualForDifferentObjects() {
        Collaborator Collaborator1 = new Collaborator("john.doe@this.company.com");
        Collaborator Collaborator2 = new Collaborator("jane.doe@this.company.com");
        assertNotEquals(Collaborator1.hashCode(), Collaborator2.hashCode());
    }

    @Test
    void ensureHasEmailWorksForTheSameEmail() {
        String email = "john.doe@this.compay.org";
        Collaborator Collaborator = new Collaborator(email);
        assertTrue(Collaborator.hasEmail(email));

    }

    @Test
    void ensureHasEmailFailsForDifferentEmails() {
        String email = "john.doe@this.company.com";
        Collaborator Collaborator = new Collaborator(email);
        assertFalse(Collaborator.hasEmail("jane.doe@this.company.com"));

    }

    @Test
    void ensureCloneWorks() {
        // Arrange
        Skill skill1 = new Skill("Tree Pruner");
        Skill skill2 = new Skill("Light Vehicle Driving Licence");
        Skill skill3 = new Skill("Heavy Vehicle Driving Licence");

        Collaborator collaborator = new Collaborator("John Doe",
                new Date(2000, Calendar.JUNE, 1),
                new Date(2020, Calendar.FEBRUARY, 1),
                new Address(1, new ZipCode(1234,1)),
                123456789,
                "john.doe@example.com",
                123456,
                1,
                List.of(skill1, skill2, skill3));

        // Act
        Collaborator clone = collaborator.clone();

        // Assert
        assertEquals(collaborator, clone);
    }

    @Test
    void ensureRemoveSkillRemovesSkillFromCollaborator() {
        // Arrange
        Skill skill1 = new Skill("Tree Pruner");
        Skill skill2 = new Skill("Light Vehicle Driving Licence");
        Skill skill3 = new Skill("Heavy Vehicle Driving Licence");

        Collaborator collaborator = new Collaborator("John Doe",
                new Date(2000, Calendar.JUNE, 1),
                new Date(2020, Calendar.FEBRUARY, 1),
                new Address(1, new ZipCode(1234,1)),
                123456789,
                "john.doe@example.com",
                123456,
                1,
                List.of(skill1, skill2, skill3));

        // Act
        collaborator.removeSkill(skill2);

        // Assert
        List<Skill> skills = collaborator.getSkills();
        assertEquals(2, skills.size());
        assertTrue(skills.contains(skill1));
        assertTrue(skills.contains(skill3));
    }

}