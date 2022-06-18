package de.starvalcity.base.background.def;

public abstract class Task {

    public String taskName;
    public int taskId;
    public boolean isRunning;

    public abstract void execute();

    public abstract void terminate();

    public void setTaskStatus(boolean status) {
        this.isRunning = status;
    }

    public void setRunning() {
        this.isRunning = true;
    }

    public void setSleeping() {
        this.isRunning = false;
    }

    public boolean isRunning() {
        return isRunning;
    }
}
