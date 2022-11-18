package de.starvalcity.base;

import org.bukkit.plugin.java.JavaPlugin;

public final class Core extends JavaPlugin {

    private static Core plugin;
    private Pluginbase pluginbase;

    /**
     * Start
     */
    @Override
    public void onEnable() {
        plugin = this;
        setPluginbase(new Pluginbase());
        this.getPluginbase().onStartup();
    }

    /**
     * Stop
     */
    @Override
    public void onDisable() {
        this.getPluginbase().onShutdown();
    }

    /**
     * Instance Getter
     * @return instanz des Plugins
     */
    public static Core getPlugin() {
        return plugin;
    }

    /**
     * Base Getter
     * @return basis des Plugins
     */
    public Pluginbase getPluginbase() {
        return pluginbase;
    }

    /**
     * Base Setter
     * @param pluginbase basis des Plugins
     */
    public void setPluginbase(Pluginbase pluginbase) {
        this.pluginbase = pluginbase;
    }

}
