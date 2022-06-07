package de.starvalcity.base.background.log;

import de.starvalcity.base.Core;
import de.starvalcity.base.background.def.Response;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class LogHandler {

    private final JavaPlugin plugin = JavaPlugin.getPlugin(Core.class);

    public LogHandler() {
    }

    /**
     * Default Log
     * (used internally)
     * @param log message
     */
    public void log(String log) {
        System.out.println(log);
    }

    /**
     * SQL Log
     * Logs a sql response
     * @param query query
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
     * Logs a command response
     * @param commandSender executor
     * @param command command
     * @param response response type
     */
    public void logCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull Response response) {
        System.out.println("CMD Log > Executed Command: " + command.getName());
        System.out.println("CMD Log > Executor: " + commandSender.getName());
        System.out.println("CMD Log > Response: " + response.toString());
    }
}
