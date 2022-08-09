package de.starvalcity.base.api.def.database;

import de.starvalcity.base.background.log.LogHandler;

import java.sql.*;

/**
 * {@link MySQLAPI}
 * <p>The {@link MySQLAPI} defines an API class which is used to register the main database of StarvalCity and its table.
 * It is also used to execute queries and statements within different MySQL tables.</p>
 */
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
                log.sqlInfo("MySQL Verbindung erfolgreich hergestellt.");
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
                log.sqlError(null, "MySQL Verbindung fehlgeschlagen.", sqlException);
            }
        }
    }

    public static void disconnect() {
        try {
            connection.close();
            log.sqlInfo("[Datenbank] MySQL Verbindung erfolgreich geschlossen.");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            log.sqlError(null, "MySQL Trennung der Verbindung fehlgeschlagen.", sqlException);
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
                log.sqlError(sql, "Statement fehlgeschlagen.", sqlException);
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
                log.sqlError(sql, "ResultSet fehlgeschlagen.", sqlException);
            }
        }
        return null;
    }

    public static boolean update(String query) {
        try {
            Statement st = connection.createStatement();
            st.executeUpdate(query);
            st.close();
            return true;
        } catch (SQLException sqlException) {
            log.sqlError(query, "Update fehlgeschlagen.", sqlException);
            return false;
        }
    }

    public static void execute(String query) {
        try {
            getConnection().createStatement().execute(query);
        } catch (SQLException sqlException) {
            log.sqlError(query, "Query fehlgeschlagen.", sqlException);
        }
    }

    public static ResultSet query(String query) {
        ResultSet rs = null;

        try {
            Statement st = connection.createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException sqlException) {
            log.sqlError(query, "Query fehlgeschlagen.", sqlException);
        }
        return rs;
    }

    public static boolean existsTable(String table) {
        try {
            ResultSet tables = getConnection().getMetaData().getTables(null, null, table, null);
            return tables.next();
        } catch (SQLException sqlException) {
            log.sqlError(table, "Query fehlgeschlagen. Tabelle existiert nicht oder anderer Fehler.", sqlException);
            return false;
        }
    }

    public static boolean existsColumn(String table, String column) {
        try {
            ResultSet columns = getConnection().getMetaData().getColumns(null, null, table, column);
            return columns.next();
        } catch (Exception exception) {
            log.sqlError(table + column, "Query fehlgeschlagen. Tabelle oder Spalte existiert nicht oder anderer Fehler." , exception);
            return false;
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
