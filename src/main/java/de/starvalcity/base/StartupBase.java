package de.starvalcity.base;

import de.starvalcity.base.background.FileTask;
import de.starvalcity.base.background.TaskHandler;
import de.starvalcity.base.background.def.Startup;

public class StartupBase {

    private final TaskHandler taskHandler = Core.getPlugin().getTaskHandler();
    private final FileTask fileTask = new FileTask();

    @Startup
    public void onStartup() {
        taskHandler.setActiveTask(2, fileTask);
    }


}
