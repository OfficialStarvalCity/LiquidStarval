package de.starvalcity.base.api.handling;

import de.starvalcity.base.api.def.StarvalID;
import de.starvalcity.base.api.def.StarvalPlayer;
import de.starvalcity.base.api.def.economy.Bank;
import de.starvalcity.base.api.def.economy.BankAccount;
import de.starvalcity.base.api.def.economy.BankAccountType;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class BankManager {

    private final List<Bank> banks = new ArrayList<>();
    private final List<BankAccount> bankAccounts = new ArrayList<>();

    public void createBank(String name, @Nullable Object owner, @Nullable Object founder) {
        Bank bank = new Bank(name, owner, founder);
        banks.add(bank);
    }

    public void removeBank(Bank bank) {
        banks.remove(bank);
    }

    public void createBankAccount(String name, StarvalID starvalID, StarvalPlayer creator, @Nullable Object owner, BankAccountType accountType) {
        BankAccount account = new BankAccount(name, starvalID, creator, owner, accountType);
        bankAccounts.add(account);
    }

    public void deleteBankAccount(BankAccount bankAccount) {
        bankAccounts.remove(bankAccount);
    }

    public List<Bank> getBanks() {
        return banks;
    }
}
