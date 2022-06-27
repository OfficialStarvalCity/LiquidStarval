package de.starvalcity.base.api.def.database;

import de.starvalcity.base.background.log.LogHandler;
import org.bukkit.entity.Player;

import java.sql.*;

public class MySQLAPI {

    private static LogHandler log = new LogHandler();

    public static String host = "univastro.net";
    public static String port = "3306";
    public static String database = "starvalcity_dev_liquidstarval";
    public static String username = "starvalcity_dev";
    public static String password = "KDLJ5WBNRO5GsjWD";

    public static Connection connection;

    public static boolean isConnected() {
        return connection != null;
    }

    public static void connect() {
        if (!isConnected()) {
            try {
                connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database + "?autoReconnect=true",
                        username, password);
                log.sqlInfo("[Datenbank] MySQL Verbindung erfolgreich hergestellt.");
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
                log.sqlInfo("[Datenbank] MySQL Verbindung fehlgeschlagen. Exception: " + sqlException.getMessage());
            }
        }
    }

    public static void disconnect() {
        try {
            connection.close();
            log.sqlInfo("[Datenbank] MySQL Verbindung erfolgreich geschlossen.");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            log.sqlInfo("[Datenbank] MySQL Schließung fehlgeschlagen. Exception: " + sqlException.getMessage());
        }
    }

    public static PreparedStatement getStatement(String sql) {
        if (isConnected()) {
            PreparedStatement statement;
            try {
                statement = connection.prepareStatement(sql);
                return statement;
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
                log.sqlInfo("[Datenbank] MySQL Statement fehlgeschlagen. Exception: " + sqlException.getMessage());
            }
        }
        return null;
    }

    public static ResultSet getResult(String sql) {
        if (isConnected()) {
            PreparedStatement statement;
            ResultSet resultSet;
            try {
                statement = getStatement(sql);
                resultSet = statement.executeQuery();
                return resultSet;
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
                log.sqlInfo("[Datenbank] MySQL ResultSet fehlgeschlagen. Exception: " + sqlException.getMessage());
            }
        }
        return null;
    }

    public static void createTable() {

    }

    public static void attachPlayer(Player player) {
        if (!player.hasPlayedBefore()) {

        }
    }

}
