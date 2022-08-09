package de.starvalcity.base.api.handling.economy;

import de.starvalcity.base.Pluginbase;
import de.starvalcity.base.api.def.database.MySQLAPI;
import de.starvalcity.base.api.def.economy.Bank;
import de.starvalcity.base.api.def.economy.EconomyObjectType;
import de.starvalcity.base.api.handling.object.ObjectSQLManager;
import org.jetbrains.annotations.NotNull;

public class EconomyManager {

    private static Pluginbase pluginbase = new Pluginbase();

    /**
     * Bank Creation
     * Creates a bank.
     * @param name name of the bank
     * @param owner owner of the bank
     * @param founder founder of the bank
     */
    public static void createBank(String name, @NotNull Object owner, @NotNull Object founder) {
        Bank createdBank = new Bank(name, owner, founder);

        if (!ObjectSQLManager.objectExists(createdBank)) {
            if (!pluginbase.getEconomySQLManager().databaseObjectExists(createdBank.getId(), "LiquidBanks")) {
                ObjectSQLManager.attachObject(EconomyObjectType.BANK.toString());
                createdBank.setId(ObjectSQLManager.getObjectId(createdBank));

                pluginbase.getEconomySQLManager().addToTable(EconomyObjectType objectType);
            }
        }
    }

}
