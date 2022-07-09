package de.starvalcity.base.api.handling;

import de.starvalcity.base.Pluginbase;
import de.starvalcity.base.api.def.database.MySQLAPI;
import org.bukkit.entity.Player;

import java.sql.SQLException;
import java.util.UUID;

public class PlayerManager {

    private static Pluginbase pluginbase = new Pluginbase();

    /**
     * Spieler Datenbankübertragung
     * Speichert eine zufällig generierte ID eines Spielers in die Datenbank.
     * @param player Spieler, welcher hinzugefügt werden soll
     */
    public void attachPlayer(Player player) {
        UUID playerUniqueId = player.getUniqueId();
        int playerId = InstanceManager.randomId();
        String playerName = player.getName();
        long firstSeen = System.currentTimeMillis();
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
        if (!instanceIdExists(playerId)) {
            if (!instanceExists(playerUniqueId)) {
                MySQLAPI.update("INSERT INTO `sc_ids` (`Instance`, `Id`) VALUES ('" + playerUniqueId + "','" + playerId + "');");
            } else {
                pluginbase.getLogHandler().sqlCustomError("Instance already attached.", null);
            }
        } else {
            pluginbase.getLogHandler().sqlCustomError("Instance already attached.", null);
        }

    }

    public boolean instanceIdExists(int id) {
        return InstanceManager.idExists(id);
    }

    public boolean instanceExists(Object instance) {
        return InstanceManager.instanceExists(instance);
    }
}
