package de.starvalcity.base.api.def.listening;

import de.starvalcity.base.Pluginbase;
import de.starvalcity.base.api.def.database.MySQLAPI;
import de.starvalcity.base.api.handling.SQLManager;
import de.starvalcity.base.api.handling.object.ObjectSQLManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.jetbrains.annotations.NotNull;

import java.util.logging.Level;

public class JoinListener implements Listener {

    private static Pluginbase pluginbase = new Pluginbase();

    @EventHandler
    public void onJoin(@NotNull PlayerJoinEvent event) {

    }


}