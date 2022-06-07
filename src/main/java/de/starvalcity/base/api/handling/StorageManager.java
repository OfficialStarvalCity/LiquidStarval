package de.starvalcity.base.api.handling;

import de.starvalcity.base.Pluginbase;
import de.starvalcity.base.api.def.StarvalPlayer;
import de.starvalcity.base.api.def.faction.Faction;
import de.starvalcity.base.background.log.LogHandler;

import java.util.HashMap;
import java.util.List;

public class StorageManager {

    private Pluginbase pluginbase = new Pluginbase();

    public HashMap<Integer, Faction> integerFactionHashMap = new HashMap<>();
    public HashMap<Faction, List<StarvalPlayer>> factionPlayerHashMap = new HashMap<>();

}
