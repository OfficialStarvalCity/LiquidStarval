package de.starvalcity.base.api.handling.database;

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

    }
}
