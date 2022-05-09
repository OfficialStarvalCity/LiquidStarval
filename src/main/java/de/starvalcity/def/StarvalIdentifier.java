package de.starvalcity.def;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.UUID;

public class StarvalIdentifier {

    private final int length;
    private final char capital;

    private final HashMap<UUID, StarvalIdentifier> starvalIdentifiers = new HashMap<>();

    public StarvalIdentifier(@NotNull Player related, int length, char capital) {
        this.length = length;
        this.capital = capital;
        int playerNameLength = related.getName().length();
        starvalIdentifiers.put(related.getUniqueId(), this);
    }

    public int getLength() {
        return length;
    }

    public char getCapital() {
        return capital;
    }


    public HashMap<UUID, StarvalIdentifier> getStarvalIdentifiers() {
        return starvalIdentifiers;
    }
}
