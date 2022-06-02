package de.starvalcity.base.api.handling;

import de.starvalcity.base.api.def.StarvalID;
import de.starvalcity.base.api.def.StarvalPlayer;
import de.starvalcity.base.api.def.faction.Faction;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerManager {

    private final Map<UUID, Player> playerUniqueIds = new HashMap<>();
    private final Map<StarvalID, StarvalPlayer> playerStarvalIds = new HashMap<>();

    private final Map<StarvalID, Double> playerBalances = new HashMap<>();
    private final Map<StarvalID, Faction> playerFactions = new HashMap<>();



}
