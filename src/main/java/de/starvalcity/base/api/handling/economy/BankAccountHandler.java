package de.starvalcity.base.api.handling.economy;

import de.starvalcity.base.api.def.economy.BankAccount;

public class BankAccountHandler {

    public Object getBankAccountObject(BankAccount bankAccount) {
        return bankAccount.getClass();
    }
}
