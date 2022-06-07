package de.starvalcity.base.api.handling;

import de.starvalcity.base.api.def.StarvalPlayer;
import de.starvalcity.base.api.def.faction.Faction;
import de.starvalcity.base.background.log.LogHandler;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class StorageManager {

    private DatabaseManager dbManager;
    private LogHandler logHandler;
    private SQLManager sqlManager;

    public HashMap<Integer, Faction> integerFactionHashMap = new HashMap<>();
    public HashMap<Faction, List<StarvalPlayer>> factionPlayerHashMap = new HashMap<>();

    String scapCreationQuery = "CREATE TABLE IF NOT EXISTS `sc_attachedplayers` ";

    public void initializeDatabase() {
        if (!dbManager.isConnected()) {
            try {
                dbManager.connect();
            } catch (ClassNotFoundException | SQLException exception) {
                exception.printStackTrace();
            }
        } else {
            if (sqlManager.existsTable("sc_attachedplayers")) {
                logHandler.sqlInfo("Creating table: sc_attachedplayers");
                sqlManager.execute(scapCreationQuery);
            }
        }
    }

}
