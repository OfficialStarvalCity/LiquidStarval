package de.starvalcity.base.command;

import de.starvalcity.base.Core;
import de.starvalcity.base.Pluginbase;
import de.starvalcity.base.api.handling.MessageManager;
import de.starvalcity.base.api.handling.SQLManager;
import org.bukkit.Bukkit;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class AttachCommand implements CommandExecutor {

    private static Pluginbase pluginbase = new Pluginbase();
    private MessageManager messageManager = new MessageManager();

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
                if (SQLManager.objectExists(player)) {
                    sender.sendMessage(messageManager.getMessage("Commands.Attach.Instance_Already_Exists"));
                } else {
                    SQLManager.attachObject(player);
                    pluginbase.getPlayerManager().attachPlayer(player);
                    sender.sendMessage(messageManager.getMessage("Commands.Attach.Instance_Attach_Success"));
                }
            }
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("show")) {
                    int playerId = SQLManager.getObjectId(player);
                    if (SQLManager.objectExists(player)) {
                        sender.sendMessage(messageManager.getMessage("Commands.Attach.ID_Show_Own") + playerId);
                    } else {
                        sender.sendMessage(messageManager.getMessage("Commands.Attach.Instance_Could_Not_Be_Found"));
                    }
                } else if (args[0].equalsIgnoreCase("clear")) {
                    if (SQLManager.objectExists(player)) {
                        SQLManager.unattachObject(player);
                        pluginbase.getPlayerManager().unattachPlayer(player);
                        sender.sendMessage(messageManager.getMessage("Commands.Attach.ID_Deletion_Success"));
                    } else {
                        sender.sendMessage(messageManager.getMessage("Commands.Attach.Instance_Could_Not_Be_Found"));
                    }
                } else if (args[0].equalsIgnoreCase("randomize")) {
                    if (!SQLManager.objectExists(player)) {
                        SQLManager.attachObject(player);
                        pluginbase.getPlayerManager().attachPlayer(player);
                        sender.sendMessage(messageManager.getMessage("Commands.Attach.Instance_Attach_Success"));
                    } else {
                        sender.sendMessage(messageManager.getMessage("Commands.Attach.Instance_Already_Exists"));
                    }
                }
            }
            if (args.length == 2) {
                if (args[0].equalsIgnoreCase("remove")) {
                    Player target = Bukkit.getPlayer(args[1]);

                    if (target != null) {
                        if (SQLManager.objectExists(target)) {
                            SQLManager.unattachObject(target);
                            pluginbase.getPlayerManager().unattachPlayer(target);
                            sender.sendMessage(messageManager.getMessage("Commands.Attach.ID_Deletion_Success"));
                        } else {
                            sender.sendMessage(messageManager.getMessage("Commands.Attach.Instance_Could_Not_Be_Found"));
                        }
                    } else {
                        sender.sendMessage(messageManager.getMessage("General.Target_Player_Does_Not_Exist"));
                    }
                } else if (args[0].equalsIgnoreCase("getPlayerID")) {
                    Player target = Bukkit.getPlayer(args[1]);

                    if (target != null) {
                        if (SQLManager.objectExists(target)) {
                            int targetId = SQLManager.getObjectId(target);
                            sender.sendMessage(messageManager.getMessage("Commands.Attach.ID_Show_Others") + targetId);
                        } else {
                            sender.sendMessage(messageManager.getMessage("Commands.Attach.Instance_Could_Not_Be_Found"));
                        }
                    } else {
                        sender.sendMessage(messageManager.getMessage("Commands.Attach.Instance_Could_Not_Be_Found"));
                    }
                } else if (args[0].equalsIgnoreCase("getInstanceID")) {
                    Object object = args[1];

                    if (SQLManager.objectExists(object)) {
                        int objectId = SQLManager.getObjectId(object);
                        sender.sendMessage(messageManager.getMessage("Commands.Attach.ID_Show_Others") + objectId);
                    } else {
                        sender.sendMessage(messageManager.getMessage("Commands.Attach.Instance_Could_Not_Be_Found"));
                    }
                }
            }
            if (args.length == 3) {
                if (args[0].equalsIgnoreCase("set")) {
                    Player target = Bukkit.getPlayer(args[1]);
                    int id = Integer.parseInt(args[2]);

                    if (target != null) {
                        if (!SQLManager.idExists(id)) {
                            SQLManager.unattachObject(target);
                            SQLManager.setObjectId(target, id);
                            pluginbase.getPlayerManager().unattachPlayer(target);
                            // set playerID in Player Manager TODO
                            sender.sendMessage(messageManager.getMessage("Commands.Attach.ID_Adding_Success"));
                        } else {
                            sender.sendMessage(messageManager.getMessage("Commands.Attach.ID_Already_Exists"));
                        }
                    } else {
                        sender.sendMessage(messageManager.getMessage("General.Target_Player_Does_Not_Exist"));
                    }
                }
            }
        }
        return true;
    }
}
