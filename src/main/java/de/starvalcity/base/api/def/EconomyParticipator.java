package de.starvalcity.base.api.def;

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
    // Transactions
    //--------------------------------------------------------------------------------------------------//

    void deposit(Object instance, double amount, int accountId);

    void withdraw(Object instance, double amount, int accountId);

}
