package de.starvalcity.base.api.handling;

import de.starvalcity.base.background.def.CustomizedFile;
import de.starvalcity.base.utilities.FileHandler;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;

public class MessageManager {

    private final CustomizedFile messagesCFG;
    private final YamlConfiguration messagesYML;

    public MessageManager() {
        messagesCFG = new CustomizedFile("plugins//LiquidStarval//Configuration", "Messages.yml");
        messagesYML = YamlConfiguration.loadConfiguration(messagesCFG.getFile());
        messagesYML.options().copyDefaults(true);

        messagesYML.addDefault("Prefixes.Default_Prefix", "&7[&bLiquid&3Starval&7]&f ");
        messagesYML.addDefault("Prefixes.Economy_Prefix", "&7[&2Wirtschaft&7]&f ");
        messagesYML.addDefault("Prefixes.Permissions_Prefix", "&7[&cRechte&7]&f ");

        messagesYML.addDefault("General.Insufficient_Permissions", "%perPrefix% &cUnzureichende Rechte!");
        messagesYML.addDefault("General.Unknown_Command", "%defPrefix% &cUnbekannter Befehl!");
        messagesYML.addDefault("General.Feature_Unavailable", "%defPrefix% &cDieser Befehl kann derzeit nicht ausgeführt werden!");
        messagesYML.addDefault("General.Reload_Pending", "%defPrefix% &bLiquid&9Starval&2 wird neugeladen ...");
        messagesYML.addDefault("General.Reload_Success", "%defPrefix% &bLiquid&9Starval&2 &aerfolgreich&2 neugeladen!");
        messagesYML.addDefault("General.Reload_Failure", "%defPrefix% &bLiquid&9Starval&2 &cfehlerhaft&2 neugeladen!");
        messagesYML.addDefault("General.Target_Player_Does_Not_Exist", "%defPrefix% &cDer angegebene Spieler existiert nicht!");

        messagesYML.addDefault("Commands.Attach.Console_Cannot_Be_Attached", "%defPrefix% &cDie Konsole kann nicht in der Datenbank gespeichert werden.");
        messagesYML.addDefault("Commands.Attach.ID_Already_Exists", "%defPrefix% &cID existiert bereits in der Datenbank.");
        messagesYML.addDefault("Commands.Attach.ID_Adding_Success", "%defPrefix% &aID erfolgreich zu der Datenbank &2hinzugefügt.");
        messagesYML.addDefault("Commands.Attach.ID_Deletion_Success", "%defPrefix% &aID erfolgreich aus der Datenbank &centfernt.");
        messagesYML.addDefault("Commands.Attach.ID_Invalid", "%defPrefix% &cID ungültig.");
        messagesYML.addDefault("Commands.Attach.ID_Show_Own", "%defPrefix% &9Deine ID:&e ");
        messagesYML.addDefault("Commands.Attach.ID_Show_Others", "%defPrefix% &9ID des angegebenen Spielers:&e ");
        messagesYML.addDefault("Commands.Attach.Instance_Already_Exists", "%defPrefix% &cInstanz existiert bereits in der Datenbank.");
        messagesYML.addDefault("Commands.Attach.Instance_Attach_Failure", "%defPrefix% &cInstanz konnte nicht in der Datenbank gespeichert werden.");
        messagesYML.addDefault("Commands.Attach.Instance_Attach_Success", "%defPrefix% &aInstanz erfolgreich in der Datenbank gespeichert.");
        messagesYML.addDefault("Commands.Attach.Instance_Could_Not_Be_Found", "%defPrefix% &cInstanz konnte nicht in der Datenbank gefunden werden.");

        messagesYML.addDefault("Commands.Economy.Insufficient_Arguments", "%ecoPrefix% &cUngültige Ausführung! Nutze &7/eco help&c für Hilfe.");

        messagesYML.addDefault("Commands.Economy.GenHelp_Separator_Line", "&7--------------------- Allgemein ---------------------");
        messagesYML.addDefault("Commands.Economy.Help_Blank_Line", "                                                         ");
        messagesYML.addDefault("Commands.Economy.GenHelp_1", "&7/eco help - &aZeigt dieses Hilfemenü an");
        messagesYML.addDefault("Commands.Economy.GenHelp_2", "&7/eco advancedhelp - &aZeigt erweiterte Hilfe über die Wirtschaft an");
        messagesYML.addDefault("Commands.Economy.GenHelp_3", "&7/money - &aZeigt deinen aktuellen Kontostand");
        messagesYML.addDefault("Commands.Economy.GenHelp_4", "&7/money toplist - &aZeigt die Rangliste aller Kontostände");
        messagesYML.addDefault("Commands.Economy.GenHelp_5", "&7/money <Spieler> - &aZeigt den Kontostand eines anderen Spielers");
        messagesYML.addDefault("Commands.Economy.GenHelp_6", "&7/money pay <Spieler> <Betrag> - &aÜberweist Geld an einen anderen Spieler");

        messagesYML.addDefault("Commands.Economy.StaffHelp_Separator_Line", "&7------------------- Administration ------------------");
        messagesYML.addDefault("Commands.Economy.StaffHelp_1", "&7/eco setMoney <ID> <Betrag> - &aSetzt einer Instanz eine Menge an Geld");
        messagesYML.addDefault("Commands.Economy.StaffHelp_2", "&7/eco addMoney <ID> <Betrag> - &aFügt einer Instanz Geld hinzu");
        messagesYML.addDefault("Commands.Economy.StaffHelp_3", "&7/eco removeMoney <ID> <Betrag> - &aEntfernt einer Instanz Geld");
        messagesYML.addDefault("Commands.Economy.StaffHelp_4", "&7/eco setOwner <ID> <Spieler> - &aSetzt den Inhaber eines Kontos fest");
        messagesYML.addDefault("Commands.Economy.StaffHelp_5", "&7/eco addOwner <ID> <Spieler> - &aFügt einen Inhaber auf ein Konto hinzu");
        messagesYML.addDefault("Commands.Economy.StaffHelp_6", "&7/eco setMember <ID> <Spieler> - &aSetzt ein Mitglied eines Kontos fest");
        messagesYML.addDefault("Commands.Economy.StaffHelp_7", "&7/eco addMember <ID> <Spieler> - &aFügt ein Mitglied auf ein Konto hinzu");
        messagesYML.addDefault("Commands.Economy.StaffHelp_8", "&7/eco createBankAccount <Spieler> <Kontoname> <Bank> - &aErstellt ein Bankkonto für einen Spieler");
        messagesYML.addDefault("Commands.Economy.StaffHelp_9", "&7/eco deleteBankAccounts <Spieler> - &aEntfernt alle Konten eines Spielers");
        messagesYML.addDefault("Commands.Economy.StaffHelp_10", "&7/eco deleteBankAccount <ID> - &aEntfernt ein Konto eines Spielers");
        messagesYML.addDefault("Commands.Economy.StaffHelp_11", "&7/eco createCompanyBankAccount <Inhaber> <Kontoname> <Bank> - &aErstellt ein Firmenkonto");
        messagesYML.addDefault("Commands.Economy.StaffHelp_12", "&7/eco deleteCompanyBankAccounts <Inhaber> - &aEntfernt alle Konten eines Unternehmens");
        messagesYML.addDefault("Commands.Economy.StaffHelp_13", "&7/eco deleteCompanyAccount <ID> - &aEntfernt ein Konto eines Unternehmens");
        messagesYML.addDefault("Commands.Economy.StaffHelp_14", "&7/eco listCompanyAccounts - &aZeigt alle Unternehmenskonten");
        messagesYML.addDefault("Commands.Economy.StaffHelp_15", "&7/eco topCompanyAccounts - &aZeigt die Rangliste aller Unternehmenskonten");
        messagesYML.addDefault("Commands.Economy.StaffHelp_16", "&7/eco listTransactions [Spieler; Unternehmen; Fraktion] - &aListet alle Transaktionen auf");

        FileHandler.save(messagesCFG.getFile(), this.messagesYML);
    }

