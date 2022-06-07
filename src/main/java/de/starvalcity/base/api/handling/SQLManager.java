package de.starvalcity.base.api.handling;

import de.starvalcity.base.Core;
import de.starvalcity.base.background.FileTask;
import de.starvalcity.base.background.def.CustomizedFile;
import de.starvalcity.base.background.log.LogHandler;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLManager {

    private CustomizedFile dbConfig = FileTask.customizedFiles.get(2);
    private DatabaseManager dbManager;
    private LogHandler logHandler;

    public ResultSet select(String query) {
        try {
            return dbManager.getConnection().createStatement().executeQuery(query);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            logHandler.sqlLog(query, sqlException);
        }
        return null;
    }

    public void insert(String query) {
        if (dbConfig.getObject("Use_Threads").equals(true)) {
            executeAsynchronously(query, "INSERT");
        } else {
            try {
                dbManager.getConnection().createStatement().executeUpdate(query);
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
                logHandler.sqlLog(query, sqlException);
            }
        }
    }

    public void update(String query) {
        if (dbConfig.getObject("Use_Threads").equals(true)) {
            executeAsynchronously(query, "UPDATE");
        } else {
            try {
                dbManager.getConnection().createStatement().executeUpdate(query);
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
                logHandler.sqlLog(query, sqlException);
            }
        }
    }

    public void delete(String query) {
        if (dbConfig.getObject("Use_Threads").equals(true)) {
            executeAsynchronously(query, "DELETE");
        } else {
            try {
                dbManager.getConnection().createStatement().executeUpdate(query);
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
                logHandler.sqlLog(query, sqlException);
            }
        }
    }

    public Boolean execute(String query) {
        try {
            dbManager.getConnection().createStatement().execute(query);
            return true;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            logHandler.sqlLog(query, sqlException);
            return false;
        }
    }

    public Boolean existsTable(String table) {
        try {
            ResultSet tables = dbManager.getConnection().getMetaData().getTables(null, null, table, null);
            return tables.next();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            logHandler.sqlLog(table, sqlException);
            return false;
        }
    }

    public Boolean existsColumn(String table, String column) {
        try {
            ResultSet col = dbManager.getConnection().getMetaData().getColumns(null, null, table, column);
            return col.next();
        } catch (Exception exception) {
            exception.printStackTrace();
            logHandler.sqlLog("[TABLE] " + table +  " | [COLUMN] " + column, exception);
            return false;
        }
    }

    public void executeAsynchronously(String query, String sqlType) {
        new BukkitRunnable() {
            @Override
            public void run() {
                try {
                    if (dbManager.getConnection() != null) {
                        dbManager.getConnection().createStatement().executeQuery(query);
                    }
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                    logHandler.sqlLog(query + " | [SQL TYPE] " + sqlType, sqlException);
                }
            }
        }.runTaskAsynchronously(JavaPlugin.getPlugin(Core.class));
    }
}
