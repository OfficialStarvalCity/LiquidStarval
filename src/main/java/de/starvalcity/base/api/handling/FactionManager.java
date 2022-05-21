package de.starvalcity.base.api.handling;

import de.starvalcity.base.api.def.StarvalPlayer;
import de.starvalcity.base.api.def.faction.Faction;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FactionManager {

    private final Map<Integer, Faction> factions = new HashMap<>();
    private final Map<Integer, StarvalPlayer> factionOwners = new HashMap<>();
    private final Map<Integer, List<StarvalPlayer>> factionMembers = new HashMap<>();

    public void createFaction(int id,
                              String name,
                              Faction.FactionType factionType,
                              @Nullable StarvalPlayer owner,
                              @Nullable List<StarvalPlayer> members,
                              double balance) {
        Faction newFaction = new Faction(name, id, factionType, owner, members, balance);
        factions.put(id, newFaction);
        factionOwners.put(id, owner);
        factionMembers.put(id, members);
    }

    
}
