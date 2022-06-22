package de.starvalcity.base;

import de.starvalcity.base.api.handling.DatabaseManager;
import de.starvalcity.base.api.handling.SQLManager;
import de.starvalcity.base.background.EventTask;
import de.starvalcity.base.background.FileTask;
import de.starvalcity.base.background.TaskHandler;
import de.starvalcity.base.background.log.LogHandler;
import de.starvalcity.base.utilities.DataStructurizer;
import de.starvalcity.base.utilities.DateConverter;
import de.starvalcity.base.utilities.Formatter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Die {@link Pluginbase} stellt eine benutzerdefinierte Implementation von den Klassen {@link JavaPlugin},
 * {@link org.bukkit.plugin.PluginBase} und {@link org.bukkit.plugin.Plugin} dar. Sie stellt das zentrale Fundament
 * des Plugins dar mit allen Getter- und Setter-Funktionen.
 */
public class Pluginbase {

    /*------------------------------------------------------------------------------------------------------------*/
    // Deklarierte Variablen
    /*------------------------------------------------------------------------------------------------------------*/
    // Plugin
    private JavaPlugin plugin = JavaPlugin.getPlugin(Core.class);
    // Managers
    private DatabaseManager dbManager = new DatabaseManager();
    private SQLManager sqlManager = new SQLManager();

    public static final PluginManager pluginManager = Bukkit.getPluginManager();

    // Utilities
    private DataStructurizer dataStructurizer = new DataStructurizer();
    private DateConverter dateConverter;
    private Formatter formatter = new Formatter();
    /*------------------------------------------------------------------------------------------------------------*/
    // Initialisierte Variablen
    /*------------------------------------------------------------------------------------------------------------*/
    // Handlers
    private final LogHandler logHandler = new LogHandler();
    private TaskHandler taskHandler = new TaskHandler();

    // Tasks
    private final EventTask eventTask = new EventTask("EventTask", 4);
    private final FileTask fileTask = new FileTask("FileTask", 2, 200L);

    /*------------------------------------------------------------------------------------------------------------*/
    // Logiken
    /*------------------------------------------------------------------------------------------------------------*/

    /**
     * Startup Logik
     * Server-Start Funktion
     */
    public void onStartup() {
        this.dbManager = new DatabaseManager();
        taskHandler.executeTask(fileTask);
        taskHandler.executeTask(eventTask);
        initialize();
        pluginManager.enablePlugin(JavaPlugin.getPlugin(Core.class));
    }

    /**
     * Shutdown Logik
     * Server-Stop Funktion
     */
    public void onShutdown() {
        plugin.saveConfig();
        taskHandler.terminateTask(fileTask);
        taskHandler.terminateTask(eventTask);
        pluginManager.disablePlugin(JavaPlugin.getPlugin(Core.class));
    }

    /**
     * Initialisierung
     * Aufruf aller Hintergrundmethoden
     */
    public void initialize() {
        loadCommands();
        loadConfig();
        connectDatabase();
    }

    /*------------------------------------------------------------------------------------------------------------*/
    // Getters
    /*------------------------------------------------------------------------------------------------------------*/
    // Plugin

    public JavaPlugin getPlugin() {
        return plugin;
    }

    // Managers
    public DatabaseManager getDbManager() {
        return dbManager;
    }

    public SQLManager getSqlManager() {
        return sqlManager;
    }

    // Utilities
    public DataStructurizer getDataStructurizer() {
        return dataStructurizer;
    }

    public DateConverter getDateConverter() {
        return dateConverter;
    }

    public Formatter getFormatter() {
        return formatter;
    }

    // Handlers
    public LogHandler getLogHandler() {
        return logHandler;
    }

    public TaskHandler getTaskHandler() {
        return taskHandler;
    }

    // Tasks
    public EventTask getEventTask() {
        return eventTask;
    }

    public FileTask getFileTask() {
        return fileTask;
    }

    /*------------------------------------------------------------------------------------------------------------*/
    // Hintergrundmethoden
    /*------------------------------------------------------------------------------------------------------------*/

    /**
     * Laden der Konfiguration
     * Lädt die Konfigurationsdatei
     */
    public void loadConfig() {
        plugin.getConfig().options().copyDefaults(false);
        plugin.saveConfig();
    }

    /**
     * Datenbank Verbindung
     * Verbindet die MySQL Datenbank mit dem Plugin
     */
    public void connectDatabase() {
        dbManager.setupMySQL();
    }

    /**
     * Laden der Befehle
     * Lädt alle Befehle
     */
    public void loadCommands() {

    }

}
