package de.starvalcity.base.api.def;

import de.starvalcity.base.api.def.economy.BankAccount;
import de.starvalcity.base.api.def.faction.Faction;
import de.starvalcity.base.api.def.faction.FactionRank;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.*;

public class StarvalPlayer implements Comparable<StarvalPlayer>, EconomyParticipator, Serializable {

    private Player player;
    private String name;
    private UUID uniqueId;
    private int playerId;
    private long firstJoin;
    private long lastSeen;

    private boolean hasBankAccount; // - Hat der Spieler bereits ein Konto
    private boolean isBankAccountOwner; // - Ist der Spieler Besitzer von einem Konto oder von mehreren Konten
    private boolean isBankAccountMember; // - Ist der Spieler Mitglied von einem Konto oder von mehreren Konten
    private double bankAccountBalance; // - Kontostand eines Kontos, welches der Spieler besitzt
    private double balance; // - Gesamter Kontostand des Spielers // TODO
    private double readyCash; // - Bargeld des Spielers

    private Faction faction; // - Fraktion des Spielers
    private FactionRank factionRank; // - Fraktionsrang des Spielers
    private boolean isFactionOwner; // - Ist der Spieler Inhaber einer Fraktion
    private int kills; // - Morde an andere Spieler
    private int deaths; // - Tode des Spielers

    private List<BankAccount> bankAccounts = new ArrayList<>(); // - Konten des Spielers

    private Map<Integer, BankAccount> bankAccountIds = new HashMap<>(); // - Konten und KontenIDs des Spielers

    private Set<String> pastFactions = new HashSet<>(); // - Vergangene Fraktionen des Spielers
    private Set<String> pastStaffRanks = new HashSet<>(); // - Vergangene Ränge des Spielers

    public StarvalPlayer(Player player, String name, UUID uniqueId) {
        setPlayer(player);
        setName(name);
        setUniqueId(uniqueId);
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

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
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

    public StarvalPlayer getStarvalPlayer() {
        return this;
    }

    public String getName() {
        return name;
    }

    public UUID getUniqueId() {
        return uniqueId;
    }

    public int getPlayerId() {
        return playerId;
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

    public boolean isBankAccountMember(@NotNull BankAccount bankAccount) {
        if (bankAccount.getMembers().contains(this)) {
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

    public double getBankAccountBalance(int id) {
        return getBankAccounts().get(id).getBalance();
    }

    public double getReadyCash() {
        return readyCash;
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
    public void deposit(Object instance, double amount, int accountId) {

    }

    @Override
    public void withdraw(Object instance, double amount, int starvalID) {

    }
}