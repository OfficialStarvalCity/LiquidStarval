package de.starvalcity.base.api.handling.economy;

import de.starvalcity.base.api.def.database.MySQLAPI;
import de.starvalcity.base.api.def.economy.BalanceType;
import de.starvalcity.base.api.handling.InstanceManager;
import org.jetbrains.annotations.NotNull;

public class BalanceHandler {

    private final int defaultBalance = 1000;

    public void reset(int id) {
        Object instance = InstanceManager.getInstance(id);
        MySQLAPI.query("INSERT INTO `sc_economy`(`Instance`, `Id`, `ReadyCash`, `BankBalance`, `Balance`, `SalaryAmount`) " +
                "VALUES ('" + instance + "','" + id + "','" + 0 + "','" + 0 + "','" + 0 + "','" + 0 + "');");
    }

    public void setDefaultBalance(int id, @NotNull BalanceType type, int amount) {
        Object instance = InstanceManager.getInstance(id);
        switch (type) {
            case EVERYTHING:
            case READY_CASH:
                MySQLAPI.query("INSERT INTO `sc_economy`(`Instance`, `Id`, `ReadyCash`, `BankBalance`, `Balance`) " +
                        "VALUES ('" + instance + "','" + id + "','" + defaultBalance + "','" + 0 + "','" + 0 + "');");
                break;
            case ALL_BANK_ACCOUNTS:
                MySQLAPI.query("INSERT INTO `sc_economy`(`Instance`, `Id`, `ReadyCash`, `BankBalance`, `Balance`) " +
                        "VALUES ('" + instance + "','" + id + "','" + 0 + "','" + defaultBalance + "','" + 0 + "');");
                break;
            case SINGLE_BANK_ACCOUNT:
                break;
        }
    }
}
