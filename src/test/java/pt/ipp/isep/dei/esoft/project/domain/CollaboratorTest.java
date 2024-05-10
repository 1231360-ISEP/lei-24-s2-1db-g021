package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;

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
        String email = "john.doe@this.company.com";
        Collaborator Collaborator = new Collaborator(email);
        Collaborator clone = Collaborator.clone();
        assertEquals(Collaborator, clone);
    }
}