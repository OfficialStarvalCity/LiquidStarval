package de.starvalcity.base.api.def.database;

import de.starvalcity.base.background.log.LogHandler;

import java.sql.*;

/**
 * {@link MySQLAPI}
 * <p>Die {@link MySQLAPI} ist die eigene <b>MySQL API</b> von StarvalCity.</p>
 */
public class MySQLAPI {

    private static LogHandler log = new LogHandler();

    public static String host = "univastro.net";
    public static String port = "3306";
    public static String database = "starvalcity_dev_liquidstarval";
    public static String username = "starvalcity_dev";
    public static String password = "KDLJ5WBNRO5GsjWD";

    public static DatabaseMetaData databaseMetaData;

    public static Connection connection;

    public static boolean isConnected() {
        return connection != null;
    }

    /**
     * Connection
     * Connects to the database through the given database parameters.
     */
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

    /**
     * Disconnection
     * Disconnects from the database.
     */
    public static void disconnect() {
        try {
            connection.close();
            log.sqlInfo("[Datenbank] MySQL Verbindung erfolgreich geschlossen.");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            log.sqlError(null, "MySQL Trennung der Verbindung fehlgeschlagen.", sqlException);
        }
    }

    /**
     * Statement Getter
     * Gets the {@link PreparedStatement} from {@link java.sql} from a SQL query.
     * @param sql query
     * @return PreparedStatement
     */
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

    /**
     * ResultSet Getter
     * Gets the {@link ResultSet} from {@link java.sql} from a SQL query.
     * @param sql query
     * @return ResultSet
     */
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

    /**
     * Update
     * Updates objects in the database.
     * @param query query
     * @return true / false
     */
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

    /**
     * Query Execution
     * Executes a query.
     * @param query query
     */
    public static void execute(String query) {
        try {
            getConnection().createStatement().execute(query);
        } catch (SQLException sqlException) {
            log.sqlError(query, "Query fehlgeschlagen.", sqlException);
        }
    }

    /**
     * ResultSet Query
     * Executes a ResultSet query.
     * @param query query
     * @return ResultSet
     */
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

    /**
     * Table Check
     * Checks whether a table exists or not.
     * @param table table to check
     * @return true / false
     */
    public static boolean existsTable(String table) {
        try {
            ResultSet tables = getConnection().getMetaData().getTables(null, null, table, null);
            return tables.next();
        } catch (SQLException sqlException) {
            log.sqlError(table, "Query fehlgeschlagen. Tabelle existiert nicht oder anderer Fehler.", sqlException);
            return false;
        }
    }

    /**
     * Column Check
     * Checks whether a column exists or not.
     * @param table table with the column
     * @param column column to check
     * @return true / false
     */
    public static boolean existsColumn(String table, String column) {
        try {
            ResultSet columns = getConnection().getMetaData().getColumns(null, null, table, column);
            return columns.next();
        } catch (Exception exception) {
            log.sqlError(table + column, "Query fehlgeschlagen. Tabelle oder Spalte existiert nicht oder anderer Fehler." , exception);
            return false;
        }
    }

    /**
     * Returns the {@link Connection} object from {@link java.sql}.
     *
     * @return SQL connection
     */
    public static Connection getConnection() {
        return connection;
    }

    /**
     * Returns the <b>host</b> of the database.
     *
     * @return host
     */
    public static String getHost() {
        return host;
    }

    /**
     * Returns the <b>port</b> of the database.
     *
     * @return port
     */
    public static String getPort() {
        return port;
    }

    /**
     * Returns the <b>database</b>.
     *
     * @return database
     */
    public static String getDatabase() {
        return database;
    }

    /**
     * Returns the <b>username</b> of the database.
     *
     * @return username
     */
    public static String getUsername() {
        return username;
    }

    /**
     * Returns the <b>password</b> of the database.
     *
     * @return password
     */
    public static String getPassword() {
        return password;
    }

    public static DatabaseMetaData getDatabaseMetaData() {
        return databaseMetaData;
    }
}
