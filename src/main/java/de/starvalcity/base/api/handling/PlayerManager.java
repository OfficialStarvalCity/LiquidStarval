package de.starvalcity.base.api.handling;


import de.starvalcity.base.api.def.StarvalID;
import de.starvalcity.base.api.def.StarvalPlayer;
import de.starvalcity.base.background.log.LogHandler;
import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PlayerManager {

    private DatabaseManager dbManager;
    private LogHandler logHandler;
    private SQLManager sqlManager;
    private StorageManager storageManager;

    String attachPlayerQuery = "INSERT IGNORE INFO sc_players (NAME,UUID) VALUES (?,?)";

    public void attachPlayer(Player player) {
        try {
            if (dbManager.isConnected()) {
                if (sqlManager.existsTable("sc_players")) {
                    if (!sqlManager.existsObject("sc_players", "Name", player.getName())) {
                        PreparedStatement preparedStatement = dbManager.getConnection().prepareStatement(attachPlayerQuery);
                        StarvalID starvalID = StarvalID.randomID();
                        StarvalPlayer starvalPlayer = new StarvalPlayer(player, player.getName(), player.getUniqueId(), starvalID);
                        preparedStatement.setString(1, player.getName());
                        preparedStatement.setString(2, player.getUniqueId().toString());
                        preparedStatement.executeUpdate();
                        storageManager.
                        return;
                    }
                }
            }
        } catch (SQLException sqlException) {
            logHandler.sqlLog(attachPlayerQuery, sqlException);
        }
    }

}
