package de.starvalcity.base.api.handling;

import de.starvalcity.base.api.def.StarvalID;
import de.starvalcity.base.api.def.StarvalPlayer;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerManager {

    private final Map<UUID, StarvalPlayer> playerUniqueIds = new HashMap<>();
    private final Map<StarvalID, StarvalPlayer> playerStarvalIds = new HashMap<>();

}
