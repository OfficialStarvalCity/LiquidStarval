package de.starvalcity.base.api.def.economy;

import de.starvalcity.base.api.def.EconomyParticipator;
import de.starvalcity.base.api.def.UniqueObject;

import java.util.List;

public class Company implements EconomyParticipator, UniqueObject {

    private String name;
    private CompanyType companyType;
    private int id;
    private Object founder;
    private List<Object> owners;
    private List<Object> workers;

    public Company(String name, CompanyType companyType, int id, Object founder) {
        this.name = name;
        this.companyType = companyType;
        this.id = id;
        this.founder = founder;
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
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
}
