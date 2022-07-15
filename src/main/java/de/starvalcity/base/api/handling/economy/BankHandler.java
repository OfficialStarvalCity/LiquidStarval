package de.starvalcity.base.api.handling.economy;

import de.starvalcity.base.Pluginbase;
import de.starvalcity.base.api.def.economy.Bank;

public class BankHandler {

    private static Pluginbase pluginbase = new Pluginbase();

    public void createBank(String name, Object owner, Object founder) {
        Bank bank = new Bank(name, owner, founder);
        pluginbase.getObjectManager().attachObject(bank);
    }
}