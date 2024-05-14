package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.PlateCertification;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PlateCertificationsRepository {
    private final List<PlateCertification> plateCertificationsList;

    /**
     * Constructs a new PlateCertificationsRepository object.
     */
    public PlateCertificationsRepository() {
        plateCertificationsList = new ArrayList<>();
    }

    /**
     * Adds a new PlateCertification to the repository.
     *
     * @param plateCertification The PlateCertification object to be added.
     * @return An Optional containing the newly added PlateCertification, or empty if the operation fails.
     */
    public Optional<PlateCertification> add(PlateCertification plateCertification) {

        Optional<PlateCertification> newPlateCertification = Optional.empty();
        boolean operationSuccess = false;

        if (validatePlateCertification(plateCertification)) {
            newPlateCertification = Optional.of(plateCertification.clone());
            operationSuccess = plateCertificationsList.add(newPlateCertification.get());
        }

        if (!operationSuccess) {
            newPlateCertification = Optional.empty();
        }

        return newPlateCertification;
    }

    private boolean validatePlateCertification(PlateCertification plateCertification) {
        return !plateCertificationsList.contains(plateCertification);
    }

    /**
     * Retrieves a defensive (immutable) copy of the list of plate certifications.
     *
     * @return The list of plate certifications.
     */
    public List<PlateCertification> getPlateCertificationsList() {
        // This is a defensive copy, so that the repository cannot be modified from the outside.
        return List.copyOf(plateCertificationsList);
    }

    /**
     * Removes a PlateCertification from the repository.
     *
     * @param plateCertification The PlateCertification object to be removed.
     * @return True if the PlateCertification was successfully removed, false otherwise.
     */
    public boolean remove(PlateCertification plateCertification) {
        return plateCertificationsList.remove(plateCertification);
    }
}