package de.starvalcity.base.api.def.command;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

/**
 * {@link StarvalCommand}
 * <p>An unique implementation of a {@link org.bukkit.command.Command}.</p>
 *
 * <p>This class is <b>optional</b> and can or cannot be used.</p>
 */
public abstract class StarvalCommand {

    protected JavaPlugin plugin;

    private ArrayList<String> aliases = new ArrayList<String>();
    private ArrayList<Requirement> requirements = new ArrayList<Requirement>();
    private String syntax;
    private String description;

    public StarvalCommand(JavaPlugin plugin) {
        plugin = plugin;
    }

    public ArrayList<String> getAliases() {
        return aliases;
    }

    public void setAliases(ArrayList<String> aliases) {
        this.aliases = aliases;
    }

    public String getSyntax() {
        return syntax;
    }

    public void setSyntax(String syntax) {
        this.syntax = syntax;
    }

    public void addAlias(String a) {
        aliases.add(a);
    }

    public void addRequirement(Requirement r) {
        requirements.add(r);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Requirement> getRequirements() {
        return requirements;
    }

    public void setRequirements(ArrayList<Requirement> requirements) {
        this.requirements = requirements;
    }

    public abstract boolean execute(CommandSender sender, String[] args) throws Exception;

    public boolean hasRequirement(CommandSender s, Requirement r) {
        switch (r) {
            case PLAYER:
                if (!(s instanceof Player)) {
                    return false;
                }
                break;
            case STAFF:
                if (s instanceof Player) {
                    if (!s.hasPermission("starvalcity.staff")) {
                        return false;
                    }
                }
                break;
            case BUILDER:
                if (s instanceof Player) {
                    if (!s.hasPermission("starvalcity.builder")) {
                        return false;
                    }
                }
                break;
            case PROJECT_MANAGEMENT:
                if (s instanceof Player) {
                    if (!s.hasPermission("starvalcity.projectmanagement")) {
                        return false;
                    }
                }
                break;
        }
        return true;
    }

}
