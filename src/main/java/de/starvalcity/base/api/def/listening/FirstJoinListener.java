package de.starvalcity.base.api.def.listening;

import de.starvalcity.base.api.def.event.PlayerFirstJoinEvent;
import de.starvalcity.base.api.handling.PlayerManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class FirstJoinListener implements Listener {

    private PlayerManager playerManager;

    @EventHandler
    public void onFirstJoin(PlayerFirstJoinEvent playerFirstJoinEvent) {
        Player player = playerFirstJoinEvent.getPlayer();
        if (!player.hasPlayedBefore()) {
            playerManager.attachPlayer(player);
        }
    }
}
