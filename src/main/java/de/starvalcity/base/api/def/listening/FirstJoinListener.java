package de.starvalcity.base.api.def.listening;

import de.starvalcity.base.Pluginbase;
import de.starvalcity.base.api.def.event.PlayerFirstJoinEvent;
import de.starvalcity.base.api.handling.InstanceManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class FirstJoinListener implements Listener {

    private Pluginbase plugin = new Pluginbase();

    @EventHandler
    public void onFirstJoin(PlayerFirstJoinEvent firstJoinEvent) {
        Player newbie = firstJoinEvent.getPlayer();
        if (!newbie.hasPlayedBefore()) {
            plugin.getDataManager().attachPlayer(newbie);
        }
    }
}
