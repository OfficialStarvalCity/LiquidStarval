package de.starvalcity.base.api.def.faction;

public enum DefaultRank {

    UNTRUSTED(0),
    TRUSTED(1),
    MEMBER(2),
    SUPPORTER(3),
    MODERATOR(4),
    COLEADER(5),
    LEADER(6);

    private final int id;

    DefaultRank(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
