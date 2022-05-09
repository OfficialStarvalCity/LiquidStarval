package de.starvalcity.handling.listening;

import de.starvalcity.handling.event.FirstJoinEvent;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class FirstJoinListener implements Listener {

    @EventHandler
    public void onFirstJoin(FirstJoinEvent firstJoinEvent) {
        Player newbie = firstJoinEvent.getNewbie();
    }
}
