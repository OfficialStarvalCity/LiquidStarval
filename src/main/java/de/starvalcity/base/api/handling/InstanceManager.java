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

    public static Object getInstanceId(Object instance) {
        Object object = new Object();

        try {
            ResultSet resultSet = MySQLAPI.query("SELECT `Id` FROM `sc_ids` WHERE `Instance` = \"" + instance + "\";");

            while (resultSet.next()) {
                object = resultSet.getObject("Id");
            }
        } catch (SQLException exception) {
            pluginbase.getLogHandler().sqlLog("SELECT Id FROM sc_ids WHERE Instance = " + instance + ";", exception);
        }
        return object;
    }

    public static boolean idExists(int id) {
        int iterator = 0;
        boolean exist = true;
        try {

            ResultSet rs = MySQLAPI.query("SELECT `Id` FROM `sc_ids` WHERE `Id` = " + id + ";");

            while (rs.next()) {
                iterator = rs.getInt("Id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(!(iterator > 0)) {
            exist = false;
        }
        return exist;
    }

    public static boolean instanceExists(Object instance) {
        ResultSet resultSet = MySQLAPI.query("SELECT `Instance` FROM `sc_ids` WHERE `Instance` = \"" + instance + "\";");
        try {
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static int randomId() {

        Random random = new Random();
        int id = random.nextInt(9999);

        while(idExists(id)) {
            id = random.nextInt(9999);
        }

        return id;
    }

}
