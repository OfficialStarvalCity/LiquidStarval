package de.starvalcity.base.api.handling;

import de.starvalcity.base.api.def.StarvalID;
import de.starvalcity.base.api.def.economy.BankAccount;
import de.starvalcity.base.api.def.economy.BankAccountType;

import java.util.HashMap;
import java.util.Map;

public class BankManager {

    private Map<Object, BankAccount> playerBankAccounts = new HashMap<>();

    public void createBankAccount(StarvalID id, String name, Object owner, BankAccountType accountType) {
        BankAccount newBankAccount = new BankAccount(owner, name, id, accountType);
        playerBankAccounts.put(owner, newBankAccount);

    }



}
