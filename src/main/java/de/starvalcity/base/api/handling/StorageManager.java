package de.starvalcity.base.api.handling;

import de.starvalcity.base.Pluginbase;
import de.starvalcity.base.api.def.StarvalID;
import de.starvalcity.base.api.def.StarvalPlayer;
import de.starvalcity.base.api.def.faction.Faction;
import de.starvalcity.base.background.log.LogHandler;

import java.util.HashMap;
import java.util.List;

/**
 * Der StorageManager sorgt für die interne Übertragung von Daten innerhalb von Datenstrukturen. Datenübertragungen,
 * welche über Datenbanken erfolgen, werden in jedem Plugin jeweils einzeln programmiert und nicht im StorageManager.
 *
 * Ausnahmen dafür sind essenzielle Features:
 *  - Economy System (Bankkonten, Spielerkonten, ...)
 *  - Player System (UUIDs, StarvalIDs, StarvalIPs, ...)
 */
public class StorageManager {

    private Pluginbase pluginbase = new Pluginbase();

    // Datenstrukturen
    /**
     * Datenstrukturen (Arrays, HashMaps, Lists, TreeMaps) werden als interne Speicheroption genutzt, als
     * sogenannte Zwischenablage, um ein Backup im Hintergrund laufen zu haben.
     */
    public HashMap<StarvalID, StarvalPlayer> idStarvalPlayerHashMap = new HashMap<>();

    public HashMap<Integer, Faction> integerFactionHashMap = new HashMap<>();
    public HashMap<Faction, List<StarvalPlayer>> factionPlayerHashMap = new HashMap<>();

    public void addPlayer(StarvalID starvalID, StarvalPlayer starvalPlayer) {
        idStarvalPlayerHashMap.put(starvalID, starvalPlayer);
    }

}
