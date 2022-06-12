package de.starvalcity.base.background.log;

import de.starvalcity.base.Core;
import de.starvalcity.base.background.def.Response;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.logging.Level;

/**
 * Der LogHandler sorgt für das allgemeine Logging und ist dem {@link java.util.logging.Logger} ähnlich.
 */
public class LogHandler {

    private final JavaPlugin plugin = JavaPlugin.getPlugin(Core.class);

    /**
     * Constructor
     */
    public LogHandler() {}

    /**
     * Standard Log
     * (interne Funktion)
     * @param log nachricht
     */
    public void log(String log) {
        System.out.println(log);
    }

    /**
     * SQL Log
     * Logt einen SQL Befehl mit Exception
     * @param query befehl
     * @param exception exception
     */
    public void sqlLog(String query, Exception exception) {
        System.out.println("SQL Log > Exception: " + exception);
        System.out.println("SQL Log > Query: " + query);
    }

    public void sqlInfo(String message) {
        System.out.println("SQL Info > " + message);
    }

    /**
     * Command Log
     * Logt einen Befehl
     * @param commandSender sender
     * @param command befehl
     * @param response antwort
     */
    public void logCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull Response response) {
        System.out.println("CMD Log > Ausgeführter Befehl: " + command.getUsage());
        System.out.println("CMD Log > Sender: " + commandSender.getName());
        System.out.println("CMD Log > Antwort: " + response.toString());
    }

    /**
     * Log With Level
     * Logt mit einem Level
     * @param log log
     * @param level level
     */
    public void logWithLevel(String log, Level level) {
        plugin.getLogger().log(level, log);
    }
}
