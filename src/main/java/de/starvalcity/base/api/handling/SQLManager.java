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

    static String objectsTableQuery = "CREATE TABLE `Objekte` (" +
            "`Objekt` varchar(64), " +
            "`ID` varchar(30), " +
            "PRIMARY KEY (`ID`));";
    static String playersTableQuery = "CREATE TABLE `Spieler` (" +
            "`ID` varchar(30), " +
            "`UUID` varchar(64), " +
            "`Name` varchar(30), " +
            "`Erster Beitritt` varchar(20),  " +
            "`Letzter Beitritt` varchar(20), " +
            "`Spielzeit` varchar(30), " +
            "`Rang` varchar(20), " +
            "`Bargeld` double(64,2), " +
            "`Kontostand` double(64,2), " +
            "`Fraktion` varchar(20), " +
            "`Fraktionsrang` varchar(20), " +
            "PRIMARY KEY (`ID`));";

    /**
     * Setup: LiquidObjects Tabelle
     */
    public static void setupObjectsTable() {
        if (!MySQLAPI.existsTable("Objekte")) {
            pluginbase.getLogHandler().sqlInfo("Creating table 'Objekte' ...");
            MySQLAPI.execute(objectsTableQuery);
        }
    }

    /**
     * Setup: LiquidPlayers Tabelle
     */
    public static void setupPlayersTable() {
        if (!MySQLAPI.existsTable("Spieler")) {
            pluginbase.getLogHandler().sqlInfo("Creating table 'Spieler' ...");
            MySQLAPI.execute(playersTableQuery);
        }
    }
}
