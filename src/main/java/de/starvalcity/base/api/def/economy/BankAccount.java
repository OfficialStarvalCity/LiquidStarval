package de.starvalcity.base.api.def.economy;

import de.starvalcity.base.api.def.StarvalPlayer;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Ein {@link BankAccount} ist ein benutzerdefiniertes Bankkonto von einem {@link StarvalPlayer}, einer {@link de.starvalcity.base.api.def.faction.Faction}
 * oder einer Firma.
 */
public class BankAccount {

    private String name;
    private int accountId;
    private StarvalPlayer creator;
    private Object owner;
    private BankAccountType accountType;
    private List<StarvalPlayer> members;

    private double balance;

    public BankAccount(String name, int accountId, StarvalPlayer creator, @Nullable Object owner, BankAccountType accountType) {
        this.name = name;
        this.accountId = accountId;
        this.creator = creator;
        this.owner = owner;
        this.accountType = accountType;
    }

    public String getName() {
        return name;
    }

    public int getAccountId() {
        return accountId;
    }

    public StarvalPlayer getCreator() {
        return creator;
    }

    public Object getOwner() {
        return owner;
    }

    public BankAccountType getAccountType() {
        return accountType;
    }

    public List<StarvalPlayer> getMembers() {
        return members;
    }

    public double getBalance() {
        return balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public void setCreator(StarvalPlayer creator) {
        this.creator = creator;
    }

    public void setOwner(Object owner) {
        this.owner = owner;
    }

    public void setAccountType(BankAccountType accountType) {
        this.accountType = accountType;
    }

    public void setMembers(List<StarvalPlayer> members) {
        this.members = members;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
