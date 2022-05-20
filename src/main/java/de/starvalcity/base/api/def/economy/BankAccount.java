package de.starvalcity.base.api.def.economy;

import org.jetbrains.annotations.NotNull;

public class BankAccount {

    public Object owner;
    public String name;
    public int id;
    public BankAccountType accountType;
    public double balance;

    public BankAccount(@NotNull Object owner, @NotNull String name, int id, @NotNull BankAccountType accountType) {
        this.owner = owner;
        this.name = name;
        this.id = id;
        this.accountType = accountType;
    }

    public void setOwner(Object owner) {
        this.owner = owner;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAccountType(BankAccountType accountType) {
        this.accountType = accountType;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Object getOwner() {
        return owner;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public BankAccountType getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }
}
