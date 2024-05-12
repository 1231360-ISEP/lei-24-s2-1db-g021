package pt.ipp.isep.dei.esoft.project.repository;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.Address;
import pt.ipp.isep.dei.esoft.project.domain.Collaborator;
import pt.ipp.isep.dei.esoft.project.domain.Skill;
import pt.ipp.isep.dei.esoft.project.domain.ZipCode;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CollaboratorsRepositoryTest {

    @Test
    void ensureNewCollaboratorSuccessfullyAdded() {
        // Arrange
        CollaboratorsRepository collaboratorsRepository = new CollaboratorsRepository();
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