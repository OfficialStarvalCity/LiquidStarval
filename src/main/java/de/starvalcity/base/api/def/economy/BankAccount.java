package de.starvalcity.base.api.def.economy;

import de.starvalcity.base.api.def.StarvalID;
import de.starvalcity.base.api.def.StarvalPlayer;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Ein {@link BankAccount} ist ein benutzerdefiniertes Bankkonto von einem {@link StarvalPlayer}.
 */
public class BankAccount {

    private String name;
    private StarvalID starvalID;
    private StarvalPlayer creator;
    private Object owner;
    private BankAccountType accountType;
    private List<StarvalPlayer> members;

    private double balance;

    public BankAccount(String name, StarvalID starvalID, StarvalPlayer creator, @Nullable Object owner, BankAccountType accountType) {
        this.name = name;
        this.starvalID = starvalID;
        this.creator = creator;
        this.owner = owner;
        this.accountType = accountType;
    }

    public String getName() {
        return name;
    }

    public StarvalID getStarvalID() {
        return starvalID;
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

    public void setStarvalID(StarvalID starvalID) {
        this.starvalID = starvalID;
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
