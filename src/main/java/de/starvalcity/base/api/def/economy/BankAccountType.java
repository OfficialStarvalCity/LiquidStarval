package de.starvalcity.base.api.def.economy;

/**
 * Die {@link BankAccountType} gibt die Art eines Bankkontos der {@link BankAccount} Klasse an.
 *
 * PlayerAccount > Spielerkonto
 * CompanyAccount > Firmenkonto
 * FactionAccount > Fraktionskonto
 * ServerAccount > Serverkonto
 */
public enum BankAccountType {
    PLAYER_ACCOUNT, COMPANY_ACCOUNT, FACTION_ACCOUNT, SERVER_ACCOUNT
}
