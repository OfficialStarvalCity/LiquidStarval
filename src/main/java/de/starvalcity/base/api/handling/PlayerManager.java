package de.starvalcity.base.api.handling;

import de.starvalcity.base.Pluginbase;
import de.starvalcity.base.api.def.StarvalPlayer;
import de.starvalcity.base.api.def.database.MySQLAPI;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

/**
 * Der {@link PlayerManager} sorgt für die Verwaltung von allen Spieler-Instanzen auf dem Server.
 */
public class PlayerManager {

    private static Pluginbase pluginbase = new Pluginbase();

    public void attachStarvalPlayer(@NotNull StarvalPlayer starvalPlayer) {
        UUID uniqueId = starvalPlayer.getUniqueId();
        int id = SQLManager.getObjectId(starvalPlayer);
        String name = starvalPlayer.getName();
        SQLManager.attachObject(starvalPlayer.getPlayer());
        if (!playerExists(uniqueId)) {
            MySQLAPI.update("INSERT INTO `LiquidPlayers` (`UUID`, `Id`, `Playername`, `FirstSeen`) VALUES (' " +
                    uniqueId + "','" + id + "','" + name + "','" + System.currentTimeMillis() + "');");
            pluginbase.getLogHandler().sqlInfo("Attaching: Player successfully attached and saved to database.");
        } else {
            pluginbase.getLogHandler().sqlCustomError("Attaching: Player already attached.", null);
        }
    }

    public void attachPlayer(@NotNull Player player) {
        UUID uniqueId = player.getUniqueId();
        int id = SQLManager.getObjectId(player);
        String name = player.getName();
        SQLManager.attachObject(player.getPlayer());
        if (!playerExists(uniqueId)) {
            MySQLAPI.update("INSERT INTO `LiquidPlayers` (`UUID`, `Id`, `Playername`, `FirstSeen`) VALUES (' " +
                    uniqueId + "','" + id + "','" + name + "','" + System.currentTimeMillis() + "');");
            pluginbase.getLogHandler().sqlInfo("Attaching: Player successfully attached and saved to database.");
        } else {
            pluginbase.getLogHandler().sqlCustomError("Attaching: Player already attached.", null);
        }
    }

    public void unattachStarvalPlayer(@NotNull StarvalPlayer starvalPlayer) {
        UUID uniqueId = starvalPlayer.getUniqueId();
        int id = SQLManager.getObjectId(starvalPlayer);
        String name = starvalPlayer.getName();
        SQLManager.unattachObject(starvalPlayer);
        if (playerExists(uniqueId)) {
            MySQLAPI.update("DELETE FROM `LiquidPlayers` WHERE `UUID` = \"" + uniqueId + "\";");
        } else {
            pluginbase.getLogHandler().sqlCustomError("Attaching: Player could not be deleted because it does not exist.", null);
        }
    }

    public void unattachPlayer(@NotNull Player player) {
        UUID uniqueId = player.getUniqueId();
        int id = SQLManager.getObjectId(player);
        String name = player.getName();
        SQLManager.unattachObject(player);
        if (playerExists(uniqueId)) {
            MySQLAPI.update("DELETE FROM `LiquidPlayers` WHERE `UUID` = \"" + uniqueId + "\";");
        } else {
            pluginbase.getLogHandler().sqlCustomError("Attaching: Player could not be deleted because it does not exist.", null);
        }
    }

    public boolean playerExists(UUID uniqueId) {
        ResultSet resultSet = MySQLAPI.query("SELECT `UUID` FROM `LiquidPlayers` WHERE `UUID` = \"" + uniqueId + "\";");
        try {
            return resultSet.next();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return false;
    }

}
