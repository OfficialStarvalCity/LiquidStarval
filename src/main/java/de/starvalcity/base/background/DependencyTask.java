package de.starvalcity.base.background;

import de.starvalcity.base.core.Core;
import de.starvalcity.base.def.Task;

public class DependencyTask implements Task {

    Core plugin;
    String name = "DependencyTask";
    int timer = 5;

    public DependencyTask(Core plugin) {
        this.plugin = plugin;
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void setTimer(int timer) {
        this.timer = timer;
    }
}
