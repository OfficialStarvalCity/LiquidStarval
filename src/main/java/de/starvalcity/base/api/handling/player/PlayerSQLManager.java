package de.starvalcity.base.api.handling.player;

import de.starvalcity.base.Pluginbase;
import de.starvalcity.base.api.def.database.MySQLAPI;
import de.starvalcity.base.api.handling.SQLManager;
import de.starvalcity.base.api.handling.object.ObjectSQLManager;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

/**
 * Der {@link PlayerSQLManager} sorgt für die Verwaltung der LiquidPlayers Datenbank-Tabelle.
 */
public class PlayerSQLManager {

    private static Pluginbase pluginbase = new Pluginbase();

    public void addToTable(@NotNull Player player) {
        int id = ObjectSQLManager.getObjectId(player);
        UUID uniqueId = player.getUniqueId();
        String name = player.getName();

        if (!playerExists(player.getUniqueId())) {
            if (ObjectSQLManager.objectExists(player)) {
                MySQLAPI.update("INSERT INTO `LiquidPlayers` (`ID`, `UUID`, `Name`) VALUES ('" + id + "','" + uniqueId + "','" + name + "');");
            }
        }
    }

    /**
     * Spieler ID Getter
     * <p>Gibt die ID des zugehörigen Spielers wieder.</p>
     * @param player Spieler der ID
     * @return ID aus der Datenbank
     */
    public static int getPlayerId(@NotNull Player player) {
        int id = 0;

        try {
            ResultSet resultSet = MySQLAPI.query("SELECT `ID` FROM `LiquidPlayers` WHERE `UUID` = \"" + player.getUniqueId() + "\";");

            while (resultSet.next()) {
                id = resultSet.getInt("ID");
            }
        } catch (SQLException sqlException) {
            pluginbase.getLogHandler().sqlLog("SELECT ID FROM LiquidPlayers WHERE Object = " + player.getUniqueId() + ";", sqlException);
        }
        return id;
    }

    /**
     * Spieler Name Getter
     * Gibt den Namen eines Spielers aus der Datenbank wieder.
     * @param id ID des Spielers aus der Datenbank.
     * @return Name des Spielers
     */
    public static String getPlayerName(int id) {
        String name = "";

        try {
            ResultSet resultSet = MySQLAPI.query("SELECT `Name` FROM `LiquidPlayers` WHERE `ID` = \"" + id + "\";");

            while (resultSet.next()) {
                name = resultSet.getString("Name");
            }
        } catch (SQLException sqlException) {
            pluginbase.getLogHandler().sqlLog("SELECT `Name` FROM `LiquidPlayers` WHERE `ID` = " + id + ";", sqlException);
        }
        return name;
    }


    /**
     * Exist Überprüfung
     * Überprüft, ob eine UUID bereits in der Datenbank existiert.
     * @param uniqueId UUID, welche geprüft werden soll
     * @return true / false
     */
    public static boolean playerExists(UUID uniqueId) {
        int iterator = 0;
        boolean exist = true;
        try {

            ResultSet rs = MySQLAPI.query("SELECT `UUID` FROM `LiquidObjects` WHERE `UUID` = " + uniqueId + ";");

            while (rs.next()) {
                iterator = rs.getInt("UUID");
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
