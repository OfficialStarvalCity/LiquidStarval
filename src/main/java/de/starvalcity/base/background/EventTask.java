package de.starvalcity.base.background;

import de.starvalcity.base.background.def.Task;

public class EventTask extends Task {

    private final String taskName;
    private final int taskId;

    public EventTask(String taskName, int taskId) {
        this.taskName = taskName;
        this.taskId = taskId;
    }

    @Override
    public void execute() {
        System.out.println("[EventTask] Executing EventTask ...");
    }

    @Override
    public void terminate() {
        System.out.println("[EventTask] Terminating EventTask ...");
    }

    @Override
    public void setTaskStatus(boolean status) {
        this.isRunning = status;
    }

    public int getTaskId() {
        return this.taskId;
    }

    public String getTaskName() {
        return this.taskName;
    }

}
