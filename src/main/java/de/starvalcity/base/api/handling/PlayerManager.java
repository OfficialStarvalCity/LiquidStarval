package de.starvalcity.base.api.handling;

import de.starvalcity.base.api.def.database.MySQLAPI;
import org.bukkit.entity.Player;

import java.util.UUID;

public class PlayerManager {

    public void attachPlayer(Player player) {
        UUID playerUniqueId = player.getUniqueId();
        int playerId = InstanceManager.randomId();
        String playerName = player.getName();
        long firstSeen = System.currentTimeMillis();
        MySQLAPI.update("INSERT INTO `sc_players`" +
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
                "','" + "Mitglied')");
        MySQLAPI.update("INSERT INTO `sc_ids` (`Instance`, `Id`) VALUES ('" +
                playerUniqueId +
                "','" + playerId + "');");
    }

}
