package de.starvalcity.base.command;

import de.starvalcity.base.Core;
import de.starvalcity.base.Pluginbase;
import de.starvalcity.base.api.def.economy.EconomyObjectType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.logging.Level;

public class EconomyCommand implements CommandExecutor {

    private static Core plugin;

    private static Pluginbase pluginbase = new Pluginbase();

    public EconomyCommand(Core plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 0) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
            }
        }
        if (label.equalsIgnoreCase("bank")) {
            if (args.length == 2) {
                if (args[0].equalsIgnoreCase("create")) {
                    String name = args[1];

                    if (name.length() <= 15) {
                        pluginbase.getEconomySQLManager().addToTable(EconomyObjectType.BANK);
                    } else {
                        pluginbase.getLogHandler().logWithLevel("Bank Creation Error > Name is too long!", Level.SEVERE);
                    }
                } else if (args[0].equalsIgnoreCase("remove")) {
                    if (args[1].equalsIgnoreCase())
                }
            }
        }
        return false;
    }
}
