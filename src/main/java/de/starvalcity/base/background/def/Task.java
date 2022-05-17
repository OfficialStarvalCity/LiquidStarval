package de.starvalcity.base.background.def;

public abstract class Task {

    public boolean isRunning;

    public abstract void start();

    public abstract void stop();

    public boolean isRunning() {
        return this.isRunning;
    }

}
