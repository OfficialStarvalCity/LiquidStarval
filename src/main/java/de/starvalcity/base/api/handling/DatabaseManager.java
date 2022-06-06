package de.starvalcity.base.api.handling;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {

   private String host = "univastro.net";
   private String user = "starvalcity_dev";
   private String password = "KDLJ5WBNRO5GsjWD";
   private String database = "starvalcity_dev_liquid";
   private String port = "3306";

   private Connection connection;

   public boolean isConnected() {
       return (connection == null ? true : false);
   }

   public void connect() throws ClassNotFoundException, SQLException {
       if (!isConnected()) {
           connection = DriverManager.getConnection("jdbc:mysql://" +
                   host + ":" + port + "/" + database + "?useSSL=false", user, password);
       }
   }

   public void disconnect() {
       if (isConnected()) {
           try {
               connection.close();
           } catch (SQLException e) {
               e.printStackTrace();
           }
       }
   }

    public Connection getConnection() {
        return connection;
    }
}
