package de.starvalcity.base.api.handling;

import de.starvalcity.base.Core;
import de.starvalcity.base.api.def.StarvalPlayer;
import de.starvalcity.base.api.def.faction.Faction;

import java.util.HashMap;
import java.util.Map;

public class FactionManager {

    private final Core plugin;

    private final Map<Integer, Faction> factions = new HashMap<>();
    private final Map<Integer, StarvalPlayer> factionMembers = new HashMap<>();

    public FactionManager() {
        plugin = Core.getPlugin();
    }

    public void clearData() {
        factions.clear();
        factionMembers.clear();
    }

    public void importFaction(Faction faction) {
        this.factions.put(faction.getId(), faction);
    }

    public void createFaction(String name, int id, Faction.FactionType factionType, StarvalPlayer owner, double balance) {

    }
    
}
