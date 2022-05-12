package de.starvalcity.base.background;

import de.starvalcity.base.core.Core;
import org.bukkit.plugin.java.JavaPlugin;

public class TaskManager {

    private DependencyTask dependencyTask;

    public void startup() {
        dependencyTask.start();
    }

}
