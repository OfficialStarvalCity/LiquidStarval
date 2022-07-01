package de.starvalcity.base.api.def.economy;

import de.starvalcity.base.api.def.database.MySQLAPI;
import de.starvalcity.base.background.log.LogHandler;

public class EconomyAPI {

    private static LogHandler log = new LogHandler();

    private static String tableSetupQuery = "CREATE TABLE `sc_economy` (" +
            " `UUID` VARCHAR(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci," +
            " `StarvalID` VARCHAR(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci," +
            " `Playername` VARCHAR(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci," +
            " `ReadyCash` DOUBLE(64.2) DEFAULT NULL," +
            " `BankBalance` DOUBLE(64.2) DEFAULT NULL," +
            " `Balance` DOUBLE(64.2) DEFAULT NULL," +
            " `SalaryAmount` DOUBLE(64.2) DEFAULT NULL," +
            " PRIMARY KEY (`StarvalID`)" +
            ");";

    public static void setupTable() {
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
