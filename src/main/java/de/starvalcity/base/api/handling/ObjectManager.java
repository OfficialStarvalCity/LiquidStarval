package de.starvalcity.base.api.handling;

import de.starvalcity.base.Pluginbase;
import de.starvalcity.base.api.def.database.MySQLAPI;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class ObjectManager {

    private static Pluginbase pluginbase = new Pluginbase();

    /**
     * Objekt ID Getter
     * Gibt die ID eines Objektes aus der Datenbank wieder.
     * @param object Objekt aus der Datenbank
     * @return ID des Objektes
     */
    public static int getObjectId(Object object) {
        int id = 0;

        try {
            ResultSet resultSet = MySQLAPI.query("SELECT `Id` FROM `LiquidObjects` WHERE `Object` = \"" + object + "\";");

            while (resultSet.next()) {
                id = resultSet.getInt("Id");
            }
        } catch (SQLException sqlException) {
            pluginbase.getLogHandler().sqlLog("SELECT Id FROM LiquidObjects WHERE Object = " + object + ";", sqlException);
        }
        return id;
    }

    /**
     * Objekt Name Getter
     * Gibt den Namen eines Objektes aus der Datenbank wieder.
     * @param id ID des Objektes aus der Datenbank.
     * @return Name des Objektes
     */
    public static String getObjectName(int id) {
        String name = "";

        try {
            ResultSet resultSet = MySQLAPI.query("SELECT `Object` FROM `LiquidObjects` WHERE `Id` = \"" + id + "\";");

            while (resultSet.next()) {
                name = resultSet.getString("Object");
            }
        } catch (SQLException sqlException) {
            pluginbase.getLogHandler().sqlLog("SELECT `Object` FROM `LiquidObjects` WHERE `Id` = " + id + ";", sqlException);
        }
        return name;
    }


    /**
     * Objekt Getter
     * Gibt das Objekt einer zugehörigen ID aus der Datenbank wieder.
     * @param id ID des Objektes
     * @return Objekt aus der Datenbank
     */
    public static Object getObject(int id) {
        Object object = new Object();

        try {
            ResultSet resultSet = MySQLAPI.query("SELECT `Object` FROM `LiquidObjects` WHERE `Id` = \"" + id + "\";");

            while (resultSet.next()) {
                object = resultSet.getObject("Object");
            }
        } catch (SQLException sqlException) {
            pluginbase.getLogHandler().sqlLog("SELECT Instance FROM LiquidObjects WHERE Id = " + id + ";", sqlException);
        }
        return object;
    }

    /**
     * Exist Überprüfung
     * Überprüft, ob eine Objekt ID bereits in der Datenbank existiert.
     * @param id ID, welche geprüft werden soll
     * @return true / false
     */
    public static boolean idExists(int id) {
        int iterator = 0;
        boolean exist = true;
        try {

            ResultSet rs = MySQLAPI.query("SELECT `Id` FROM `LiquidObjects` WHERE `Id` = " + id + ";");

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

    public static boolean objectExists(Object object) {
        ResultSet resultSet = MySQLAPI.query("SELECT `Object` FROM `LiquidObjects` WHERE `Object` = \"" + object + "\";");
        try {
            return resultSet.next();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
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
     * @param object Objekt, welches hinzugefügt werden soll
     */
    public void attachObject(Object object) {
        int objectId = ObjectManager.randomId();
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
        if (!ObjectManager.idExists(objectId)) {
            if (!ObjectManager.objectExists(object)) {
                MySQLAPI.update("INSERT INTO `LiquidObjects` (`Object`, `Id`) VALUES ('" + object + "','" + objectId + "');");
                pluginbase.getLogHandler().sqlInfo("Attaching: Object successfully attached and saved to database.");
            } else {
                pluginbase.getLogHandler().sqlCustomError("Attaching: Object already attached.", null);
            }
        } else {
            pluginbase.getLogHandler().sqlCustomError("Attaching: Object already attached.", null);
        }
    }

    /**
     * Object Datenbankspeicherung
     * Speichert ein Objekt mit einer benutzerdefinierten ID in der Datenbank.
     * @param object Objekt, welches hinzugefügt werden soll
     * @param id ID des Objektes
     */
    public void attachObjectWithId(Object object, int id) {
        if (!ObjectManager.idExists(id)) {
            if (!ObjectManager.objectExists(object)) {
                MySQLAPI.update("INSERT INTO `LiquidObjects` (`Object`, `Id`) VALUES ('" + object + "','" + id + "');");
                pluginbase.getLogHandler().sqlInfo("Attaching: Object successfully attached and saved to database.");
            } else {
                pluginbase.getLogHandler().sqlCustomError("Attaching: Object already attached.", null);
            }
        } else {
            pluginbase.getLogHandler().sqlCustomError("Attaching: Object already attached.", null);
        }
    }

    /**
     * Objekt Datenbankentfernung
     * Entfernt ein Objekt aus der Datenbank.
     * @param object Objekt, welcher aus der Datenbank entfernt werden soll
     */
    public void unattachObject(Object object) {
        int objectId = getObjectId(object);
        if (!ObjectManager.objectExists(object)) {
            pluginbase.getLogHandler().sqlCustomError("Attaching: Object could not be deleted because it does not exist.", null);
        } else {
            MySQLAPI.update("DELETE FROM `LiquidObjects` WHERE `Object` = \"" + object + "\";");
            pluginbase.getLogHandler().sqlInfo("Attaching: Object successfully unattached and deleted from database.");
        }
    }

    /**
     * Entfernung der Objekt ID
     * Entfernt eine ID eines Objektes
     * @param object Objekt, dessen ID entfernt werden soll
     */
    public void removeObjectId(Object object) {
        if (!ObjectManager.objectExists(object)) {
            pluginbase.getLogHandler().sqlCustomError("Attaching: Object Id could not be deleted because it does not exist.", null);
        } else {
            MySQLAPI.update("INSERT INTO `LiquidObjects` (`Object`, `Id`) VALUES ('" + object + "','" + "0" + "');");
            pluginbase.getLogHandler().sqlInfo("Attaching: Object ID  was deleted.");
        }
    }

    /**
     * Setzen der Objekt ID
     * Setzt eine ID eines Objektes
     * @param object Objekt, dessen ID gesetzt werden soll
     * @param id ID, welche gesetzt werden soll
     */
    public void setObjectId(Object object, int id) {
        MySQLAPI.update("INSERT INTO `LiquidObjects` (`Object`, `Id`) VALUES ('" + object + "','" + id + "');");
        pluginbase.getLogHandler().sqlInfo("Attaching: Object ID successfully set.");
    }

}