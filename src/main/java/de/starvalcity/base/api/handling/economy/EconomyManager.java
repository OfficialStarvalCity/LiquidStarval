package de.starvalcity.base.api.handling.economy;

import de.starvalcity.base.Pluginbase;
import de.starvalcity.base.api.def.TableHandler;

/**
 * Der {@link EconomyManager} sorgt für die Verwaltung aller wirtschaftlichen Komponenten auf dem Server.
 */
public class EconomyManager extends TableHandler {

    private static Pluginbase pluginbase = new Pluginbase();
    private static EconomySQLManager ecoSQL = new EconomySQLManager();

    @Override
    public boolean databaseObjectExists(int id, String table) {
        return super.databaseObjectExists(id, table);
    }
}
