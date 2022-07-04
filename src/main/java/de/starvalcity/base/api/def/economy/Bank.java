package de.starvalcity.base.api.def.economy;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private String name;
    private @Nullable Object owner;
    private @Nullable Object founder;
    private List<BankAccount> bankAccounts = new ArrayList<>();

    public Bank(String name, @Nullable Object owner, @Nullable Object founder) {
        this.name = name;
        this.owner = owner;
        this.founder = founder;
    }

    public String getName() {
        return name;
    }

    public Object getOwner() {
        return owner;
    }

    public Object getFounder() {
        return founder;
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwner(Object owner) {
        this.owner = owner;
    }

    public void setFounder(Object founder) {
        this.founder = founder;
    }

    public void setBankAccounts(List<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }
}
