package de.starvalcity.base.api.def.economy;

import de.starvalcity.base.api.def.EconomyParticipator;
import de.starvalcity.base.api.def.UniqueObject;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Bank implements EconomyParticipator, UniqueObject {

    private String name;
    private int id;
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

    @Override
    public boolean hasEnoughMoney(double requiredAmount) {
        return false;
    }

    @Override
    public boolean hasEnoughMoney(int requiredAmount) {
        return false;
    }

    @Override
    public double getBalance() {
        return 0;
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

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public void setId(int id) {

    }
}
