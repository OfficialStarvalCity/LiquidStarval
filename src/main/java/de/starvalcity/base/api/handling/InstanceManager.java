package de.starvalcity.base.api.handling;

import de.starvalcity.base.Pluginbase;
import de.starvalcity.base.api.def.database.MySQLAPI;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class InstanceManager {

    private static Pluginbase pluginbase = new Pluginbase();

    public static int generateId() {
        Random random = new Random();
        int id = random.nextInt(9999);

        while (idExists(id)) {
            id = random.nextInt(9999);
        }
        return id;
    }

    public static boolean idExists(int id) {
        int i = 0;
        boolean exist = true;

        try {
            ResultSet resultSet = MySQLAPI.query("SELECT `Id` FROM `Factions` WHERE `Id` = " + id + ";");
            ResultSet resultSet2 = MySQLAPI.query("SELECT `Id` FROM `sc_banks` WHERE `Id` = " + id + ";");
            ResultSet resultSet3 = MySQLAPI.query("SELECT `Id` FROM `sc_economy` WHERE `Id` = " + id + ";");

            while (resultSet.next() && resultSet2.next() && resultSet3.next()) {
                i = resultSet.getInt("Id");
                i = resultSet2.getInt("Id");
                i = resultSet3.getInt("Id");
            }
        } catch (SQLException sqlException) {
            pluginbase.getLogHandler().sqlLog("'SELECT `Id` FROM `Factions` WHERE `Id` = " + id + "';'", sqlException);
            pluginbase.getLogHandler().sqlLog("'SELECT `Id` FROM `sc_banks` WHERE `Id` = " + id + "';'", sqlException);
            pluginbase.getLogHandler().sqlLog("'SELECT `Id` FROM `sc_economy` WHERE `Id` = " + id + "';'", sqlException);
        }
        if (!(i > 0)) {
            exist = false;
        }
        return exist;
    }
}
