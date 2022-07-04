package de.starvalcity.base.api.handling;

import de.starvalcity.base.Pluginbase;
import de.starvalcity.base.api.def.database.MySQLAPI;
import org.bukkit.event.Listener;

/**
 * Der {@link SQLManager} sorgt für die Ausführung von benutzerdefinierten Anfragen innerhalb von Datenbanken.
 */
public class SQLManager implements Listener {

    private static Pluginbase pluginbase = new Pluginbase();

    static String economyTableQuery = "CREATE TABLE `sc_economy` ( " +
            "`UUID` binary(16), " +
            "`StarvalID` varchar(30), " +
            "`Playername` varchar(30), " +
            "`ReadyCash` double(64,2), " +
            "`BankBalance` double(64,2), " +
            "`Balance` double(64,2), " +
            "`SalaryAmount` double(64,2), " +
            "PRIMARY KEY (`UUID`));";
    static String banksTableQuery = "CREATE TABLE `sc_banks` ( " +
            "`AccountType` text(16), " +
            "`AccountID` varchar(30), " +
            "`AccountCreator` varchar(30), " +
            "`AccountOwner` varchar(30), " +
            "`AccountBalance` double(64,2), " +
            "PRIMARY KEY (`AccountID`));";

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
