package de.starvalcity.base.background;

import de.starvalcity.base.background.def.Task;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO:
 * - Possibility to change schedule delay of a specific task individually
 * - Graphical interface to visualize all tasks
 */
public class TaskHandler {

    private Map<Task, Boolean> taskStates = new HashMap<>();
    private Map<Integer, Task> tasks = new HashMap<>();

    private final EventTask eventTask = new EventTask("EventTask", 4);
    private final FileTask fileTask = new FileTask("FileTask", 2, 100L);

    public TaskHandler() {
        tasks.put(2, fileTask);
        tasks.put(4, eventTask);
    }

    public void executeTask(@NotNull Task task) {
        this.setRunning(task);
        taskStates.put(task, true);
    }

    public void terminateTask(@NotNull Task task) {
        this.setSleeping(task);
        taskStates.put(task, false);
    }

    private void setRunning(@NotNull Task task) {
        task.setTaskStatus(true);
    }

    private void setSleeping(@NotNull Task task) {
        task.setTaskStatus(false);
    }
}
