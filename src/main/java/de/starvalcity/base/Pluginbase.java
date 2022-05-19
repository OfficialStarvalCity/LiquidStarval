package de.starvalcity.base;

import de.starvalcity.base.background.FileTask;
import de.starvalcity.base.background.TaskHandler;

public class Pluginbase {

    private final TaskHandler taskHandler = new TaskHandler();
    private final FileTask fileTask = new FileTask("FileTask", 2, 100L);

    public void onStartup() {
        taskHandler.executeTask(fileTask);
    }

}
