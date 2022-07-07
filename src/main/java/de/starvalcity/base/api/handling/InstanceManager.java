package de.starvalcity.base.api.handling;

import de.starvalcity.base.Pluginbase;
import de.starvalcity.base.api.def.database.MySQLAPI;
import org.bukkit.Material;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Random;

public class InstanceManager {

    private static Pluginbase pluginbase = new Pluginbase();

    public void generateId(Object instance) {
        Random random = new Random();
        int id = random.nextInt(9999);

        while (idExists(id)) {
            id = random.nextInt(9999);
        }
        if (!idExists(id)) {
            MySQLAPI.query("INSERT INTO `sc_ids` (`Instance`, `Id`, `CreationDate`) VALUES ('" +
                    instance + "','" + id + "','" + System.currentTimeMillis() + "');");
        }
    }

    public int getId(Object instance) {
        try {
            return MySQLAPI.query("SELECT `Id` FROM `sc_ids` WHERE `Instance` =\"" + instance + "\";").getInt("Id");
        } catch (SQLException exception) {
            pluginbase.getLogHandler().sqlLog("SELECT `Id` FROM `sc_ids` WHERE `Instance` = " + instance + ";).getInt(Id)", exception);
            throw new RuntimeException(exception);
        }
    }

    public boolean idExists(int id) {
        int iterator = 0;
        boolean exists = true;
        try {
            ResultSet resultSet = MySQLAPI.query("SELECT `Id` FROM `sc_ids` WHERE `Id` = " + id + ";");

            while (resultSet.next()) {
                iterator = resultSet.getInt("Id");
            }
        } catch (SQLException sqlException) {
            pluginbase.getLogHandler().sqlLog("SELECT `Id` FROM `sc_ids` WHERE `Id` = " + id + ";", sqlException);
        }
        if (!(iterator > 0)) {
            exists = false;
        }
        return exists;
    }
}
