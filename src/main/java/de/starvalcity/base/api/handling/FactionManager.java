package de.starvalcity.base.api.handling;

import de.starvalcity.base.Core;
import de.starvalcity.base.api.def.StarvalPlayer;
import de.starvalcity.base.api.def.faction.Faction;
import de.starvalcity.base.background.def.Response;
import de.starvalcity.base.background.log.LogHandler;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FactionManager {

    private final Core plugin;
    private final LogHandler logHandler = new LogHandler();

    private final Map<Integer, Faction> factions = new HashMap<>();
    private final Map<Integer, List<StarvalPlayer>> factionMembers = new HashMap<>();
    private final List<StarvalPlayer> members = new ArrayList<>();

    public FactionManager() {
        plugin = Core.getPlugin();
    }

    public void clearData() {
        factions.clear();
        factionMembers.clear();
        members.clear();
        logHandler.factionLog("Der Fraktionsspeicher wurde entleert!", Response.GENERAL_SUCCESS);
    }

    public void importFaction(Faction faction) {
        this.factions.put(faction.getId(), faction);
        logHandler.factionLog("Die Fraktion" + faction.getId() + " wurde importiert!", Response.GENERAL_SUCCESS);
    }

    public void createFaction(String name, int id, Faction.FactionType factionType, @Nullable StarvalPlayer owner, double balance) {
        if (factions.containsKey(id)) {
            logHandler.factionLog("Die Fraktion " + name + "[ID " + id + "] konnte nicht erstellt werden!", Response.GENERAL_FAILURE);
        }
        if (!factions.containsKey(id)) {
            Faction faction = new Faction(name, id, factionType, owner, balance);
            factions.put(id, faction);
            logHandler.factionLog("Die Fraktion " + name + "[ID: " + id + "] wurde erstellt! ", Response.GENERAL_SUCCESS);
        }
    }

    public void deleteFaction(int id, @Nullable Faction faction) {
        if (factions.containsKey(id)) {
            factions.remove(id, faction);
            logHandler.factionLog("Die Fraktion " + id + " wurde entfernt!",
                    Response.GENERAL_SUCCESS);
        }
        if (!factions.containsKey(id)) {
            logHandler.factionLog("Die Fraktion " + id + " konnte nicht gelöscht werden!",
                    Response.GENERAL_FAILURE);
        }
    }



}
