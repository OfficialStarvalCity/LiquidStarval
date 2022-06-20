package de.starvalcity.base.api.handling;

import de.starvalcity.base.Core;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {

   private String host; // "univastro.net";
   private String user; // "starvalcity_dev";
   private String password; // "KDLJ5WBNRO5GsjWD";
   private String database; // "starvalcity_dev_liquid";
   private String table;
   private int port; // 3306;

   private Connection connection;
   private JavaPlugin plugin = JavaPlugin.getPlugin(Core.class);

   public void setupMySQL() {
       host = plugin.getConfig().getString("MySQL.Host");
       user = plugin.getConfig().getString("MySQL.User");
       password = plugin.getConfig().getString("MySQL.Password");
       database = plugin.getConfig().getString("MySQL.Database");
       port = plugin.getConfig().getInt("MySQL.Port");
       table = plugin.getConfig().getString("MySQL.Table");

       try {
           synchronized (plugin) {
               if (getConnection() != null && !getConnection().isClosed()) {
                   return;
               }
               Class.forName("com.mysql.jdbc.Driver");
               setConnection(DriverManager.getConnection("jdbc:mysql://" + this.host + ":" + this.port + "/" + this.database,
                       this.user, this.password));
               System.out.println("[MySQL] Database is connected!");
           }
       } catch (SQLException | ClassNotFoundException sqlException) {
           sqlException.printStackTrace();
       }
   }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public String getPlayerTable() {
       return this.table;
    }
}
