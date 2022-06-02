package de.starvalcity.base.api.def.faction;

import de.starvalcity.base.api.def.StarvalPlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Faction implements Comparable<Faction> {

    public enum FactionType {

        NEUTRAL(0), BAD(1), GOOD(2);

        private int id;

        FactionType(int id) {
            this.id = id;
        }
    }

    private String name;
    private int id;
    private FactionType factionType;
    private StarvalPlayer owner;
    private double balance;
    private double monthlySalary;

    private List<StarvalPlayer> members = new ArrayList<>();

    public Faction(String name, int id, FactionType factionType, @Nullable StarvalPlayer owner, double balance) {
        this.name = name;
        this.id = id;
        this.factionType = factionType;
        this.owner = owner;
        this.balance = balance;
    }

    @Override
    public int compareTo(@NotNull Faction other) {
        return Integer.compare(this.id, other.id);
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public FactionType getFactionType() {
        return factionType;
    }

    public StarvalPlayer getOwner() {
        return owner;
    }

    public List<StarvalPlayer> getMembers() {
        return members;
    }

    public double getBalance() {
        return balance;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFactionType(FactionType factionType) {
        this.factionType = factionType;
    }

    public void setOwner(StarvalPlayer owner) {
        this.owner = owner;
    }

    public void setMembers(List<StarvalPlayer> members) {
        this.members = members;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }
}
