package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SkillTest {


    @Test
    void testEqualsSameObject() {
        // Arrange
        Skill skill = new Skill("Tree Pruner");

        // Act
        boolean result = skill.equals(skill);

        // Assert
        assertTrue(result, "Skill should be equal to itself.");
    }

    @Test
    void testEqualsDifferentClass() {
        // Arrange
        Skill skill = new Skill("Tree Pruner");

        // Act
        boolean result = skill.equals("");

        // Assert
        assertFalse(result, "Skill should not be equal to an object of a different class.");

    }

    @Test
    void testEqualsNull() {
        // Arrange
        Skill skill1 = new Skill("Tree Pruner");

        // Act
        boolean result = skill1.equals(null);

        // Assert
        assertFalse(result, "Skill should not be equal to null.");
    }
    @Test
    void testEqualsDifferentObject() {
        // Arrange
        Skill skill1 = new Skill("Tree Pruner");
        Skill skill2 = new Skill("Light Vehicle Driving Licence");

        // Act and Assert
        assertNotEquals(skill1, skill2);
    }
    @Test
    void testEqualsSameObjectDifferentName() {
        // Arrange
        Skill skill1 = new Skill("Tree Pruner");
        Skill skill2 = new Skill("Light Vehicle Driving Licence");

        // Act
        boolean result = skill1.equals(skill2);

        // Assert
        assertFalse(result, "Skills with different names should not be equal.");
    }

    @Test
    void testEqualsDifferentObjectsSameName() {
        // Arrange
        Skill skill1 = new Skill("Tree Pruner");
        Skill skill2 = new Skill("Tree Pruner");

        // Act
        boolean result = skill1.equals(skill2);

        // Assert
        assertTrue(result, "Skills with same names should be equal.");
    }

    @Test
    void ensureSkillNameCannotContainSpecialCharactersOrDigits() {
        // Arrange
        String invalidSkill1 = "Tree%Pruner";
        String invalidSkill2 = "Tree1Pruner";

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> new Skill(invalidSkill1));
        assertThrows(IllegalArgumentException.class, () -> new Skill(invalidSkill2));
    }

    @Test
    void testHashCodeSameObject() {
        // Arrange
        Skill skill = new Skill("Tree Pruner");

        // Act and Assert
        assertEquals(skill.hashCode(), skill.hashCode());
    }

    @Test
    void testHashCodeDifferentObject() {
        // Arrange
        Skill skill1 = new Skill("Tree Pruner");
        Skill skill2 = new Skill("Light Vehicle Driving Licence");

        // Act and Assert
        assertNotEquals(skill1.hashCode(), skill2.hashCode());
    }

    @Test
    void testHashCodeSameObjectDifferentName() {
        // Arrange
        Skill skill1 = new Skill("Tree Pruner");
        Skill skill2 = new Skill("Light Vehicle Driving Licence");

        // Act and Assert
        assertNotEquals(skill1.hashCode(), skill2.hashCode());
    }

    @Test
    void testHashCodeSameObjectSameName() {
        // Arrange
        Skill skill1 = new Skill("Tree Pruner");
        Skill skill2 = new Skill("Tree Pruner");

        // Act and Assert
        assertEquals(skill1.hashCode(), skill2.hashCode());
    }

    @Test
    void ensureCloneWorks() {
        // Arrange
        Skill skill = new Skill("Tree Pruner");
        Skill clone = skill.clone();

        // Act and Assert
        assertEquals(skill, clone);
    }
}