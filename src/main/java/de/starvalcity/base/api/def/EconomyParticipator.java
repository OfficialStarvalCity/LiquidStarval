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
    // Bank Account
    //--------------------------------------------------------------------------------------------------//

    void createBankAccount(int id, String name, Object owner);

    void deleteBankAccount(int id);

    //--------------------------------------------------------------------------------------------------//
    // Transactions
    //--------------------------------------------------------------------------------------------------//

    void deposit(Object instance, double amount, StarvalID starvalID);

    void withdraw(Object instance, double amount, StarvalID starvalID);

}
