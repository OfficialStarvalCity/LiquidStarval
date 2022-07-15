package de.starvalcity.base.api.handling;

import de.starvalcity.base.Pluginbase;
import de.starvalcity.base.api.def.database.MySQLAPI;
import org.bukkit.event.Listener;

/**
 * Der {@link SQLManager} sorgt für die Ausführung von benutzerdefinierten Anfragen innerhalb von Datenbanken.
 */
public class SQLManager implements Listener {

    private static Pluginbase pluginbase = new Pluginbase();

    static String objectsTableQuery = "CREATE TABLE `LiquidObjects` (" +
            "`Object` varchar(64), " +
            "`Id` varchar(30), " +
            "PRIMARY KEY (`Id`));";
    static String playersTableQuery = "CREATE TABLE `LiquidPlayers` (" +
            "`UUID` varchar(64), " +
            "`Id` varchar(30), " +
            "`Playername` varchar(30), " +
            "`FirstSeen` varchar(20),  " +
            "`LastSeen` varchar(20), " +
            "`IP` varchar(30), " +
            "`Playtime` varchar(30), " +
            "`Rank` varchar(20), " +
            "`Faction` varchar(20), " +
            "`FactionRank` varchar(20)," +
            "PRIMARY KEY (`UUID`));";
    static String economyTableQuery = "CREATE TABLE `LiquidEconomy` (" +
            "`Object` varchar(64), " +
            "`Id` varchar(30), " +
            "`AccountHolder` varchar(30), " +
            "`AccountName` varchar(30), " +
            "`ReadyCash` double(64,2), " +
            "`BankBalance` double(64,2), " +
            "`Balance` double(64,2), " +
            "`SalaryAmount` double(64,2), " +
            "PRIMARY KEY (`Id`));";
    static String banksTableQuery = "CREATE TABLE `LiquidBanks` ( " +
            "`Name` varchar(20), " +
            "`Id` varchar(30), " +
            "`Founder` varchar(30), " +
            "`Owner` varchar(30), " +
            "`Accounts` varchar(10), " +
            "PRIMARY KEY (`Id`));";
    static String bankAccountsTableQuery = "CREATE TABLE `LiquidBankAccounts` ( " +
            "`Bank` varchar(20), " +
            "`AccountType` text(16), " +
            "`Id` varchar(30), " +
            "`AccountCreator` varchar(30), " +
            "`AccountOwner` varchar(30), " +
            "`AccountBalance` double(64,2), " +
            "PRIMARY KEY (`Id`));";

    public static void setupObjectsTable() {
        if (!MySQLAPI.existsTable("LiquidObjects")) {
            pluginbase.getLogHandler().sqlInfo("Creating table 'LiquidObjects' ...");
            MySQLAPI.execute(objectsTableQuery);
        }
    }

    public static void setupPlayersTable() {
        if (!MySQLAPI.existsTable("LiquidPlayers")) {
            pluginbase.getLogHandler().sqlInfo("Creating table 'LiquidPlayers' ...");
            MySQLAPI.execute(playersTableQuery);
        }
    }

    public static void setupEconomyTable() {
        if (!MySQLAPI.existsTable("LiquidEconomy")) {
            pluginbase.getLogHandler().sqlInfo("Creating table 'LiquidEconomy' ...");
            MySQLAPI.execute(economyTableQuery);
        }
    }

    public static void setupBanksTable() {
        if (!MySQLAPI.existsTable("LiquidBanks")) {
            pluginbase.getLogHandler().sqlInfo("Creating table 'LiquidBanks' ...");
            MySQLAPI.execute(banksTableQuery);
        }
    }

    public static void setupBankAccountsTable() {
        if (!MySQLAPI.existsTable("LiquidBankAccounts")) {
            pluginbase.getLogHandler().sqlInfo("Creating table 'LiquidBankAccounts' ...");
            MySQLAPI.execute(bankAccountsTableQuery);
        }
    }
}
