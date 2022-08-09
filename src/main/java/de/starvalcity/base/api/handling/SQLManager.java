package de.starvalcity.base.api.handling;

import de.starvalcity.base.Pluginbase;
import de.starvalcity.base.api.def.database.MySQLAPI;
import org.bukkit.event.Listener;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

/**
 * Der {@link SQLManager} sorgt für die Erstellung der standardisierten MySQL Datenbanktabellen.
 */
public class SQLManager implements Listener {

    private static Pluginbase pluginbase = new Pluginbase();

    static String objectsTableQuery = "CREATE TABLE `LiquidObjects` (" +
            "`Object` varchar(64), " +
            "`ID` varchar(30), " +
            "PRIMARY KEY (`ID`));";
    static String playersTableQuery = "CREATE TABLE `LiquidPlayers` (" +
            "`ID` varchar(30), " +
            "`UUID` varchar(64), " +
            "`Name` varchar(30), " +
            "`FirstSeen` varchar(20),  " +
            "`LastSeen` varchar(20), " +
            "`Playtime` varchar(30), " +
            "`Rank` varchar(20), " +
            "`ReadyCash` double(64,2), " +
            "`BankBalance` double(64,2), " +
            "`Faction` varchar(20), " +
            "`FactionRank` varchar(20), " +
            "PRIMARY KEY (`ID`));";
    static String banksTableQuery = "CREATE TABLE `LiquidBanks` (" +
            "`ID` varchar(30), " +
            "`Name` varchar(30), " +
            "`Founder` varchar(30), " +
            "`Owner` varchar(30), " +
            "`Balance` double(64,2), " +
            "`Accounts` varchar(30), " +
            "PRIMARY KEY (`ID`));";
    static String bankAccountsTableQuery = "CREATE TABLE `LiquidBankAccounts` (" +
            "`ID` varchar(30), " +
            "`Name` varchar(30), " +
            "`Bank` varchar(30), " +
            "`Founder` varchar(64), " +
            "`Owner` varchar(64), " +
            "`Moderators` varchar(64), " +
            "`Members` varchar(64), " +
            "`Balance` double(64,2), " +
            "PRIMARY KEY (`ID`));";
    static String companiesTableQuery = "CREATE TABLE `LiquidCompanies` (" +
            "`ID` varchar(30), " +
            "`Name` varchar(30), " +
            "`Founder` varchar(64), " +
            "`Owner` varchar(64), " +
            "`Balance` double(64,2), " +
            "PRIMARY KEY (`ID`));";

    /**
     * Setup: LiquidObjects Tabelle
     */
    public static void setupObjectsTable() {
        if (!MySQLAPI.existsTable("LiquidObjects")) {
            pluginbase.getLogHandler().sqlInfo("Creating table 'LiquidObjects' ...");
            MySQLAPI.execute(objectsTableQuery);
        }
    }

    /**
     * Setup: LiquidPlayers Tabelle
     */
    public static void setupPlayersTable() {
        if (!MySQLAPI.existsTable("LiquidPlayers")) {
            pluginbase.getLogHandler().sqlInfo("Creating table 'LiquidPlayers' ...");
            MySQLAPI.execute(playersTableQuery);
        }
    }

    /**
     * Setup: LiquidBnaks Tabelle
     */
    public static void setupBanksTable() {
        if (!MySQLAPI.existsTable("LiquidBanks")) {
            pluginbase.getLogHandler().sqlInfo("Creating table 'LiquidBanks' ...");
            MySQLAPI.execute(banksTableQuery);
        }
    }

    /**
     * Setup: LiquidBankAccounts Tabelle
     */
    public static void setupBankAccountsTable() {
        if (!MySQLAPI.existsTable("LiquidBankAccounts")) {
            pluginbase.getLogHandler().sqlInfo("Creating table 'LiquidBankAccounts' ...");
            MySQLAPI.execute(bankAccountsTableQuery);
        }
    }

    /**
     * Setup: LiquidCompanies Tabelle
     */
    public static void setupCompaniesTable() {
        if (!MySQLAPI.existsTable("LiquidCompanies")) {
            pluginbase.getLogHandler().sqlInfo("Creating table 'LiquidCompanies' ...");
            MySQLAPI.execute(companiesTableQuery);
        }
    }
}
