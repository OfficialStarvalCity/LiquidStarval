package de.starvalcity.base.api.def;

import de.starvalcity.base.api.def.faction.Faction;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public abstract class StarvalPlayer implements Comparable<StarvalPlayer>, EconomyParticipator, FactionParticipator {

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

    public String getName() {
        return name;
    }

    public UUID getUniqueId() {
        return uniqueId;
    }
}
