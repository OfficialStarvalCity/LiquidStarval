package de.starvalcity.base.api.def;

import de.starvalcity.base.api.def.faction.Faction;

public interface FactionParticipator {

    boolean isInAFaction(StarvalPlayer starvalPlayer);

    boolean isFactionOwner(StarvalPlayer starvalPlayer);

    Faction getFaction(StarvalPlayer starvalPlayer);

    String getFactionString(StarvalPlayer starvalPlayer);

}
