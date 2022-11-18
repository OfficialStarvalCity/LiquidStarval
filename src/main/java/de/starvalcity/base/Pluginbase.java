package de.starvalcity.base;

import de.starvalcity.base.api.def.database.MySQLAPI;
import de.starvalcity.base.api.handling.*;
import de.starvalcity.base.api.handling.object.ObjectSQLManager;
import de.starvalcity.base.api.handling.player.PlayerManager;
import de.starvalcity.base.api.handling.player.PlayerSQLManager;
import de.starvalcity.base.background.FileTask;
import de.starvalcity.base.background.TaskHandler;
import de.starvalcity.base.background.log.LogHandler;
import de.starvalcity.base.command.AttachCommand;
import de.starvalcity.base.utilities.DataStructurizer;
import de.starvalcity.base.utilities.DateConverter;
import de.starvalcity.base.utilities.Formatter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

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
    private final JavaPlugin plugin = JavaPlugin.getPlugin(Core.class);

    // APIs
    private MySQLAPI mySQLAPI = new MySQLAPI();

    // Handlers

    // Managers
    private MessageManager msgManager = new MessageManager();

    private ObjectSQLManager objectSQLManager = new ObjectSQLManager();
    private PlayerManager playerManager = new PlayerManager();
    private PlayerSQLManager playerSQLManager = new PlayerSQLManager();
    private SQLManager sqlManager = new SQLManager();

    public static final PluginManager pluginManager = Bukkit.getPluginManager();

    // SQL

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
    private final FileTask fileTask = new FileTask("FileTask", 2, 200L);

    /*------------------------------------------------------------------------------------------------------------*/
    // Logiken
    /*------------------------------------------------------------------------------------------------------------*/

    /**
     * Startup Logik
     * Server-Start Funktion
     */
    public void onStartup() {
        taskHandler.executeTask(fileTask);
        initialize();
        pluginManager.enablePlugin(JavaPlugin.getPlugin(Core.class));
    }

    /**
     * Shutdown Logik
     * Server-Stop Funktion
     */
    public void onShutdown() {
        MySQLAPI.disconnect();
        plugin.saveConfig();
        taskHandler.terminateTask(fileTask);
        pluginManager.disablePlugin(JavaPlugin.getPlugin(Core.class));
    }

    /**
     * Initialisierung
     * Aufruf aller Hintergrundmethoden
     */
    public void initialize() {
        loadEvents();
        loadCommands();
        loadConfig();
        connectDatabase();
        loadDependencies();
    }

    /*------------------------------------------------------------------------------------------------------------*/
    // Getters
    /*------------------------------------------------------------------------------------------------------------*/
    // Plugin

    public JavaPlugin getPlugin() {
        return plugin;
    }

    // APIs
    public MySQLAPI getMySQLAPI() {
        return mySQLAPI;
    }

    // Handlers

    // Managers

    public MessageManager getMsgManager() {
        return msgManager;
    }

    public ObjectSQLManager getObjectSQLManager() {
        return objectSQLManager;
    }

    public PlayerManager getPlayerManager() {
        return playerManager;
    }

    public PlayerSQLManager getPlayerSQLManager() {
        return playerSQLManager;
    }

    public SQLManager getSqlManager() {
        return sqlManager;
    }

    // SQL

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
    public FileTask getFileTask() {
        return fileTask;
    }

    // Miscellaneous
    public File getDataFolder() {
        return plugin.getDataFolder();
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
        MySQLAPI.connect();
        SQLManager.setupObjectsTable();
        SQLManager.setupPlayersTable();
    }

    /**
     * Laden der Events
     * Lädt alle Events und Listener
     */
    public void loadEvents() {

    }

    /**
     * Laden der Befehle
     * Lädt alle Befehle
     */
    public void loadCommands() {
        AttachCommand attachCommand = new AttachCommand(JavaPlugin.getPlugin(Core.class));
        JavaPlugin.getPlugin(Core.class).getCommand("attach").setExecutor(attachCommand);
    }

    /**
     * Laden aller APIs
     * Lädt alle APIs
     */
    public void loadDependencies() {

    }

}
