package de.starvalcity.base.api.def.economy;

import de.starvalcity.base.api.def.EconomyParticipator;
import de.starvalcity.base.api.def.StarvalPlayer;
import de.starvalcity.base.api.def.UniqueObject;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Ein {@link BankAccount} ist ein benutzerdefiniertes Bankkonto von einem {@link StarvalPlayer}, einer {@link de.starvalcity.base.api.def.faction.Faction}
 * oder einer Firma.
 */
public class BankAccount implements EconomyParticipator, UniqueObject {

    private String name;
    private int id;
    private StarvalPlayer creator;
    private Object owner;
    private BankAccountType accountType;
    private List<StarvalPlayer> members;

    private double balance;

    public BankAccount(String name, int id, StarvalPlayer creator, @Nullable Object owner, BankAccountType accountType) {
        this.name = name;
        this.id = id;
        this.creator = creator;
        this.owner = owner;
        this.accountType = accountType;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
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

    @Override
    public boolean hasEnoughMoney(double requiredAmount) {
        return false;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public void setDefaultBalance() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public void addMoney(double amount) {

    }

    @Override
    public void removeMoney(double amount) {

    }

    @Override
    public void deposit(Object instance, double amount, int accountId) {

    }

    @Override
    public void withdraw(Object instance, double amount, int accountId) {

    }
}
