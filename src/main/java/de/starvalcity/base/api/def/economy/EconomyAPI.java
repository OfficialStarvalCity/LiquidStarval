package de.starvalcity.base.api.def.economy;

import de.starvalcity.base.Core;
import de.starvalcity.base.api.def.database.MySQLAPI;
import de.starvalcity.base.background.log.LogHandler;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.PreparedStatement;


public class EconomyAPI {

    private static LogHandler log = new LogHandler();
    private JavaPlugin plugin = JavaPlugin.getPlugin(Core.class);
    private MySQLAPI sql = new MySQLAPI();

}
