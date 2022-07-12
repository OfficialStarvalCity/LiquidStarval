package de.starvalcity.base.api.def.listening;

import de.starvalcity.base.Pluginbase;
import de.starvalcity.base.api.def.event.PlayerFirstJoinEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.sql.SQLException;

public class FirstJoinListener implements Listener {

    private Pluginbase plugin = new Pluginbase();

    @EventHandler
    public void onFirstJoin(PlayerFirstJoinEvent firstJoinEvent) {
        Player newbie = firstJoinEvent.getPlayer();
        if (!newbie.hasPlayedBefore()) {
            plugin.getObjectManager().attachObject(newbie);
        }
    }
}
