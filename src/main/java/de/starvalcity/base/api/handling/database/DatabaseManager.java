package de.starvalcity.base.api.handling.database;

import de.starvalcity.base.Core;
import de.starvalcity.base.background.def.CustomizedFile;
import org.bukkit.scheduler.BukkitRunnable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseManager {

    private Connection connection;
    private final String host;
    private final String username;
    private final String password;
    private final String database;
    private final int port;

    private final CustomizedFile databaseConfiguration = new CustomizedFile("plugins//Liquid//Configuration", "DatabaseConfiguration.yml");

    public DatabaseManager(String host, String username, String password, String database, int port) {
        this.host = host;
        this.username = username;
        this.password = password;
        this.database = database;
        this.port = port;
    }

    private void setup() {
        try {
            Class.forName("com.mysql.jdbc.driver");
            connection = DriverManager.getConnection("jdbc:mysql://" + host +
                    ":" + port +
                    "/" + database +
                    "?useUnicode=true&characterEncoding=utf-8&autoReconnect=true", username, password);
            createDefaultFiles();
        } catch (ClassNotFoundException | SQLException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }
    }

    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed() || connection.isValid(0)) {
                setup();
            }
        } catch (SQLException sqlException) {
            setup();
        }
        return connection;
    }

    public boolean checkConnection() {
        return getConnection() != null;
    }

    public void close() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public ResultSet select(String query) {
        try {
            return getConnection().createStatement().executeQuery(query);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }

    public void insert(String query) {
        if (databaseConfiguration.getObject("Use_Threads").equals(true)) {
            executeAsynchronously(query, "INSERT");
        } else {
            try {
                getConnection().createStatement().executeUpdate(query);
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
    }

    public void update(String query) {
        if (databaseConfiguration.getObject("Use_Threads").equals(true)) {
            executeAsynchronously(query, "UPDATE");
        } else {
            try {
                getConnection().createStatement().executeUpdate(query);
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
    }

    public void delete(String query) {
        if (databaseConfiguration.getObject("Use_Threads").equals(true)) {
            executeAsynchronously(query, "DELETE");
        } else {
            try {
                getConnection().createStatement().executeUpdate(query);
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
    }

    public boolean execute(String query) {
        try {
            getConnection().createStatement().execute(query);
            return true;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return false;
        }
    }

    public boolean tableExists(String table) {
        try {
            ResultSet tables = getConnection().getMetaData().getTables(null, null, table, null);
            return tables.next();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return false;
        }
    }

    public boolean columnExists(String table, String column) {
        try {
            ResultSet columns = getConnection().getMetaData().getColumns(null, null, table, column);
            return columns.next();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return false;
        }
    }

    private void executeAsynchronously(String query, String sqlType) {
        new BukkitRunnable() {
            @Override
            public void run() {
                try {
                    if (getConnection() != null) {
                        getConnection().createStatement().executeUpdate(query);
                    }
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }
        }.runTaskAsynchronously(Core.getPlugin());
    }

    private void createDefaultFiles() {
        if (!databaseConfiguration.exist()) {
            databaseConfiguration.setDefaultValue("Use_Threads", true);
            databaseConfiguration.save();
        }
        databaseConfiguration.save();
    }
}
