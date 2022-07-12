package de.starvalcity.base.command;

import de.starvalcity.base.Core;
import de.starvalcity.base.Pluginbase;
import de.starvalcity.base.api.handling.MessageManager;
import de.starvalcity.base.api.handling.ObjectManager;
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
                if (ObjectManager.objectExists(player)) {
                    sender.sendMessage(messageManager.getMessage("Commands.Attach.Instance_Already_Exists"));
                } else {
                    pluginbase.getObjectManager().attachObject(player);
                    sender.sendMessage(messageManager.getMessage("Commands.Attach.Instance_Attach_Success"));
                }
            }
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("show")) {
                    int playerId = pluginbase.getObjectManager().getObjectId(player);
                    if (ObjectManager.objectExists(player)) {
                        sender.sendMessage(messageManager.getMessage("Commands.Attach.ID_Show_Own") + playerId);
                    } else {
                        sender.sendMessage(messageManager.getMessage("Commands.Attach.Instance_Could_Not_Be_Found"));
                    }
                } else if (args[0].equalsIgnoreCase("clear")) {
                    if (ObjectManager.objectExists(player)) {
                        pluginbase.getObjectManager().unattachObject(player);
                        sender.sendMessage(messageManager.getMessage("Commands.Attach.ID_Deletion_Success"));
                    } else {
                        sender.sendMessage(messageManager.getMessage("Commands.Attach.Instance_Could_Not_Be_Found"));
                    }
                } else if (args[0].equalsIgnoreCase("randomize")) {
                    if (!ObjectManager.objectExists(player)) {
                        pluginbase.getObjectManager().attachObject(player);
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
                        if (ObjectManager.objectExists(target)) {
                            pluginbase.getObjectManager().unattachObject(target);
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
                        if (ObjectManager.objectExists(target)) {
                            int targetId = ObjectManager.getObjectId(target);
                            sender.sendMessage(messageManager.getMessage("Commands.Attach.ID_Show_Others") + targetId);
                        } else {
                            sender.sendMessage(messageManager.getMessage("Commands.Attach.Instance_Could_Not_Be_Found"));
                        }
                    } else {
                        sender.sendMessage(messageManager.getMessage("Commands.Attach.Instance_Could_Not_Be_Found"));
                    }
                } else if (args[0].equalsIgnoreCase("getInstanceID")) {
                    Object object = args[1];

                    if (ObjectManager.objectExists(object)) {
                        int objectId = ObjectManager.getObjectId(object);
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
                        if (!ObjectManager.idExists(id)) {
                            pluginbase.getObjectManager().unattachObject(target);
                            pluginbase.getObjectManager().setObjectId(target, id);
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
