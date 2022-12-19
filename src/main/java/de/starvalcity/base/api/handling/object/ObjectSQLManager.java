package de.starvalcity.base.api.handling.object;

import de.starvalcity.base.Pluginbase;
import de.starvalcity.base.api.def.TableHandler;
import de.starvalcity.base.api.def.database.MySQLAPI;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

/**
 * Der {@link ObjectSQLManager} sorgt für die Verwaltung der Objekte Datenbank-Tabelle.
 */
public class ObjectSQLManager extends TableHandler {

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
            ResultSet resultSet = MySQLAPI.query("SELECT `ID` FROM `Objekte` WHERE `Objekt` = \"" + object + "\";");

            while (resultSet.next()) {
                id = resultSet.getInt("ID");
            }
        } catch (SQLException sqlException) {
            pluginbase.getLogHandler().sqlLog("SELECT ID FROM Objekte WHERE Objekt = " + object + ";", sqlException);
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
            ResultSet resultSet = MySQLAPI.query("SELECT `Objekt` FROM `Objekte` WHERE `ID` = \"" + id + "\";");

            while (resultSet.next()) {
                name = resultSet.getString("Objekt");
            }
        } catch (SQLException sqlException) {
            pluginbase.getLogHandler().sqlLog("SELECT `Objekt` FROM `Objekte` WHERE `ID` = " + id + ";", sqlException);
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
            ResultSet resultSet = MySQLAPI.query("SELECT `Objekt` FROM `Objekte` WHERE `ID` = \"" + id + "\";");

            while (resultSet.next()) {
                object = resultSet.getObject("Objekt");
            }
        } catch (SQLException sqlException) {
            pluginbase.getLogHandler().sqlLog("SELECT Instance FROM Objekte WHERE ID = " + id + ";", sqlException);
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

            ResultSet rs = MySQLAPI.query("SELECT `ID` FROM `Objekte` WHERE `ID` = " + id + ";");

            while (rs.next()) {
                iterator = rs.getInt("ID");
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        if(!(iterator > 0)) {
            exist = false;
        }
        return exist;
    }

    /**
     * Exist Überprüfung II
     * Überrprüft, ob ein Objekt bereits in der Datenbank existiert.
     * @param object Objekt, welches geprüft werden soll
     * @return true / false
     */
    public static boolean objectExists(Object object) {
        ResultSet resultSet = MySQLAPI.query("SELECT `Objekt` FROM `Objekte` WHERE `Objekt` = \"" + object + "\";");
        try {
            return resultSet.next();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return false;
    }

    /**
     * Zufällige ID Generation
     * Generiert eine zufällige ID aus einem Integer.
     * @return generierte ID
     */
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
    public static void attachObject(Object object) {
        int objectId = randomId();
        if (!idExists(objectId)) {
            if (!objectExists(object)) {
                MySQLAPI.update("INSERT INTO `Objekte` (`Objekt`, `ID`) VALUES ('" + object + "','" + objectId + "');");
                pluginbase.getLogHandler().sqlInfo("Registrierung: Objekt erfolgreich in der Datenbank registriert.");
            } else {
                pluginbase.getLogHandler().sqlCustomError("Registrierung: Objekt bereits in der Datenbank registriert.", null);
            }
        } else {
            pluginbase.getLogHandler().sqlCustomError("DB-Registrierung: Objekt bereits in der Datenbank registriert.", null);
        }
    }

    /**
     * Object Datenbankspeicherung
     * Speichert ein Objekt mit einer benutzerdefinierten ID in der Datenbank.
     * @param object Objekt, welches hinzugefügt werden soll
     * @param id ID des Objektes
     */
    public static void attachObjectWithId(Object object, int id) {
        if (!idExists(id)) {
            if (!objectExists(object)) {
                MySQLAPI.update("INSERT INTO `Objekte` (`Objekt`, `ID`) VALUES ('" + object + "','" + id + "');");
                pluginbase.getLogHandler().sqlInfo("Registrierung: Objekt erfolgreich in der Datenbank registriert.");
            } else {
                pluginbase.getLogHandler().sqlCustomError("Registrierung: Objekt bereits in der Datenbank registriert.", null);
            }
        } else {
            pluginbase.getLogHandler().sqlCustomError("DB-Registrierung: Objekt bereits in der Datenbank registriert.", null);
        }
    }

    /**
     * Objekt Datenbankentfernung
     * Entfernt ein Objekt aus der Datenbank.
     * @param object Objekt, welcher aus der Datenbank entfernt werden soll
     */
    public static void unattachObject(Object object) {
        int objectId = getObjectId(object);
        if (!objectExists(object)) {
            pluginbase.getLogHandler().sqlCustomError("Registrierung: Objekt nicht in der Datenbank registriert.", null);
        } else {
            MySQLAPI.update("DELETE FROM `Objekte` WHERE `Objekt` = \"" + object + "\";");
            pluginbase.getLogHandler().sqlInfo("DB-Entfernung: Objekt erfolgreich aus der Datenbank entfernt.");
        }
    }

    /**
     * Entfernung der Objekt ID
     * Entfernt eine ID eines Objektes
     * @param object Objekt, dessen ID entfernt werden soll
     */
    public static void removeObjectId(Object object) {
        if (!objectExists(object)) {
            pluginbase.getLogHandler().sqlCustomError("Registrierung: Objekt-ID nicht in der Datenbank registriert.", null);
        } else {
            MySQLAPI.update("INSERT INTO `Objekte` (`Objekt`, `ID`) VALUES ('" + object + "','" + "0" + "');");
            pluginbase.getLogHandler().sqlInfo("DB-Entfernung: Objekt-ID erfolgreich aus der Datenbank entfernt.");
        }
    }

    /**
     * Setzen der Objekt ID
     * Setzt eine ID eines Objektes
     * @param object Objekt, dessen ID gesetzt werden soll
     * @param id ID, welche gesetzt werden soll
     */
    public static void setObjectId(Object object, int id) {
        MySQLAPI.update("INSERT INTO `Objekte` (`Objekt`, `ID`) VALUES ('" + object + "','" + id + "');");
        pluginbase.getLogHandler().sqlInfo("DB-Registrierung: Objekt-ID erfolgreich für Objekt in der Datenbank gesetzt.");
    }

}
