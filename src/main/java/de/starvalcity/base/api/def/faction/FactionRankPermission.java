package de.starvalcity.base.api.def.faction;

import javax.annotation.Nullable;

public enum FactionRankPermission {

    OWN_DEPOSIT("starvalcity.factions.own.deposit", DefaultRank.TRUSTED),
    OWN_INVITE("starvalcity.factions.own.invite", DefaultRank.TRUSTED),
    OWN_SHOW_BALANCE("starvalcity.factions.own.showbalance", DefaultRank.TRUSTED),
    OWN_WITHDRAW("starvalcity.factions.own.withdraw", DefaultRank.LEADER);

    private final String bukkitPermission;
    private final DefaultRank defaultRank;

    FactionRankPermission(String bukkitPermission, DefaultRank defaultRank) {
        this.bukkitPermission = bukkitPermission;
        this.defaultRank = defaultRank;
    }

    public String getBukkitPermission() {
        return bukkitPermission;
    }

    public DefaultRank getDefaultRank() {
        return defaultRank;
    }

    public static boolean isValid(@Nullable String permission) {
        for (FactionRankPermission p : values()) {
            if (p.toString().equalsIgnoreCase(permission)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString().replace("_", ".").toLowerCase();
    }

}
