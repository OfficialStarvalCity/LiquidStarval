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

    /**
     * Objekt Datenbankübertragung
     * Speichert ein Objekt in der Datenbank.
     * @param object Objekt, welcher hinzugefügt werden soll
     */
    public void attachObject(Object object) {
        int objectId = InstanceManager.randomId();
        /* MySQLAPI.update("INSERT INTO `sc_players`" +
                "(`UUID`, `Id`, `Playername`, `FirstSeen`, `LastSeen`, `IP`, `Playtime`, `Rank`, `Faction`, `FactionRank`) " +
                "VALUES ('" +
                playerUniqueId +
                "','" + playerId +
                "','" + playerName +
                "','" + firstSeen +
                "','" + null +
                "','" + player.getAddress() +
                "','" + "Spieler" +
                "','" + "Zivilisten" +
                "','" + "Mitglied')"); */
        if (!InstanceManager.idExists(objectId)) {
            if (!InstanceManager.instanceExists(object)) {
                MySQLAPI.update("INSERT INTO `sc_ids` (`Instance`, `Id`) VALUES ('" + object + "','" + objectId + "');");
                pluginbase.getLogHandler().sqlInfo("Attaching: Instance successfully attached and saved to database.");
            } else {
                pluginbase.getLogHandler().sqlCustomError("Attaching: Instance already attached.", null);
            }
        } else {
            pluginbase.getLogHandler().sqlCustomError("Attaching: Instance already attached.", null);
        }
    }

    /**
     * Objekt Datenbankentfernung
     * Entfernt ein Objekt aus der Datenbank.
     * @param object Objekt, welcher aus der Datenbank entfernt werden soll
     */
    public void unattachObject(Object object) {
        int objectId = getObjectId(object);
        if (!InstanceManager.instanceExists(object)) {
            pluginbase.getLogHandler().sqlCustomError("Attaching: Instance could not be deleted because it does not exist.", null);
        } else {
            MySQLAPI.update("DELETE FROM `sc_ids` WHERE `Instance` = \"" + object + "\";");
            pluginbase.getLogHandler().sqlInfo("Attaching: Instance successfully unattached and deleted from database.");
        }
    }

    /**
     * Entfernung der Objekt ID
     * Entfernt eine ID eines Objektes
     * @param object Objekt, dessen ID entfernt werden soll
     */
    public void removeObjectId(Object object) {
        if (!InstanceManager.instanceExists(object)) {
            pluginbase.getLogHandler().sqlCustomError("Attaching: Instance Id could not be deleted because it does not exist.", null);
        } else {
            MySQLAPI.update("INSERT INTO `sc_ids` (`Instance`, `Id`) VALUES ('" + object + "','" + "0" + "');");
            pluginbase.getLogHandler().sqlInfo("Attaching: Instance ID  was deleted.");
        }
    }

    /**
     * Setzen der Objekt ID
     * Setzt eine ID eines Objektes
     * @param object Objekt, dessen ID gesetzt werden soll
     * @param id ID, welche gesetzt werden soll
     */
    public void setObjectId(Object object, int id) {
        MySQLAPI.update("INSERT INTO `sc_ids` (`Instance`, `Id`) VALUES ('" + object + "','" + id + "');");
        pluginbase.getLogHandler().sqlInfo("Attaching: Instance ID successfully set.");
    }

    /**
     * Objekt ID Getter
     * @param object Objekt, dessen ID gezeigt werden soll
     * @return ID des angegebenen Objektes
     */
    public int getObjectId(Object object) {
        int id = 0;

        try {
            ResultSet resultSet = MySQLAPI.query("SELECT `Id` FROM `sc_ids` WHERE `Instance` = \"" + object + "\";");

            while (resultSet.next()) {
                id = resultSet.getInt("Id");
            }
        } catch (SQLException sqlException) {
            pluginbase.getLogHandler().sqlLog("SELECT `Id` FROM `sc_ids` WHERE `Instance` = " + object + ";", sqlException);
        }
        return id;
    }

}