    public String getMessage(String path) {
        String value = ChatColor.translateAlternateColorCodes('&', (this.messagesCFG.getString(path)));
        value = value.replace("%defPrefix%", ChatColor.translateAlternateColorCodes('&', (this.messagesCFG.getString("Prefixes.Default_Prefix"))));
        value = value.replace("%ecoPrefix%", ChatColor.translateAlternateColorCodes('&', (this.messagesCFG.getString("Prefixes.Economy_Prefix"))));
        value = value.replace("%perPrefix%", ChatColor.translateAlternateColorCodes('&', (this.messagesCFG.getString("Prefixes.Permissions_Prefix"))));
        return value;
    }

    public String getRawMessage(String path) {
        String value = org.bukkit.ChatColor.translateAlternateColorCodes('&', (this.messagesCFG.getString(path)));
        return value;
    }

    public void sendEconomyHelp(CommandSender commandSender) {
        commandSender.sendMessage(getRawMessage("Commands.Economy.GenHelp_Separator_Line"));
        commandSender.sendMessage(getRawMessage("Commands.Economy.Help_Blank_Line"));
        commandSender.sendMessage(getRawMessage("Commands.Economy.GenHelp_1"));
        commandSender.sendMessage(getRawMessage("Commands.Economy.GenHelp_2"));
        commandSender.sendMessage(getRawMessage("Commands.Economy.GenHelp_3"));
        commandSender.sendMessage(getRawMessage("Commands.Economy.GenHelp_4"));
        commandSender.sendMessage(getRawMessage("Commands.Economy.GenHelp_5"));
        commandSender.sendMessage(getRawMessage("Commands.Economy.GenHelp_6"));
        commandSender.sendMessage(getRawMessage("Commands.Economy.Help_Blank_Line"));
        commandSender.sendMessage(getRawMessage("Commands.Economy.StaffHelp_Separator_Line"));
        commandSender.sendMessage(getRawMessage("Commands.Economy.StaffHelp_1"));
        commandSender.sendMessage(getRawMessage("Commands.Economy.StaffHelp_2"));
        commandSender.sendMessage(getRawMessage("Commands.Economy.StaffHelp_3"));
        commandSender.sendMessage(getRawMessage("Commands.Economy.StaffHelp_4"));
        commandSender.sendMessage(getRawMessage("Commands.Economy.StaffHelp_5"));
        commandSender.sendMessage(getRawMessage("Commands.Economy.StaffHelp_6"));
        commandSender.sendMessage(getRawMessage("Commands.Economy.StaffHelp_7"));
        commandSender.sendMessage(getRawMessage("Commands.Economy.StaffHelp_8"));
        commandSender.sendMessage(getRawMessage("Commands.Economy.StaffHelp_9"));
        commandSender.sendMessage(getRawMessage("Commands.Economy.StaffHelp_10"));
        commandSender.sendMessage(getRawMessage("Commands.Economy.StaffHelp_11"));
        commandSender.sendMessage(getRawMessage("Commands.Economy.StaffHelp_12"));
        commandSender.sendMessage(getRawMessage("Commands.Economy.StaffHelp_13"));
        commandSender.sendMessage(getRawMessage("Commands.Economy.StaffHelp_14"));
        commandSender.sendMessage(getRawMessage("Commands.Economy.StaffHelp_15"));
        commandSender.sendMessage(getRawMessage("Commands.Economy.StaffHelp_16"));
    }
}
