package de.starvalcity.base.api.def.economy;

import de.starvalcity.base.Pluginbase;
import de.starvalcity.base.api.def.database.MySQLAPI;
import de.starvalcity.base.background.log.LogHandler;

public class EconomyAPI {

    private LogHandler log = new LogHandler();
    private Pluginbase plugin = new Pluginbase();

    private String tableSetupQuery = "CREATE TABLE IF NOT EXISTS `sc_economy` ("
            + " `UUID` varchar(64) NOT NULL,"
            + " `StarvalID` varchar(64) NOT NULL,"
            + " `Playername` varchar(100) NOT NULL,"
            + " `ReadyCash` double(64,2),"
            + " `BankBalance` double(64,2),"
            + " `Balance` double(64,2),"
            + " `SalaryAmount` double(64,2)"
            + " PRIMARY KEY (`StarvalID`),"
            + " UNIQUE KEY `uq_starvaleconomy_1` (`StarvalID`));";

    public void setupTable() {
        if (MySQLAPI.isConnected()) {
            if (!MySQLAPI.existsTable("sc_economy")) {
                MySQLAPI.execute(tableSetupQuery);
                log.sqlInfo("Creating table `sc_economy` ...");
            }
        } else {
            log.sqlConnectionError();
        }
    }

}
