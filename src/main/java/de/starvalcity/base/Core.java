package de.starvalcity.base;

import de.starvalcity.base.background.TaskHandler;
import org.bukkit.plugin.java.JavaPlugin;

public final class Core extends JavaPlugin {

    private static Core plugin;

    private TaskHandler taskHandler;

    @Override
    public void onEnable() {
        plugin = this;
    }

    @Override
    public void onDisable() {

    }

    public static Core getPlugin() {
        return plugin;
    }

    public TaskHandler getTaskHandler() {
        return taskHandler;
    }
}
