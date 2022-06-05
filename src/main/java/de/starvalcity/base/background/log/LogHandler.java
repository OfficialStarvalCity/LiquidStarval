package de.starvalcity.base.background.log;

import de.starvalcity.base.Core;
import de.starvalcity.base.background.def.Response;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class LogHandler {

    private final JavaPlugin plugin = JavaPlugin.getPlugin(Core.class);

    public LogHandler() {

    }

    public void log(String log) {
        System.out.println(log);
    }

    public void log(String log, Response response) {
        System.out.println(log + ". Response: " + response);
    }

    public void factionLog(String message, Response response) {
        System.out.println("FactionLog > " + message + ". Response: " + response);
    }

    public void logCommand(CommandSender commandSender, Command command, Response response) {
        System.out.println("Log > " + commandSender + " executed " + command + ". Response: " + response);
    }
}
