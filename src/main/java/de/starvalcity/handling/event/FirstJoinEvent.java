package de.starvalcity.handling.event;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class FirstJoinEvent extends Event {

    private static final HandlerList handlerList = new HandlerList();

    private Player newbie;

    public FirstJoinEvent(Player newbie) {

    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }

    public Player getNewbie() {
        return newbie;
    }

     public String getNewbieName() {
        return newbie.getName();
     }
}
