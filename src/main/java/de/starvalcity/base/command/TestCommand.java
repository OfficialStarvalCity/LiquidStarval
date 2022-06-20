package de.starvalcity.base.command;

import de.starvalcity.base.api.handling.PlayerManager;
import de.starvalcity.base.background.def.Response;
import de.starvalcity.base.background.log.LogHandler;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class TestCommand implements CommandExecutor {

    private LogHandler logHandler = new LogHandler();
    private PlayerManager playerManager = new PlayerManager();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof ConsoleCommandSender) {
            ConsoleCommandSender console = (ConsoleCommandSender) sender;
            if (args.length == 0) {
                if (label.equalsIgnoreCase("attachinfo")) {
                    logHandler.logCommand(console, command, Response.GENERAL_FAILURE);
                    logHandler.log("The console cannot be attached.");
                }
            }
            if (args.length == 1) {
                Player target = Bukkit.getPlayer(args[0]);
                if (target != null) {
                    if (playerManager.isAttached(target)) {
                        console.sendMessage("The specified player (" + target.getName() + ") is attached.");
                    } else {
                        console.sendMessage("The specified player (" + target.getName() + ") is not attached.");
                    }
                } else {
                    console.sendMessage("The specified player does not exist.");
                }
            }
        }
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0) {
                if (label.equalsIgnoreCase("attachinfo")) {
                    if (playerManager.isAttached(player)) {
                        player.sendMessage("You are attached.");
                    } else {
                        player.sendMessage("You are not attached.");
                    }
                }
            }
            if (args.length == 1) {
                Player target = Bukkit.getPlayer(args[0]);
                if (target != null) {
                    if (playerManager.isAttached(target)) {
                        player.sendMessage("The specified player (" + target.getName() + ") is attached.");
                    } else {
                        player.sendMessage("The specified player (" + target.getName() + ") is not attached.");
                    }
                } else {
                    player.sendMessage("The specified player does not exist.");
                }
            }
        }
        return false;
    }
}
