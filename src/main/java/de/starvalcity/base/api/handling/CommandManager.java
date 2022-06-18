package de.starvalcity.base.api.handling;

import de.starvalcity.base.background.def.SubCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class CommandManager implements CommandExecutor {

    private ArrayList<SubCommand> subCommands = new ArrayList<>();

    public CommandManager() {
        // put all Cmds in arraylist
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0) {
                // Cmd Declaration
                // cmd.perform(player, args);
            } else if (args.length > 0) {
                for (int iterator = 0; iterator < this.subCommands.size(); iterator++) {
                    if (args[0].equalsIgnoreCase(this.subCommands.get(iterator).getName())) {
                        this.subCommands.get(iterator).perform(player, args);
                        return true;
                    }
                }
            }
        }
        return true;
    }

    public ArrayList<SubCommand> getSubCommands() {
        return subCommands;
    }

    public void setSubCommands(ArrayList<SubCommand> subCommands) {
        this.subCommands = subCommands;
    }
}
