package de.starvalcity.base.background;

import de.starvalcity.base.background.def.Task;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

/**
 * TODO:
 * - Possibility to change schedule delay of a specific task individually
 * - Graphical interface to visualize all tasks
 */
public class TaskHandler {

    private static Map<Task, Boolean> taskStates;
    private static Map<Integer, Task> tasks;

    private final MainTask mainTask = new MainTask("MainTask", 1, 200L);
    private final FileTask fileTask = new FileTask("FileTask", 2, 100L);

    public static void setTaskStates(Map<Task, Boolean> taskStates) {
        TaskHandler.taskStates = taskStates;
    }

    public static void setTasks(Map<Integer, Task> tasks) {
        TaskHandler.tasks = tasks;
    }

    public void setTaskStatus(@NotNull Task task, boolean isRunning) {
        task.setTaskStatus(isRunning);
        taskStates.put(task, isRunning);
    }

    public void executeTask(@NotNull Task task) {
        task.execute();
        setTaskStatus(task, true);
    }

    public void terminateTask(@NotNull Task task) {
        task.terminate();
        setTaskStatus(task, false);
    }

    public static Task getTask(int id) {
        return tasks.get(id);
    }

    public FileTask getFileTask() {
        return fileTask;
    }
}
