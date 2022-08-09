package de.starvalcity.base.api.def;

import de.starvalcity.base.api.def.database.MySQLAPI;
import de.starvalcity.base.api.def.economy.BankAccount;
import de.starvalcity.base.api.def.economy.EconomyParticipator;
import de.starvalcity.base.api.def.faction.Faction;
import de.starvalcity.base.api.def.faction.FactionRank;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;

// TODO: Rank with LuckPerms
// TODO: Lombok?
public class StarvalPlayer extends DatabaseObject implements Comparable<StarvalPlayer>, EconomyParticipator, Serializable, UniqueObject {

    private Player player;
    private String name;
    private UUID uniqueId;
    private int id;
    private long firstJoin;
    private long lastSeen;

    private boolean hasBankAccount; // - Hat der Spieler bereits ein Konto
    private boolean isBankAccountOwner; // - Ist der Spieler Besitzer von einem Konto oder von mehreren Konten
    private boolean isBankAccountMember; // - Ist der Spieler Mitglied von einem Konto oder von mehreren Konten
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

    //--------------------------------------------------------------------------------------------------//
    // Constructor
    //--------------------------------------------------------------------------------------------------//

    /**
     * Constructor
     * <p>This <b>constructor</b> is used to create instances depending on the <b>{@link Player} instance, name and {@link UUID}</b>
     * of the given {@link Player}.</p>
     * @param player
     * @param name
     * @param uniqueId
     */
    public StarvalPlayer(Player player, String name, UUID uniqueId) {
        setPlayer(player);
        setName(name);
        setUniqueId(uniqueId);
    }

    //--------------------------------------------------------------------------------------------------//
    // Interface Misc
    //--------------------------------------------------------------------------------------------------//

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

    @Override
    public void setId(int id) {
        this.id = id;
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

    public void setFirstJoin(long firstJoin) {
        this.firstJoin = firstJoin;
    }

    public void setLastSeen(long lastSeen) {
        this.lastSeen = lastSeen;
    }

    //--------------------------------------------------------------------------------------------------//
    // Basic Getters
    //--------------------------------------------------------------------------------------------------//

    @Override
    public int getId() {
        return id;
    }

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

    public boolean hasEnoughReadyCash(double requiredAmount) {
        if (requiredAmount > getReadyCash()) {
            return false;
        }
        if (requiredAmount < getReadyCash()) {
            return true;
        }
        if (requiredAmount == getReadyCash()) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean hasBankAccount() {
        return hasBankAccount;
    }

    public boolean isBankAccountOwner() {
        return isBankAccountOwner;
    }

    public boolean isOwnerOfBankAccount(@NotNull BankAccount bankAccount) {
        return bankAccount.getOwner().equals(this);
    }

    // TODO
    public boolean isOwnerOfBankAccount(int bankAccountId) {
        return true;
    }

    public boolean isBankAccountMember() {
        return isBankAccountMember;
    }

    public boolean isMemberOfBankAccount(@NotNull BankAccount bankAccount) {
        return bankAccount.getMembers().contains(this);
    }

    // TODO
    public boolean isMemberOfBankAccount(int bankAccountId) {
        return true;
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

    public void setReadyCash(double amount) {
        this.readyCash = amount;
    }

    public void setHasBankAccount() {
        this.hasBankAccount = true;
    }

    public void setIsBankAccountOwner() {
        this.isBankAccountOwner = true;
    }

    public void setIsBankAccountMember() {
        this.isBankAccountMember = true;
    }

    //--------------------------------------------------------------------------------------------------//
    // Economy Getters
    //--------------------------------------------------------------------------------------------------//

    @Override
    public double getBalance() {
        return balance;
    }

    public double getReadyCash() {
        return readyCash;
    }

    //--------------------------------------------------------------------------------------------------//
    // Economy Misc
    //--------------------------------------------------------------------------------------------------//

    /**
     * (Interne Funktion)
     * @param amount
     */
    @Override
    public void addMoney(double amount) {
        this.balance = getBalance() + amount;
    }

    /**
     * (Interne Funktion)
     * @param amount
     */
    @Override
    public void removeMoney(double amount) {
        this.balance = getBalance() - amount;
    }

    public void addReadyCash(double amount) {
        this.readyCash = getReadyCash() + amount;
    }

    public void removeReadyCash(double amount) {
        this.readyCash = getReadyCash() - amount;
    }

    //--------------------------------------------------------------------------------------------------//
    // Database Object Methods
    //--------------------------------------------------------------------------------------------------//

    @Override
    public void setValue(String statement, String table, String column, Object value) {
        MySQLAPI.update(statement + " INTO " + "`" + table + "`" + "WHERE ");
    }
}