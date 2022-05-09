package de.starvalcity.base;

import de.starvalcity.base.core.Core;
import de.starvalcity.handling.listening.FirstJoinListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class StartupManager {

    private final PluginManager pluginManager = Bukkit.getPluginManager();
    private final JavaPlugin plugin = JavaPlugin.getPlugin(Core.class);

    public StartupManager() {

    }

    public void start() {

    }

    private void registerEvents() {
        pluginManager.registerEvents(new FirstJoinListener(), plugin);
    }

}
