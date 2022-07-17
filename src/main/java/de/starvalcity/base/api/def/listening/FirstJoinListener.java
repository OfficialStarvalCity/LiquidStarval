package de.starvalcity.base.api.def.listening;

import de.starvalcity.base.Pluginbase;
import de.starvalcity.base.api.def.StarvalPlayer;
import de.starvalcity.base.api.def.event.PlayerFirstJoinEvent;
import de.starvalcity.base.api.handling.ObjectManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class FirstJoinListener implements Listener {

    private static Pluginbase plugin = new Pluginbase();

    @EventHandler
    public void onFirstJoin(PlayerFirstJoinEvent firstJoinEvent) {
        Player newbie = firstJoinEvent.getPlayer();
        StarvalPlayer starvalPlayer = new StarvalPlayer(newbie, newbie.getName(), newbie.getUniqueId());
        if (!newbie.hasPlayedBefore()) {
            plugin.getObjectManager().attachObject(newbie);
            plugin.getPlayerManager().attachPlayer(starvalPlayer);
            starvalPlayer.setId(ObjectManager.getObjectId(starvalPlayer));
        }
    }
}
