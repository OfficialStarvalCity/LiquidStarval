package de.starvalcity.base.api.handling;

import de.starvalcity.base.api.def.database.MySQLAPI;
import org.bukkit.event.Listener;

/**
 * Der {@link SQLManager} sorgt für die Ausführung von benutzerdefinierten Anfragen innerhalb von Datenbanken.
 */
public class SQLManager implements Listener {

    public static void setupEconomyTable() {
        if (!MySQLAPI.existsTable("sc_economy")) {
            MySQLAPI.execute("CREATE TABLE `sc_economy` ( " +
                    "`UUID` binary(16), " +
                    "`StarvalID` varchar(30), " +
                    "`Playername` varchar(30), " +
                    "`ReadyCash` double(64,2), " +
                    "`BankBalance` double(64,2), " +
                    "`Balance` double(64,2), " +
                    "`SalaryAmount` double(64,2), " +
                    "PRIMARY KEY (`UUID`));");
        }
    }
}
