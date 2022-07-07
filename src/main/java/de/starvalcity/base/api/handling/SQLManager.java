package de.starvalcity.base.api.handling;

import de.starvalcity.base.Pluginbase;
import de.starvalcity.base.api.def.database.MySQLAPI;
import org.bukkit.event.Listener;

/**
 * Der {@link SQLManager} sorgt für die Ausführung von benutzerdefinierten Anfragen innerhalb von Datenbanken.
 */
public class SQLManager implements Listener {

    private static Pluginbase pluginbase = new Pluginbase();

    static String idsTableQuery = "CREATE TABLE `sc_ids` (" +
            "`Instance` varchar(30), " +
            "`Id` varchar(30), " +
            "`CreationDate` varchar(30), " +
            "PRIMARY KEY (`Id`));";
    static String playersTableQuery = "CREATE TABLE `sc_players` (" +
            "`UUID` binary(16), " +
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
    static String economyTableQuery = "CREATE TABLE `sc_economy` ( " +
            "`UUID` binary(16), " +
            "`Id` varchar(30), " +
            "`Playername` varchar(30), " +
            "`ReadyCash` double(64,2), " +
            "`BankBalance` double(64,2), " +
            "`Balance` double(64,2), " +
            "`SalaryAmount` double(64,2), " +
            "PRIMARY KEY (`UUID`));";
    static String banksTableQuery = "CREATE TABLE `sc_banks` ( " +
            "`AccountType` text(16), " +
            "`Id` varchar(30), " +
            "`AccountCreator` varchar(30), " +
            "`AccountOwner` varchar(30), " +
            "`AccountBalance` double(64,2), " +
            "PRIMARY KEY (`Id`));";

    public static void setupIdsTable() {
        if (!MySQLAPI.existsTable("sc_ids")) {
            pluginbase.getLogHandler().sqlInfo("Creating table 'sc_ids' ...");
            MySQLAPI.execute(idsTableQuery);
        }
    }

    public static void setupPlayersTable() {
        if (!MySQLAPI.existsTable("sc_players")) {
            pluginbase.getLogHandler().sqlInfo("Creating table 'sc_players' ...");
            MySQLAPI.execute(playersTableQuery);
        }
    }

    public static void setupEconomyTable() {
        if (!MySQLAPI.existsTable("sc_economy")) {
            pluginbase.getLogHandler().sqlInfo("Creating table 'sc_economy' ...");
            MySQLAPI.execute(economyTableQuery);
        }
    }

    public static void setupBankTable() {
        if (!MySQLAPI.existsTable("sc_banks")) {
            pluginbase.getLogHandler().sqlInfo("Creating table 'sc_banks' ...");
            MySQLAPI.execute(banksTableQuery);
        }
    }
}
