package de.starvalcity.base.api.handling;

import de.starvalcity.base.api.def.database.MySQLAPI;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class EconomyManager {

    public static boolean economyObjectExists(Object object) {
        ResultSet resultSet = MySQLAPI.query("SELECT `Instance` FROM `sc_economy` WHERE `Instance` = \"" + object + "\";");
        try {
            return resultSet.next();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return false;
    }

    public void attachEconomyObject(Object object) {
        int objectId = ObjectManager.randomId();

    }

    public static int randomId() {

        Random random = new Random();
        int id = random.nextInt(9999);

        while(idExists(id)) {
            id = random.nextInt(9999);
        }

        return id;
    }

    public static boolean idExists(int id) {
        int iterator = 0;
        boolean exist = true;
        try {

            ResultSet rs = MySQLAPI.query("SELECT `Id` FROM `sc_ids` WHERE `Id` = " + id + ";");

            while (rs.next()) {
                iterator = rs.getInt("Id");
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        if(!(iterator > 0)) {
            exist = false;
        }
        return exist;
    }

}
