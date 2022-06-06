package de.starvalcity.base.api.def;

import de.starvalcity.base.api.def.economy.BankAccount;
import de.starvalcity.base.api.def.economy.EconomyResponse;
import de.starvalcity.base.api.def.faction.Faction;
import de.starvalcity.base.api.def.faction.FactionRank;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;
import java.util.*;

public class StarvalPlayer implements Comparable<StarvalPlayer>, EconomyParticipator, Serializable {

    private Player player;
    private String name;
    private UUID uniqueId;
    private StarvalID starvalId;
    private long firstJoin;
    private long lastSeen;

    private boolean hasBankAccount;
    private boolean isBankAccountOwner;
    private boolean isBankAccountMember;
    private double bankAccountBalance;
    private double balance;
    private int bankAccountId;

    private @Nullable Faction faction;
    private @Nullable FactionRank factionRank;
    private boolean isFactionOwner;
    private int kills;
    private int deaths;

    private List<BankAccount> bankAccounts = new ArrayList<>();

    private Map<StarvalID, BankAccount> bankAccountIds = new HashMap<>();

    private Set<String> pastFactions = new HashSet<>();
    private Set<String> pastStaffRanks = new HashSet<>();

    public StarvalPlayer(Player player, String name, UUID uniqueId, StarvalID starvalId) {
        setPlayer(player);
        setName(name);
        setUniqueId(uniqueId);
        setStarvalId(starvalId);
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof StarvalPlayer)) {
            return false;
        }

        StarvalPlayer other = (StarvalPlayer) object;
        return other.getName().equals(getName());
    }

    @Override
    public int compareTo(StarvalPlayer other) {
        return getUniqueId().compareTo(other.getUniqueId());
    }

    //--------------------------------------------------------------------------------------------------//
    // Basic Setters
    //--------------------------------------------------------------------------------------------------//

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUniqueId(UUID uniqueId) {
        this.uniqueId = uniqueId;
    }

    public void setStarvalId(StarvalID starvalId) {
        this.starvalId = starvalId;
    }

    public void setFirstJoin(long firstJoin) {
        this.firstJoin = firstJoin;
    }

    public void setLastSeen(long lastSeen) {
        this.lastSeen = lastSeen;
    }

    //--------------------------------------------------------------------------------------------------//
    // Basic Getters
    //--------------------------------------------------------------------------------------------------//

    public Player getPlayer() {
        return player;
    }

    public String getName() {
        return name;
    }

    public UUID getUniqueId() {
        return uniqueId;
    }

    public StarvalID getStarvalId() {
        return starvalId;
    }

    public long getFirstJoin() {
        return firstJoin;
    }

    public long getLastSeen() {
        return lastSeen;
    }

    //--------------------------------------------------------------------------------------------------//
    // Economy Booleans
    //--------------------------------------------------------------------------------------------------//

    @Override
    public boolean hasEnoughMoney(double requiredAmount) {
        if (requiredAmount > getBalance()) {
            return false;
        }
        if (requiredAmount < getBalance()) {
            return true;
        }
        if (requiredAmount == getBalance()) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean hasBankAccount() {
        return hasBankAccount;
    }

    public boolean isBankAccountOwner(@NotNull BankAccount bankAccount) {
        if (bankAccount.getOwner().equals(this)) {
            return true;
        } else {
            return false;
        }
    }

    //--------------------------------------------------------------------------------------------------//
    // Economy Setters
    //--------------------------------------------------------------------------------------------------//

    @Override
    public void setDefaultBalance() {
        this.balance = 1000;
    }

    @Override
    public void setBalance(double amount) {
        this.balance = amount;
    }

    public void setHasBankAccount(boolean hasBankAccount) {
        this.hasBankAccount = hasBankAccount;
    }

    //--------------------------------------------------------------------------------------------------//
    // Economy Getters
    //--------------------------------------------------------------------------------------------------//

    @Override
    public double getBalance() {
        return balance;
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    //--------------------------------------------------------------------------------------------------//
    // Economy Misc
    //--------------------------------------------------------------------------------------------------//

    @Override
    public void addMoney(double amount) {
        balance = getBalance() + amount;
    }

    @Override
    public void removeMoney(double amount) {
        balance = getBalance() - amount;
    }

    @Override
    public void createBankAccount(int id, String name, Object owner) {

    }

    @Override
    public void deleteBankAccount(int id) {

    }

    @Override
    public EconomyResponse deposit(Object instance, double amount, StarvalID starvalID) {
        return null;
    }

    @Override
    public EconomyResponse withdraw(Object instance, double amount, StarvalID starvalID) {
        return null;
    }
}