package de.starvalcity.base.background;

import de.starvalcity.base.background.def.Permanent;
import de.starvalcity.base.background.def.Task;

public class ConsoleTask extends Task implements Permanent {

    private String taskName;
    private int taskId;

    @Override
    public void execute() {

    }

    @Override
    public void terminate() {

    }

    @Override
    public void reIdentify(int id) {
        this.taskId = id;
    }

    @Override
    public void rename(String name) {
        this.taskName = name;
    }
}
