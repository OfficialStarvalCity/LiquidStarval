package de.starvalcity.base;

import de.starvalcity.base.api.handling.DatabaseManager;
import de.starvalcity.base.api.handling.SQLManager;
import de.starvalcity.base.api.handling.StorageManager;
import de.starvalcity.base.background.FileTask;
import de.starvalcity.base.background.MainTask;
import de.starvalcity.base.background.TaskHandler;
import de.starvalcity.base.background.log.LogHandler;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.SQLException;

public class Pluginbase {

    /*------------------------------------------------------------------------------------------------------------*/
    // Deklarierte Variablen
    /*------------------------------------------------------------------------------------------------------------*/
    // Managers
    private DatabaseManager dbManager;
    private SQLManager sqlManager;
    private StorageManager storageManager;

    public static final PluginManager pluginManager = Bukkit.getPluginManager();

    /*------------------------------------------------------------------------------------------------------------*/
    // Initialisierte Variablen
    /*------------------------------------------------------------------------------------------------------------*/
    // Handlers
    private final LogHandler logHandler = new LogHandler();
    private final TaskHandler taskHandler = new TaskHandler();

    // Tasks
    private final MainTask mainTask = new MainTask("MainTask", 1, 100L);
    private final FileTask fileTask = new FileTask("FileTask", 2, 200L);

    /**
     * Startup Logik
     * Server-Start Funktion
     */
    public void onStartup() {
        this.dbManager = new DatabaseManager();
        connectDatabase();
        taskHandler.executeTask(mainTask);
        taskHandler.executeTask(fileTask);
        pluginManager.enablePlugin(JavaPlugin.getPlugin(Core.class));
    }

    /**
     * Shutdown Logik
     * Server-Stop Funktion
     */
    public void onShutdown() {
        dbManager.disconnect();
        taskHandler.terminateTask(mainTask);
        taskHandler.terminateTask(fileTask);
        pluginManager.disablePlugin(JavaPlugin.getPlugin(Core.class));
    }

    /**
     * Datenbank Verbindung
     * Verbindet die MySQL Datenbank mit dem Plugin
     */
    public void connectDatabase() {
        try {
            dbManager.connect();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("[Database] Database is not connected!");
        }
        if (dbManager.isConnected()) {
            System.out.println("[Database] Database is connected!");
        }
    }

    /*------------------------------------------------------------------------------------------------------------*/
    // Getters
    /*------------------------------------------------------------------------------------------------------------*/
    // Managers
    public DatabaseManager getDbManager() {
        return dbManager;
    }

    public SQLManager getSqlManager() {
        return sqlManager;
    }

    public StorageManager getStorageManager() {
        return storageManager;
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

    public MainTask getMainTask() {
        return mainTask;
    }
}
