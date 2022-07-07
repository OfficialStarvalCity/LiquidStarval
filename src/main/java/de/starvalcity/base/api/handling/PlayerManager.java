package de.starvalcity.base.api.handling;

import de.starvalcity.base.api.def.database.MySQLAPI;
import org.bukkit.entity.Player;

import java.util.UUID;

public class PlayerManager {

    private InstanceManager instanceManager = new InstanceManager();

    public void attachPlayer(Player player) {
        UUID playerUniqueId = player.getUniqueId();
        int playerId = instanceManager.getId(player);
        String playerName = player.getName();
        long firstSeen = System.currentTimeMillis();
        MySQLAPI.update("INSERT INTO `sc_players`" +
                "(`UUID`, `Id`, `Playername`, `FirstSeen`, `LastSeen`, `IP`, `Playtime`, `Rank`, `Faction`, `FactionRank`) " +
                "VALUES ('" +
                playerUniqueId +
                "','" + playerId +
                "','" + playerName +
                "','" + firstSeen +
                "','" + null  +
                "','" + player.getAddress() +
                "','" + "Spieler" +
                "','" + "Zivilisten" +
                "','" + "Mitglied')");
    }

}
