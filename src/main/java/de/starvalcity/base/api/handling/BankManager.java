package de.starvalcity.base.api.handling;

import de.starvalcity.base.api.def.StarvalID;
import de.starvalcity.base.api.def.StarvalPlayer;
import de.starvalcity.base.api.def.economy.BankAccount;
import de.starvalcity.base.api.def.economy.BankAccountType;

import java.util.HashMap;
import java.util.Map;

public class BankManager {

    private Map<StarvalPlayer, BankAccount> playerBankAccounts = new HashMap<>();
    private Map<StarvalID, Double> bankAccountBalances = new HashMap<>();

    public void createBankAccount(StarvalID id, String name, StarvalPlayer owner, BankAccountType accountType) {
        BankAccount newBankAccount = new BankAccount(owner, name, id, accountType);
        playerBankAccounts.put(owner, newBankAccount);
        bankAccountBalances.put(id, 0.0);

    }

    public void deleteBankAccount(StarvalID id) {

    }

}
