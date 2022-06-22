package de.starvalcity.base.api.def.economy;

import de.starvalcity.base.api.def.database.MySQLAPI;
import de.starvalcity.base.background.log.LogHandler;
import org.bukkit.entity.Player;

import java.sql.PreparedStatement;

public class EconomyAPI {

    private static LogHandler log = new LogHandler();

    public static void createTable() {
        try {
            PreparedStatement statement = MySQLAPI.getStatement(
                    "CREATE TABLE IF NOT EXISTS sc_economy (Spielername VARCHAR(100), UUID VARCHAR(100), Kontostand INT(100)");
            statement.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
            log.sqlInfo("[MySQL] Fehler beim Erstellen der Tabelle 'sc_economy'. Exception: " + exception.getMessage());
        }
    }

    public static void attachPlayer(Player player) {
        try {

        }
    }

}
