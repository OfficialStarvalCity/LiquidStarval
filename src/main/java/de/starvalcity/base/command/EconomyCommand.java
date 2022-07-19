package de.starvalcity.base.command;

import de.starvalcity.base.Core;
import de.starvalcity.base.api.def.StarvalPlayer;
import de.starvalcity.base.api.def.economy.BankAccount;
import de.starvalcity.base.api.handling.MessageManager;
import de.starvalcity.base.api.handling.SQLManager;
import de.starvalcity.base.api.handling.economy.EconomySQL;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class EconomyCommand implements CommandExecutor, Listener, TabCompleter {

    EconomySQL ecoSQL = new EconomySQL();
    MessageManager messageManager = new MessageManager();

    private static Core plugin;

    public EconomyCommand(Core plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 0) {
            if (label.equalsIgnoreCase("eco")) {
                sender.sendMessage(messageManager.getMessage("Commands.Economy.Insufficient_Arguments"));
            } else if (label.equalsIgnoreCase("money")) {
                sender.sendMessage(messageManager.getMessage("Commands.Economy.Money") + ecoSQL.getReadyCash(sender));
            }
        }
        if (args.length == 1) {
            if (label.equalsIgnoreCase("money")) {
                Player target = Bukkit.getPlayer(args[0]);
                if (target != null) {
                    sender.sendMessage(messageManager.getMessage("Commands.Economy.Money") + ecoSQL.getReadyCash(sender));
                } else {
                    sender.sendMessage(messageManager.getMessage("General.Target_Player_Does_Not_Exist"));
                }
            }
            if (args[0].equalsIgnoreCase("help")) {
                messageManager.sendEconomyHelp(sender);
            }
        }
        if (args.length == 3) {
            if (args[0].equalsIgnoreCase("setMoney")) {
                int id = Integer.parseInt(args[1]);
                double amount = Double.parseDouble(args[2]); //TODO
                if (SQLManager.idExists(id)) {
                    Object economyObject = SQLManager.getObject(id);
                    if (economyObject instanceof BankAccount) {
                        BankAccount bankAccount = (BankAccount) economyObject;
                        ecoSQL.setBankAccountBalance(bankAccount, amount);
                    } else if (economyObject instanceof StarvalPlayer) {
                        StarvalPlayer starvalPlayer = (StarvalPlayer) economyObject;
                        ecoSQL.setReadyCash(starvalPlayer, amount);
                    }
                } else {
                    sender.sendMessage(messageManager.getMessage("Commands.Attach.Instance_Could_Not_Be_Found"));
                }
            }
        }
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        return null;
    }
}
