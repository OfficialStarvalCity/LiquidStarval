package de.starvalcity.base.api.def.economy;

public enum BankAccountType {

    DEFAULT_ACCOUNT(1),
    FACTION_ACCOUNT(2),
    COMPANY_ACCOUNT(3),
    SERVER_ACCOUNT(4);

    private int id;

    BankAccountType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }


}
