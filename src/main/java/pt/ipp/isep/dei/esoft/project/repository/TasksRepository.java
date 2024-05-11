package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TasksRepository {

    private final List<Task> taskList;

    public TasksRepository() {
        taskList = new ArrayList<>();
    }

    public Optional<Task> add(Task task) {
        if (!validateTask(task))
            return Optional.empty();

        Optional<Task> newTask = Optional.of(task.clone());

        taskList.add(newTask.get());

        return newTask;
    }

    public boolean remove(Task task) {
        return taskList.remove(task);
    }

    public boolean validateTask(Task task) {
        return !taskList.contains(task);
    }

    public List<Task> getTaskList() {
        return List.copyOf(taskList);
    }

}
