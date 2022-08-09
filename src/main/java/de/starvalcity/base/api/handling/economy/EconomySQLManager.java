package de.starvalcity.base.api.handling.economy;

import de.starvalcity.base.api.def.StarvalPlayer;
import de.starvalcity.base.api.def.TableHandler;
import de.starvalcity.base.api.def.database.MySQLAPI;
import de.starvalcity.base.api.def.economy.Bank;
import de.starvalcity.base.api.def.economy.EconomyObjectType;
import de.starvalcity.base.api.handling.object.ObjectSQLManager;
import org.jetbrains.annotations.NotNull;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EconomySQLManager extends TableHandler {

    public void addToTable(EconomyObjectType objectType) {
        int id = ObjectSQLManager.getObjectId(objectType);

        if (!databaseObjectExists(id, "LiquidBanks")) {
            if (ObjectSQLManager.objectExists(objectType)) {
                MySQLAPI.update("INSERT INTO `LiquidBanks` (`ID`, `Name`, `Founder`, `Owner`, `Balance`) VALUES ('" + id + "','" + uniqueId + "','" + name + "');");

            }
        }
    }

    @Override
    public boolean databaseObjectExists(int id, String table) {
        return super.databaseObjectExists(id, table);
    }
}
