package de.starvalcity.base.api.handling.player;

import de.starvalcity.base.Pluginbase;
import de.starvalcity.base.api.def.StarvalPlayer;
import de.starvalcity.base.api.def.database.MySQLAPI;
import de.starvalcity.base.api.handling.object.ObjectSQLManager;
import de.starvalcity.base.api.handling.object.ObjectSQLManager;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;

public class PlayerManager {

    private static Pluginbase pluginbase = new Pluginbase();

    /**
     * Creation: StarvalPlayer
     * <p>Creates a {@link StarvalPlayer} from a {@link Player} instance.</p>
     * @param player basic instance
     */
    public void createStarvalPlayer(@NotNull Player player) {
        int id = ObjectSQLManager.randomId();
        StarvalPlayer starvalPlayer = new StarvalPlayer(player, player.getName(), player.getUniqueId());

        starvalPlayer.setId(id);

        if (!ObjectSQLManager.objectExists(starvalPlayer) && !ObjectSQLManager.objectExists(player)) {
            ObjectSQLManager.attachObject(starvalPlayer.getPlayer());
            ObjectSQLManager.setObjectId(starvalPlayer.getPlayer(), id);

            pluginbase.getLogHandler().logWithLevel("Attaching > Player has been attached successfully.", Level.INFO);
            pluginbase.getLogHandler().logWithLevel("Attaching > Player Name: " + player.getName(), Level.INFO);
            pluginbase.getLogHandler().logWithLevel("Attaching > Player ID:" + starvalPlayer.getId(), Level.INFO);
        } else {
            pluginbase.getLogHandler().logWithLevel("Attaching > Player could not be attached.", Level.SEVERE);
            pluginbase.getLogHandler().logWithLevel("Attaching > Player already attached.", Level.SEVERE);
            pluginbase.getLogHandler().logWithLevel("Attaching > Player Name: " + player.getName(), Level.SEVERE);
            pluginbase.getLogHandler().logWithLevel("Attaching > Player ID:" + starvalPlayer.getId(), Level.SEVERE);
        }
    }

    public Player getPlayer(int id) {
        return (Player) ObjectSQLManager.getObject(id);
    }

}
