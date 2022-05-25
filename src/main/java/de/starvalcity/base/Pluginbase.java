package de.starvalcity.base;

import de.starvalcity.base.background.FileTask;
import de.starvalcity.base.background.MainTask;
import de.starvalcity.base.background.TaskHandler;
import de.starvalcity.base.background.log.LogHandler;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Pluginbase {

    private final LogHandler logHandler = new LogHandler();
    private final TaskHandler taskHandler = new TaskHandler();
    private final MainTask mainTask = new MainTask("MainTask", 1, 100L);
    private final FileTask fileTask = new FileTask("FileTask", 2, 200L);

    public static final PluginManager pluginManager = Bukkit.getPluginManager();

    public void onStartup() {
        taskHandler.executeTask(mainTask);
        taskHandler.executeTask(fileTask);
        pluginManager.enablePlugin(JavaPlugin.getPlugin(Core.class));
    }

    public void onShutdown() {
        taskHandler.terminateTask(mainTask);
        taskHandler.terminateTask(fileTask);
        pluginManager.disablePlugin(JavaPlugin.getPlugin(Core.class));
    }

    public LogHandler getLogHandler() {
        return logHandler;
    }

    public TaskHandler getTaskHandler() {
        return taskHandler;
    }
}
