package de.starvalcity.base.api.handling;

import de.starvalcity.base.Core;
import de.starvalcity.base.api.def.StarvalPlayer;
import de.starvalcity.base.api.def.faction.Faction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FactionManager {

    private final Core plugin;

    private final Map<Integer, Faction> factions = new HashMap<>();
    private final Map<Integer, List<StarvalPlayer>> factionMembers = new HashMap<>();
    private final List<StarvalPlayer> members = new ArrayList<>();

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
        if (factions.containsKey(id)) {

        }
    }


    
}
