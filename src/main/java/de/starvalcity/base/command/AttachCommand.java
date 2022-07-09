package de.starvalcity.base.command;

import de.starvalcity.base.Core;
import de.starvalcity.base.Pluginbase;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.sql.SQLException;

public class AttachCommand implements CommandExecutor {

    private static Pluginbase pluginbase = new Pluginbase();

    private static Core plugin;

    public AttachCommand(Core plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof ConsoleCommandSender) {
            if (args.length == 0) {
                sender.sendMessage("Console cannot be attached or unattached.");
            }
        }
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0) {
                    pluginbase.getPlayerManager().attachPlayer(player);
                player.sendMessage("Attached.");
            }
        }
        return true;
    }
}
