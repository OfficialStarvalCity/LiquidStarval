package de.starvalcity.base.api.handling;

import de.starvalcity.base.background.def.CustomizedFile;
import de.starvalcity.base.utilities.FileHandler;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;

public class MessageManager {

    private final CustomizedFile messagesCFG;
    private final YamlConfiguration messagesYML;

    public MessageManager() {
        messagesCFG = new CustomizedFile("plugins//LiquidStarval//Configuration", "Messages.yml");
        messagesYML = YamlConfiguration.loadConfiguration(messagesCFG.getFile());
        messagesYML.options().copyDefaults(true);

        messagesYML.addDefault("Prefixes.Default_Prefix", "&7[&bLiquid&9Starval&7]&f ");
        messagesYML.addDefault("Prefixes.Economy_Prefix", "&7[&2Wirtschaft&7]&f ");
        messagesYML.addDefault("Prefixes.Permissions_Prefix", "&7[&cRechte&7]&f ");

        messagesYML.addDefault("General.Insufficient_Permissions", "%perPrefix% &cUnzureichende Rechte!");
        messagesYML.addDefault("General.Unknown_Command", "%defPrefix% &cUnbekannter Befehl!");
        messagesYML.addDefault("General.Feature_Unavailable", "%defPrefix% &cDieser Befehl kann derzeit nicht ausgeführt werden!");
        messagesYML.addDefault("General.Reload_Pending", "%defPrefix% &bLiquid&9Starval&2 wird neugeladen ...");
        messagesYML.addDefault("General.Reload_Success", "%defPrefix% &bLiquid&9Starval&2 &aerfolgreich&2 neugeladen!");
        messagesYML.addDefault("General.Reload_Failure", "%defPrefix% &bLiquid&9Starval&2 &cfehlerhaft&2 neugeladen!");

        messagesYML.addDefault("Commands.Economy.Insufficient_Arguments", "%ecoPrefix% &cUngültige Ausführung! Nutze &7/eco help&c für Hilfe.");

        FileHandler.save(messagesCFG.getFile(), this.messagesYML);
    }

    public String replaceDefaultPrefix(String path) {
        String value = ChatColor.translateAlternateColorCodes('&', (this.messagesCFG.getString(path)));
        value = value.replace("%defPrefix%", ChatColor.translateAlternateColorCodes('&', (this.messagesCFG.getString("Prefixes.Default_Prefix"))));
        return value;
    }

    public String replaceEconomyPrefix(String path) {
        String value = ChatColor.translateAlternateColorCodes('&', (this.messagesCFG.getString(path)));
        value = value.replace("%ecoPrefix%", ChatColor.translateAlternateColorCodes('&', (this.messagesCFG.getString("Prefixes.Economy_Prefix"))));
        return value;
    }

    public String replacePermissionsPrefix(String path) {
        String value = ChatColor.translateAlternateColorCodes('&', (this.messagesCFG.getString(path)));
        value = value.replace("%perPrefix%", ChatColor.translateAlternateColorCodes('&', (this.messagesCFG.getString("Prefixes.Permissions_Prefix"))));
        return value;
    }
}
