package de.starvalcity.base;

import de.starvalcity.base.background.FileTask;
import de.starvalcity.base.background.TaskHandler;
import de.starvalcity.base.background.def.Startup;

public class Pluginbase {

    private final TaskHandler taskHandler = new TaskHandler();
    private final FileTask fileTask = new FileTask();

    @Startup
    public void onStartup() {
        taskHandler.setActiveTask(2, fileTask);
    }


}
