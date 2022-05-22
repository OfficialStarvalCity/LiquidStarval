package de.starvalcity.base;

import org.bukkit.plugin.java.JavaPlugin;

public final class Core extends JavaPlugin {

    private static Core plugin;

    private Pluginbase pluginbase;

    @Override
    public void onEnable() {
        plugin = this;
        setPluginbase(new Pluginbase());
        this.getPluginbase().onStartup();
    }

    @Override
    public void onDisable() {
        this.getPluginbase().onShutdown();
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

}
