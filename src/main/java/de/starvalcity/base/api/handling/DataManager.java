package de.starvalcity.base.api.handling;

import de.starvalcity.base.Pluginbase;
import de.starvalcity.base.api.def.StarvalPlayer;
import de.starvalcity.base.api.def.database.MySQLAPI;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Set;

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

    private Pluginbase plugin = new Pluginbase();

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
