package de.starvalcity.base.api.def;

import de.starvalcity.base.api.def.economy.EconomyResponse;

/**
 *
 */
public interface EconomyParticipator {

    //--------------------------------------------------------------------------------------------------//
    // Instance Account
    //--------------------------------------------------------------------------------------------------//

    boolean hasEnoughMoney(double requiredAmount);

    double getBalance();

    void setDefaultBalance();

    void setBalance(double amount);

    void addMoney(double amount);

    void removeMoney(double amount);

    //--------------------------------------------------------------------------------------------------//
    // Bank Account
    //--------------------------------------------------------------------------------------------------//

    void createBankAccount(int id, String name, Object owner);

    void deleteBankAccount(int id);

    //--------------------------------------------------------------------------------------------------//
    // Transactions
    //--------------------------------------------------------------------------------------------------//

    EconomyResponse deposit(Object instance, double amount, StarvalID starvalID);

    EconomyResponse withdraw(Object instance, double amount, StarvalID starvalID);

}
