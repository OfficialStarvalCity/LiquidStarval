package de.starvalcity.base.api.handling.player;

import de.starvalcity.base.Pluginbase;
import de.starvalcity.base.api.def.StarvalPlayer;
import de.starvalcity.base.api.handling.object.ObjectSQLManager;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.logging.Level;

/**
 * Der {@link PlayerManager} sorgt für die Verwaltung aller Spieler-Instanzen auf dem Server und unter anderem für die
 * Erstellung und Speicherung der {@link StarvalPlayer} Instanz.
 */
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

        if (!ObjectSQLManager.objectExists(player)) {

            ObjectSQLManager.attachObject(starvalPlayer.getPlayer());
            pluginbase.getPlayerSQLManager().addToTable(player);

            pluginbase.getLogHandler().logWithLevel("DB-Registrierung > Spieler erfolgreich in der Datenbank registriert.", Level.INFO);
            pluginbase.getLogHandler().logWithLevel("DB-Registrierung > Spielername: " + player.getName(), Level.INFO);
            pluginbase.getLogHandler().logWithLevel("DB-Registrierung > Spieler-ID: " + starvalPlayer.getId(), Level.INFO);
        } else {
            pluginbase.getLogHandler().logWithLevel("DB-Entfernung > Spieler konnte nicht in der Datenbank registriert werden.", Level.SEVERE);
            pluginbase.getLogHandler().logWithLevel("DB-Entfernung > Spieler bereits in der Datenbank registriert.", Level.SEVERE);
            pluginbase.getLogHandler().logWithLevel("DB-Entfernung > Spielername: " + player.getName(), Level.SEVERE);
            pluginbase.getLogHandler().logWithLevel("DB-Entfernung > Spieler-ID: " + starvalPlayer.getId(), Level.SEVERE);
        }
    }

    public void deleteStarvalPlayer(@NotNull Player player) {
        int id = ObjectSQLManager.getObjectId(player);

        if (ObjectSQLManager.objectExists(player)) {

            ObjectSQLManager.unattachObject(player);
            pluginbase.getPlayerSQLManager().removeFromTable(player);

            pluginbase.getLogHandler().logWithLevel("DB-Registrierung > Spieler erfolgreich aus der Datenbank entfernt.", Level.INFO);
            pluginbase.getLogHandler().logWithLevel("DB-Registrierung > Spielername: " + player.getName(), Level.INFO);
            pluginbase.getLogHandler().logWithLevel("DB-Registrierung > Spieler-ID: " + id, Level.INFO);
        } else {
            pluginbase.getLogHandler().logWithLevel("DB-Entfernung > Spieler konnte nicht aus der Datenbank entfernt werden.", Level.SEVERE);
            pluginbase.getLogHandler().logWithLevel("DB-Entfernung > Spieler nicht in der Datenbank registriert.", Level.SEVERE);
            pluginbase.getLogHandler().logWithLevel("DB-Entfernung > Spielername: " + player.getName(), Level.SEVERE);
            pluginbase.getLogHandler().logWithLevel("DB-Entfernung > Spieler-ID:" + id, Level.SEVERE);
        }
    }

    public Player getPlayer(int id) {
        return (Player) ObjectSQLManager.getObject(id);
    }

}
