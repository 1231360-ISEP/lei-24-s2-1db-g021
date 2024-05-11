package pt.ipp.isep.dei.esoft.project.repository;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.Collaborator;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CollaboratorsRepositoryTest {

    @Test
    void ensureNewCollaboratorSuccessfullyAdded() {
        // Arrange
        CollaboratorsRepository collaboratorsRepository = new CollaboratorsRepository();
        Collaborator collaborator = new Collaborator("John Doe");

        // Act
        Optional<Collaborator> addedCollaborator = collaboratorsRepository.add(collaborator);

        // Assert
        assertTrue(addedCollaborator.isPresent());
        assertEquals(collaborator, addedCollaborator.get());
        assertEquals(1, collaboratorsRepository.getCollaboratorsList().size());
    }

    @Test
    void ensureAddDuplicateCollaboratorFails() {
        // Arrange
        CollaboratorsRepository collaboratorsRepository = new CollaboratorsRepository();
        Collaborator collaborator = new Collaborator("John Doe");

        // Act
        collaboratorsRepository.add(collaborator);
        Optional<Collaborator> addedCollaborator = collaboratorsRepository.add(collaborator);

        // Assert
        assertFalse(addedCollaborator.isPresent());
        assertEquals(1, collaboratorsRepository.getCollaboratorsList().size());
    }

    @Test
    void ensureCollaboratorsListIsNotNull() {
        // Arrange
        CollaboratorsRepository collaboratorsRepository = new CollaboratorsRepository();

        // Act
        List<Collaborator> collaboratorsList = collaboratorsRepository.getCollaboratorsList();

        // Assert
        assertTrue(collaboratorsList.isEmpty());

    }

}