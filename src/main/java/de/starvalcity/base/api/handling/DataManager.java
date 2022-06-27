package de.starvalcity.base.api.handling;

import de.starvalcity.base.api.def.StarvalPlayer;
import org.bukkit.entity.Player;

import java.util.HashMap;

/**
 * Data Manager
 * Der {@link DataManager} sorgt für die interne Datenübertragung innerhalb von Datenstrukturen der folgenden Strukturen:
 *  - Arrays, ArrayLists, Lists, LinkedLists
 *  - HashMaps, HashSets, TreeMaps
 *  - Multidimensionale Datenstrukturen
 *
 *  Datenbankfunktionen befinden sich im {@link DatabaseManager} bzw. im {@link SQLManager}.
 */
public class DataManager {

    private HashMap<Player, StarvalPlayer> attachedPlayers = new HashMap<>();

    public void attachPlayer(Player player) {
        if (!player.hasPlayedBefore()) {
            StarvalPlayer starvalPlayer = new StarvalPlayer(player, player.getName(), player.getUniqueId());
            attachedPlayers.put(player, starvalPlayer);
        }
    }

    public StarvalPlayer getStarvalPlayer(Player player) {
        return attachedPlayers.get(player);
    }
}
