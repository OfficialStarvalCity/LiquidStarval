package de.starvalcity.base.api.handling.economy;

import de.starvalcity.base.Pluginbase;
import de.starvalcity.base.api.def.TableHandler;
import de.starvalcity.base.api.def.database.MySQLAPI;
import de.starvalcity.base.api.def.economy.Bank;
import de.starvalcity.base.api.def.economy.BankAccount;
import de.starvalcity.base.api.def.economy.Company;
import de.starvalcity.base.api.def.economy.EconomyObjectType;
import de.starvalcity.base.api.handling.object.ObjectSQLManager;
import org.jetbrains.annotations.NotNull;

import java.util.logging.Level;

/**
 * Der {@link EconomySQLManager} sorgt für die Verwaltung der wirtschaftlichen MySQL Tabellen.
 */
public class EconomySQLManager extends TableHandler {

    private static Pluginbase pluginbase = new Pluginbase();

    public void addToTable(@NotNull EconomyObjectType economyObjectType) {
        int id = ObjectSQLManager.getObjectId(economyObjectType.toString());

        if (economyObjectType.toString().equalsIgnoreCase("bank")) {

            Bank bank = (Bank) ObjectSQLManager.getObject(id);
            ObjectSQLManager.attachObject(economyObjectType.toString());
            MySQLAPI.update("INSERT INTO `LiquidBanks` (`ID`, `Name`, `Founder`, `Owner`, `Balance`, `Accounts`) VALUES ('" +
                    id + "','" + bank.getName() + "','" + bank.getFounder() + "','" + bank.getOwner() + "','" + bank.getBalance() + "','" +
                    bank.getBankAccounts().size() + "');");
            pluginbase.getLogHandler().logWithLevel("Attaching - Success > Bank successfully attached.", Level.INFO);

        } else if (economyObjectType.toString().equalsIgnoreCase("bank_account")) {

            BankAccount bankAccount = (BankAccount) ObjectSQLManager.getObject(id);
            ObjectSQLManager.attachObject(economyObjectType.toString());
            MySQLAPI.update("INSERT INTO `LiquidBankAccounts` (`ID`, `Name`, `Bank`, `Founder`, `Owner`, `Moderators`, `Members`, `Balance`) " +
                    " VALUES ('" + id + "','" + bankAccount.getName() + "','" + bankAccount.getBank() + "','" + bankAccount.getCreator() + "','" +
                    bankAccount.getOwner() + "','" + null + bankAccount.getMembers() + "','" + bankAccount.getBalance() + "');");
            pluginbase.getLogHandler().logWithLevel("Attaching - Success > Bank Account successfully attached.", Level.INFO);

        } else if (economyObjectType.toString().equalsIgnoreCase("company")) {

            Company company = (Company) ObjectSQLManager.getObject(id);
            ObjectSQLManager.attachObject(economyObjectType.toString());
            MySQLAPI.update("INSERT INTO `LiquidCompanies` (`ID`, `Name`, `Founder`, `Owner`, `Balance`) VALUES ('" +
                    id + "','" + company.getName() + "','" + company.getFounder() + "','" + company.getOwners() + "','" +
                    company.getBalance() + "');");
            pluginbase.getLogHandler().logWithLevel("Attaching - Success > Company successfully attached.", Level.INFO);

        } else if (economyObjectType.toString().equalsIgnoreCase("Transaction")) {

            ObjectSQLManager.attachObject(economyObjectType.toString());
            // TODO - Add to specific table
            pluginbase.getLogHandler().logWithLevel("Attaching - Success > Transaction successfully attached.", Level.INFO);

        }
    }

    @Override
    public boolean databaseObjectExists(int id, String table) {
        return super.databaseObjectExists(id, table);
    }
}
