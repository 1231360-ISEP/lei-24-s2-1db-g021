package pt.ipp.isep.dei.esoft.project.repository;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepositoriesTest {

    @Test
    void testGetInstance() {
        Repositories instance = Repositories.getInstance();
        assertNotNull(instance);
    }

    @Test
    void testSkillsRepository() {
        Repositories instance = Repositories.getInstance();
        assertNotNull(instance.getSkillsRepository());
    }

    @Test
    void testCollaboratorsRepository() {
        Repositories instance = Repositories.getInstance();
        assertNotNull(instance.getCollaboratorsRepository());
    }

    @Test
    void testTeamRepository() {
        Repositories instance = Repositories.getInstance();
        assertNotNull(instance.getTeamRepository());
    }
}