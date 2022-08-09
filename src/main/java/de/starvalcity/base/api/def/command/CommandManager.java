package de.starvalcity.base.api.def.command;

import de.starvalcity.base.command.AttachCommand;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

/**
 * {@link CommandManager}
 * <p>The {@link CommandManager} handles registering and executing <b>commands</b>.</p>
 *
 * <p>This class is <b>optional</b> and can be used or cannot be used.</p>
 */
public class CommandManager implements CommandExecutor {

    private ArrayList<StarvalCommand> commands;

    private JavaPlugin plugin;

    public CommandManager(JavaPlugin pl) {
        plugin = plugin;
        commands = new ArrayList<StarvalCommand>();
        // addCommand(new CommandName(pl));
        registerCommands();
    }

    public void addCommand(StarvalCommand c) {
        commands.add(c);
    }

    public ArrayList<StarvalCommand> getCommands() {
        return commands;
    }

    public void registerCommands() {
        for (StarvalCommand starvalCommand : this.getCommands()) {
            for (String l : starvalCommand.getAliases()) {
                plugin.getCommand(l).setExecutor(this);
            }
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        for (StarvalCommand starvalCommand : getCommands()) {
            if (starvalCommand.getAliases().contains(label.toLowerCase())) {
                if (!meetsRequirements(starvalCommand, sender)) {
                    sender.sendMessage(
                            ChatColor.translateAlternateColorCodes('&', "&8[&6Command&8] &7Unknown command."));
                    return false;
                }
                try {
                    starvalCommand.execute(sender, args);
                } catch (Exception e) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
                            "&8[&6Command&8] &cIncorrect usage. &7(&f" + starvalCommand.getSyntax() + "&7)"));
                }
                return true;
            }
        }
        return false;
    }

    public boolean meetsRequirements(StarvalCommand starvalCommand, CommandSender s) {
        for (Requirement r : starvalCommand.getRequirements()) {
            if (!starvalCommand.hasRequirement(s, r)) {
                return false;
            }
        }
        return true;
    }

}
