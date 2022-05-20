package de.starvalcity.base.api.def;

import org.bukkit.entity.Player;

import java.util.UUID;

public abstract class StarvalPlayer implements EconomyParticipator {

    public Player player;
    public String name;
    public UUID uniqueId;
    public long firstJoin;
    public long lastSeen;

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUniqueId(UUID uniqueId) {
        this.uniqueId = uniqueId;
    }

    public void setFirstJoin() {
        this.firstJoin = System.currentTimeMillis();
    }

    public void setLastSeen() {
        this.lastSeen = System.currentTimeMillis();
    }

}
