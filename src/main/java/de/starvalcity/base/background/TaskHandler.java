package de.starvalcity.base.background;

import de.starvalcity.base.background.def.Task;

import java.util.HashMap;
import java.util.Map;

public class TaskHandler {

    private static Map<Integer, Task> tasks = new HashMap<>();
    private static Map<Integer, Task> activeTasks = new HashMap<>();

    public static Map<Integer, Task> getTasks() {
        return tasks;
    }

    public static Map<Integer, Task> getActiveTasks() {
        return activeTasks;
    }

    public void setActiveTask(Integer id, Task task) {
        if (task.isRunning) {
            return;
        } else {
            activeTasks.put(id, task);
        }
    }

    public void setInactiveTask(Integer id, Task task) {
        activeTasks.remove(id, task);
    }
}
