package de.starvalcity.base.background;

import de.starvalcity.base.background.def.Task;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class TaskHandler {

    private static Map<Integer, Task> tasks = new HashMap<>();
    private static Map<Integer, Task> activeTasks = new HashMap<>();

    private final FileTask fileTask = new FileTask();

    public static Map<Integer, Task> getTasks() {
        return tasks;
    }

    public void setup() {
        tasks.put(2, fileTask);
    }

    public static Map<Integer, Task> getActiveTasks() {
        return activeTasks;
    }

    public void setActiveTask(int id, @NotNull Task task) {
        if (task.isRunning) {
            return;
        } else {
            activeTasks.put(id, task);
            task.setRunning();
        }
    }

    public int getTaskId(@NotNull Task task) {
        return task.getTaskId();
    }

    public String getTaskName(@NotNull Task task) {
        return task.getTaskName();
    }

    public void setInactiveTask(Integer id, Task task) {
        activeTasks.remove(id, task);
        task.setSleeping();
    }
}
