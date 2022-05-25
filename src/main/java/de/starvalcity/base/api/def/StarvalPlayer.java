package de.starvalcity.base.api.def;

import de.starvalcity.base.api.def.economy.BankAccount;
import de.starvalcity.base.api.def.economy.EconomyResponse;
import de.starvalcity.base.api.def.faction.Faction;
import de.starvalcity.base.api.def.faction.FactionRank;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class StarvalPlayer implements Comparable<StarvalPlayer>, EconomyParticipator, FactionParticipator {

    private Player player;
    private String name;
    private UUID uniqueId;
    private long firstJoin;
    private long lastSeen;

    private double balance;
    private double bankAccountBalance;
    private boolean hasBankAccount;
    private boolean isBankAccountOwner;
    private boolean isBankAccountMember;

    private @Nullable Faction faction;
    private @Nullable FactionRank factionRank;
    private boolean isFactionOwner;
    private int kills;
    private int deaths;

    private Set<String> pastFactions = new HashSet<>();
    private Set<String> pastStaffRanks = new HashSet<>();

    public StarvalPlayer(Player player, String name, UUID uniqueId) {
        setPlayer(player);
        setName(name);
        setUniqueId(uniqueId);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof StarvalPlayer)) {
            return false;
        }

        StarvalPlayer other = (StarvalPlayer) obj;
        return other.getName().equals(getName());
    }

    @Override
    public int compareTo(StarvalPlayer other) {
        return getUniqueId().compareTo(other.getUniqueId());
    }

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

    public Player getPlayer() {
        return player;
    }

    public long getFirstJoin() {
        return firstJoin;
    }

    public long getLastSeen() {
        return lastSeen;
    }

    public double getBalance() {
        return balance;
    }

    public double getBankAccountBalance() {
        return bankAccountBalance;
    }

    public String getName() {
        return name;
    }

    public UUID getUniqueId() {
        return uniqueId;
    }

    @Override
    public double getBalance(Object object) {
        return balance;
    }

    @Override
    public boolean has(StarvalPlayer starvalPlayer, double amount) {
        return false;
    }

    @Override
    public boolean hasBankAccount(StarvalPlayer starvalPlayer) {
        return false;
    }

    @Override
    public String formatBalance(double amount) {
        return null;
    }

    @Override
    public EconomyResponse withdraw(StarvalPlayer starvalPlayer, double amount) {
        return null;
    }

    @Override
    public EconomyResponse deposit(StarvalPlayer starvalPlayer, double amount) {
        return null;
    }

    @Override
    public EconomyResponse isBankAccountOwner(String name, StarvalPlayer starvalPlayer) {
        return null;
    }

    @Override
    public EconomyResponse isBankAccountMember(String name, StarvalPlayer starvalPlayer) {
        return null;
    }

    @Override
    public EconomyResponse withdrawFromBankAccount(String name, double amount) {
        return null;
    }

    @Override
    public EconomyResponse depositFromBankAccount(String name, double amount) {
        return null;
    }

    @Override
    public EconomyResponse createBankAccount(StarvalPlayer starvalPlayer, String name) {
        return null;
    }

    @Override
    public EconomyResponse deleteBankAccount(String name) {
        return null;
    }

    @Override
    public EconomyResponse getBankAccountBalance(String name) {
        return null;
    }

    @Override
    public EconomyResponse bankAccountHasBalance(String name, double amount) {
        return null;
    }

    @Override
    public List<BankAccount> getBankAccounts() {
        return null;
    }

    @Override
    public boolean createPlayerAccount(StarvalPlayer starvalPlayer) {
        return false;
    }

    @Override
    public boolean isInAFaction(StarvalPlayer starvalPlayer) {
        return false;
    }

    @Override
    public boolean isFactionOwner(StarvalPlayer starvalPlayer) {
        return false;
    }

    @Override
    public Faction getFaction(StarvalPlayer starvalPlayer) {
        return null;
    }

    @Override
    public String getFactionString(StarvalPlayer starvalPlayer) {
        return null;
    }
}
