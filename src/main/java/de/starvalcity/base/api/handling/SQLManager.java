package de.starvalcity.base.api.handling;

import de.starvalcity.base.Core;
import de.starvalcity.base.api.def.StarvalID;
import de.starvalcity.base.background.FileTask;
import de.starvalcity.base.background.def.CustomizedFile;
import de.starvalcity.base.background.log.LogHandler;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.UUID;

public class SQLManager implements Listener {

    private DatabaseManager databaseManager = new DatabaseManager();
    private JavaPlugin plugin = JavaPlugin.getPlugin(Core.class);

    public boolean playerIsAttached(UUID uuid) {
        try {
            PreparedStatement statement = databaseManager.getConnection().
                    prepareStatement("SELECT * FROM " + databaseManager.getPlayerTable() + " WHERE UUID=?");
            statement.setString(1, uuid.toString());

            ResultSet results = statement.executeQuery();
            if (results.next()) {
                System.out.println("Player found!");
                return true;
            }
            System.out.println("Player NOT found!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void attachPlayer(final UUID uuid, Player player) {
        try {
            PreparedStatement preparedStatement = databaseManager.getConnection().prepareStatement("SELECT * FROM " +
                    databaseManager.getPlayerTable() + " WHERE UUID=?");
            preparedStatement.setString(1, uuid.toString());
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            System.out.println(1);
            if (playerIsAttached(uuid) != true) {
                PreparedStatement insert = databaseManager.getConnection().prepareStatement("INSERT INTO " +
                        databaseManager.getPlayerTable() + " (UUID,NAME,FIRSTSEEN,LASTSEEN,RANK,LOCATION VALUES(?,?,?,?,?,?,?)");
                insert.setString(1, uuid.toString());
                insert.setString(2, player.getName());
                insert.setLong(3, (new Date().getTime()));
                insert.setString(4, null);
                insert.setString(5, player.getLocation().toString());
                insert.executeUpdate();
                System.out.println("Player inserted.");
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void setFirstSeen(UUID uuid) {
        try {
            PreparedStatement statement = databaseManager.getConnection()
                    .prepareStatement("UPDATE " + databaseManager.getPlayerTable() + " SET FIRSTSEEN=? WHERE UUID=?");
            statement.setLong(1, (new Date().getTime()));
            statement.setString(2, uuid.toString());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getFirstSeen(UUID uuid) {
        try {
            PreparedStatement preparedStatement = databaseManager.getConnection().
                    prepareStatement("SELECT * FROM " + databaseManager.getPlayerTable() + " WHERE UUID=?");
            preparedStatement.setString(1, uuid.toString());
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            System.out.println(resultSet.getLong("FIRSTSEEN"));
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
