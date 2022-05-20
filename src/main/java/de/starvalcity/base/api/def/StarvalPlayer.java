package de.starvalcity.base.api.def;

import org.bukkit.entity.Player;

import java.util.UUID;

public abstract class StarvalPlayer implements EconomyParticipator, FactionParticipator {

    public Player player;
    public String name;
    public UUID uniqueId;
    public long firstJoin;
    public long lastSeen;

    public double balance;
    public double bankAccountBalance;
    public boolean hasBankAccount;
    public boolean isBankAccountOwner;
    public boolean isBankAccountMember;

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUniqueId(UUID uniqueId) {
        this.uniqueId = uniqueId;
    }

    public void setFirstJoin() {
        this.firstJoin = System.currentTimeMillis();
    }

    public void setLastSeen() {
        this.lastSeen = System.currentTimeMillis();
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setBankAccountBalance(double balance) {
        this.bankAccountBalance = balance;
    }

    public boolean hasBankAccount() {
        return hasBankAccount;
    }

    public boolean isBankAccountOwner() {
        return isBankAccountOwner;
    }

    public boolean isBankAccountMember() {
        return isBankAccountMember;
    }

}
