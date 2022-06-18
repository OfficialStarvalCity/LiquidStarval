package de.starvalcity.base.api.def.economy;

import de.starvalcity.base.api.def.StarvalID;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class BankAccount {

    public Object owner;
    public List<Object> members;
    public String name;
    public StarvalID starvalID;
    public BankAccountType accountType;
    public double balance;

    public BankAccount(@NotNull Object owner, @NotNull String name, StarvalID starvalID, @NotNull BankAccountType accountType) {
        this.owner = owner;
        this.name = name;
        this.starvalID = starvalID;
        this.accountType = accountType;
    }

    public void setOwner(Object owner) {
        this.owner = owner;
    }

    public void setMember(Object member) {
        members.add(member);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(StarvalID starvalID) {
        this.starvalID = starvalID;
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

    public List<Object> getMembers() {
        return members;
    }

    public String getName() {
        return name;
    }

    public StarvalID getId() {
        return starvalID;
    }

    public BankAccountType getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }
}
