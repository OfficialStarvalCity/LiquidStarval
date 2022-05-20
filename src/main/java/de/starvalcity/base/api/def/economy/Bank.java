package de.starvalcity.base.api.def.economy;

import de.starvalcity.base.api.def.StarvalPlayer;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private String name;
    private int id;
    private @Nullable StarvalPlayer owner;
    private @Nullable List<StarvalPlayer> workers;

    private final ArrayList<String> bankAccounts = new ArrayList<>();

    public Bank(String name, int id, @Nullable StarvalPlayer owner, @Nullable List<StarvalPlayer> workers) {
        this.name = name;
        this.id = id;
        this.owner = owner;
        this.workers = workers;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public StarvalPlayer getOwner() {
        return owner;
    }

    public List<StarvalPlayer> getWorkers() {
        return workers;
    }

    public ArrayList<String> getBankAccounts() {
        return bankAccounts;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOwner(StarvalPlayer owner) {
        this.owner = owner;
    }

    public void setWorkers(List<StarvalPlayer> workers) {
        this.workers = workers;
    }

}
