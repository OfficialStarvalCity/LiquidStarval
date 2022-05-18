package de.starvalcity.base.background.def;

public abstract class Task {

    public String taskName;
    public int id;
    public boolean isRunning;

    public abstract void start();

    public abstract void stop();

    public void setRunning() {
        if (!isRunning) {
            isRunning = true;
        }
    }

    public void setSleeping() {
        if (isRunning) {
            isRunning = false;
        }
    }

    public String getTaskName() {
        return this.taskName;
    }

    public int getTaskId() {
        return this.id;
    }

    public boolean isRunning() {
        return this.isRunning;
    }

}
