package de.starvalcity.base.api.def;

import de.starvalcity.base.api.def.economy.BankAccount;
import de.starvalcity.base.api.def.economy.EconomyResponse;

import java.util.List;

public interface EconomyParticipator {

    double getBalance(Object object);

    boolean has(StarvalPlayer starvalPlayer, double amount);

    boolean hasBankAccount(StarvalPlayer starvalPlayer);

    String formatBalance(double amount);

    EconomyResponse withdraw(StarvalPlayer starvalPlayer, double amount);

    EconomyResponse deposit(StarvalPlayer starvalPlayer, double amount);

    EconomyResponse isBankAccountOwner(String name, StarvalPlayer starvalPlayer);

    EconomyResponse isBankAccountMember(String name, StarvalPlayer starvalPlayer);

    EconomyResponse withdrawFromBankAccount(String name, double amount);

    EconomyResponse depositFromBankAccount(String name, double amount);

    EconomyResponse createBankAccount(StarvalPlayer starvalPlayer, String name);

    EconomyResponse deleteBankAccount(String name);

    EconomyResponse getBankAccountBalance(String name);

    EconomyResponse bankAccountHasBalance(String name, double amount);

    List<BankAccount> getBankAccounts();

    boolean createPlayerAccount(StarvalPlayer starvalPlayer);

}
