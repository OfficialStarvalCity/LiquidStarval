package de.starvalcity.base;

import de.starvalcity.base.background.TaskHandler;
import org.bukkit.plugin.java.JavaPlugin;

public final class Core extends JavaPlugin {

    private static Core plugin;

    private Pluginbase pluginbase;
    private  TaskHandler taskHandler;

    @Override
    public void onEnable() {
        plugin = this;
        setPluginbase(new Pluginbase());
        setTaskHandler(new TaskHandler());
        this.getPluginbase().onStartup();
    }

    @Override
    public void onDisable() {

    }

    public static Core getPlugin() {
        return plugin;
    }

    public Pluginbase getPluginbase() {
        return pluginbase;
    }

    public void setPluginbase(Pluginbase pluginbase) {
        this.pluginbase = pluginbase;
    }

    public TaskHandler getTaskHandler() {
        return taskHandler;
    }

    public void setTaskHandler(TaskHandler taskHandler) {
        this.taskHandler = taskHandler;
    }
}
