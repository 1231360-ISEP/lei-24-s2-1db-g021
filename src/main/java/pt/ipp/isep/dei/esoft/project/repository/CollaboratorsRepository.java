package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Collaborator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CollaboratorsRepository {

    private final List<Collaborator> collaboratorsList;

    public CollaboratorsRepository() {
        collaboratorsList = new ArrayList<>();
    }

    public Optional<Collaborator> add(Collaborator collaborator) {

        Optional<Collaborator> newCollaborator = Optional.empty();
        boolean operationSuccess = false;

        if (validateCollaborator(collaborator)) {
            newCollaborator = Optional.of(collaborator.clone());
            operationSuccess = collaboratorsList.add(newCollaborator.get());
        }

        if (!operationSuccess) {
            newCollaborator = Optional.empty();
        }

        return newCollaborator;
    }

    private boolean validateCollaborator(Collaborator collaborator) {
        boolean isValid = !collaboratorsList.contains(collaborator);
        return isValid;
    }

    /**
     * This method returns a defensive (immutable) copy of the list of collaborators.
     *
     * @return The list of collaborators.
     */
    public List<Collaborator> getCollaboratorsList() {
        //This is a defensive copy, so that the repository cannot be modified from the outside.
        return List.copyOf(collaboratorsList);
    }


}