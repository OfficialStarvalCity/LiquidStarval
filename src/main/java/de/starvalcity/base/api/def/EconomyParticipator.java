package de.starvalcity.base.api.def;

public interface EconomyParticipator {

    //--------------------------------------------------------------------------------------------------//
    // Instance Account
    //--------------------------------------------------------------------------------------------------//

    boolean hasEnoughMoney(double requiredAmount);

    boolean hasEnoughMoney(int requiredAmount);

    double getBalance();

    void setDefaultBalance();

    void setBalance(double amount);

    void setBalance(int amount);

    void addMoney(double amount);

    void addMoney(int amount);

    void removeMoney(double amount);

    void removeMoney(int amount);

    //--------------------------------------------------------------------------------------------------//
    // Transactions
    //--------------------------------------------------------------------------------------------------//

    void deposit(Object instance, double amount, int accountId);

    void withdraw(Object instance, double amount, int accountId);

}
