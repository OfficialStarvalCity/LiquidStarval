package de.starvalcity.base.command;

import de.starvalcity.base.Core;
import de.starvalcity.base.Pluginbase;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class EconomyCommand implements CommandExecutor {

    private static Core plugin;
    private static Pluginbase pluginbase = new Pluginbase();

    public EconomyCommand(Core plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        return true;
    }
}
