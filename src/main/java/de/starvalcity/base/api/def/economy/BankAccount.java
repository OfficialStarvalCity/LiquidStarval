package de.starvalcity.base.api.def.economy;

import de.starvalcity.base.api.def.EconomyParticipator;
import de.starvalcity.base.api.def.StarvalPlayer;
import de.starvalcity.base.api.def.UniqueObject;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Ein {@link BankAccount} ist ein benutzerdefiniertes Bankkonto von einem {@link StarvalPlayer}, einer {@link de.starvalcity.base.api.def.faction.Faction}
 * oder einer Firma.
 */
@Getter @Setter
public class BankAccount implements EconomyParticipator, UniqueObject {

    private String name;
    private int id;
    private StarvalPlayer creator;
    private Object owner;
    private Bank bank;
    private BankAccountType accountType;
    private List<StarvalPlayer> members;

    private double balance;

    public BankAccount(String name, int id, StarvalPlayer creator, @Nullable Object owner, Bank bank, BankAccountType accountType) {
        this.name = name;
        this.id = id;
        this.creator = creator;
        this.owner = owner;
        this.bank = bank;
        this.accountType = accountType;
    }

    @Override
    public boolean hasEnoughMoney(double requiredAmount) {
        return false;
    }

    @Override
    public boolean hasEnoughMoney(int requiredAmount) {
        return false;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public void setDefaultBalance() {

    }

    @Override
    public void setBalance(double amount) {

    }

    @Override
    public void setBalance(int amount) {

    }

    @Override
    public void addMoney(double amount) {

    }

    @Override
    public void addMoney(int amount) {

    }

    @Override
    public void removeMoney(double amount) {

    }

    @Override
    public void removeMoney(int amount) {

    }

    @Override
    public void deposit(Object instance, double amount, int accountId) {

    }

    @Override
    public void withdraw(Object instance, double amount, int accountId) {

    }
}
