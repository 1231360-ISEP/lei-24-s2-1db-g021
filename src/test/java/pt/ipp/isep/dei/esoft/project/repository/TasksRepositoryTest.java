package pt.ipp.isep.dei.esoft.project.repository;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.Collaborator;
import pt.ipp.isep.dei.esoft.project.domain.Task;
import pt.ipp.isep.dei.esoft.project.domain.TaskCategory;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class TasksRepositoryTest {

    @Test
    void ensureAddition() {
        TasksRepository tasksRepository = new TasksRepository();
        TaskCategory taskCategory = new TaskCategory("category");
        Collaborator collaborator = new Collaborator("a@a.a");
        Task task1 = new Task(
                "task1",
                "Description",
                "Informal description",
                "Technical description",
                10,
                10,
                taskCategory,
                collaborator
        );

        Optional<Task> result1 = tasksRepository.add(task1);

        assertTrue(result1.isPresent());
    }

    @Test
    void ensureDuplicatedAdditionFails() {
        TasksRepository tasksRepository = new TasksRepository();
        TaskCategory taskCategory = new TaskCategory("category");
        Collaborator collaborator = new Collaborator("a@a.a");
        Task task = new Task(
                "task1",
                "Description",
                "Informal description",
                "Technical description",
                10,
                10,
                taskCategory,
                collaborator
        );

        Optional<Task> result1 = tasksRepository.add(task);
        Optional<Task> result2 = tasksRepository.add(task);

        assertTrue(result1.isPresent());
        assertTrue(result2.isEmpty());
    }

    @Test
    void ensureMultipleAddition() {
        TasksRepository tasksRepository = new TasksRepository();
        TaskCategory taskCategory = new TaskCategory("category");
        Collaborator collaborator = new Collaborator("a@a.a");
        Task task1 = new Task(
                "task1",
                "Description",
                "Informal description",
                "Technical description",
                10,
                10,
                taskCategory,
                collaborator
        );
        Task task2 = new Task(
                "task2",
                "Description",
                "Informal description",
                "Technical description",
                10,
                10,
                taskCategory,
                collaborator
        );

        Optional<Task> result1 = tasksRepository.add(task1);
        Optional<Task> result2 = tasksRepository.add(task2);

        assertTrue(result1.isPresent());
        assertTrue(result2.isPresent());
    }

    @Test
    void ensureGetTasksReturnsAnImmutableList() {
        TasksRepository tasksRepository = new TasksRepository();
        TaskCategory taskCategory = new TaskCategory("category");
        Collaborator collaborator = new Collaborator("a@a.a");
        Task task = new Task(
                "task1",
                "Description",
                "Informal description",
                "Technical description",
                10,
                10,
                taskCategory,
                collaborator
        );

        assertThrows(UnsupportedOperationException.class, () -> {
            tasksRepository.getTaskList().add(task);
        });
    }

    @Test
    void ensureRemoval() {
        TasksRepository tasksRepository = new TasksRepository();
        TaskCategory taskCategory = new TaskCategory("category");
        Collaborator collaborator = new Collaborator("a@a.a");
        Task task = new Task(
                "task1",
                "Description",
                "Informal description",
                "Technical description",
                10,
                10,
                taskCategory,
                collaborator
        );

        Optional<Task> result1 = tasksRepository.add(task);
        boolean result2 = tasksRepository.remove(task);

        assertTrue(result1.isPresent());
        assertTrue(result2);
    }

}
