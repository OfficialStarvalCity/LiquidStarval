package de.starvalcity.base.api.handling.economy;

import de.starvalcity.base.Pluginbase;
import de.starvalcity.base.api.def.StarvalPlayer;
import de.starvalcity.base.api.def.database.MySQLAPI;
import de.starvalcity.base.api.def.economy.Bank;
import de.starvalcity.base.api.def.economy.BankAccount;
import de.starvalcity.base.api.def.economy.Company;
import de.starvalcity.base.api.handling.SQLManager;
import org.jetbrains.annotations.NotNull;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class EconomySQL {

    private static Pluginbase pluginbase = new Pluginbase();

    /**
     * Standard Geldmenge Setter
     * Setzt die standardisierte Menge an Geld für ein Objekt.
     * @param economyObject Objekt, für welches die Geldmenge gesetzt werden soll
     */
    public void setDefaultBalance(Object economyObject) {
        int objectId = SQLManager.getObjectId(economyObject);
        if (economyObject instanceof Bank) {
            Bank bank = (Bank) economyObject;
            String name = bank.getName();
            MySQLAPI.update("INSERT INTO `LiquidBanks` (`ID`, `Name`, `Balance`) VALUES ('" +
                    objectId + "','" + name + "','" + 1000 + "');");
            pluginbase.getLogHandler().sqlInfo("INSERTION: Objekt - " + bank.getName());
            pluginbase.getLogHandler().sqlInfo("SET: Geldmenge - " + 1000);
        } else if (economyObject instanceof BankAccount) {
            BankAccount bankAccount = (BankAccount) economyObject;
            String name = bankAccount.getName();
            Bank bank = bankAccount.getBank();
            MySQLAPI.update("INSERT INTO `LiquidBankAccounts` (`ID`, `Name`, `Bank`, `Balance`) VALUES ('" +
                    objectId + "','" + name + "','" + bank + "','" + 1000 + "');");
            pluginbase.getLogHandler().sqlInfo("INSERTION: Objekt - " + bankAccount.getName());
            pluginbase.getLogHandler().sqlInfo("SET: Geldmenge - " + 1000);
        } else if (economyObject instanceof Company) {
            Company company = (Company) economyObject;
            String name = company.getName();
            MySQLAPI.update("INSERT INTO `LiquidCompanies` (`ID`, `Name`, `Balance`) VALUES ('" +
                    objectId + "','" + name + "','" + 1000 + "');");
            pluginbase.getLogHandler().sqlInfo("INSERTION: Objekt - " + company.getName());
            pluginbase.getLogHandler().sqlInfo("SET: Geldmenge - " + 1000);
        } else if (economyObject instanceof StarvalPlayer) {
            StarvalPlayer starvalPlayer = (StarvalPlayer) economyObject;
            String name = starvalPlayer.getName();
            UUID uniqueId = starvalPlayer.getUniqueId();
            MySQLAPI.update("INSERT INTO `LiquidPlayers` (`ID`, `UUID`, `Name`, `ReadyCash`, `Balance`) VALUES ('" +
                    objectId + "','" + uniqueId + "','" + name + "','" + 1000 + "','" + 1000 + "');");
            pluginbase.getLogHandler().sqlInfo("INSERTION: Objekt - " + starvalPlayer.getName());
            pluginbase.getLogHandler().sqlInfo("SET: Geldmenge - " + 1000);
        }
    }

    /**
     * Bargeld Getter
     * Gibt die Menge an Bargeld eines Spielers aus der Datenbank wieder.
     * @param starvalPlayer Spieler aus der Datenbank
     * @return Bargeld des Spielers
     */
    public double getReadyCash(@NotNull StarvalPlayer starvalPlayer) {
        int objectId = starvalPlayer.getId();

        double amount = 1000;

        try {
            ResultSet resultSet = MySQLAPI.query("SELECT `ReadyCash` FROM `LiquidPlayers` WHERE `ID`=\"" + objectId + "\";");

            while (resultSet.next()) {
                amount = resultSet.getDouble("ReadyCash");
            }
        } catch (SQLException sqlException) {
            pluginbase.getLogHandler().sqlLog("SELECT `ReadyCash` FROM `LiquidPlayers` WHERE `ID`= " + objectId + ";", sqlException);
        }
        return amount;
    }

    /**
     * Kontostand Getter
     * Gibt den Kontostand eines Bankkontos aus der Datenbank wieder.
     * @param bankAccount Bankkonto aus der Datenbank
     * @return Kontostand des Bankkontos
     */
    public double getBankAccountBalance(@NotNull BankAccount bankAccount) {
        int objectId = bankAccount.getId();

        double amount = 1000;

        try {
            ResultSet resultSet = MySQLAPI.query("SELECT `Balance` FROM `LiquidBankAccounts` WHERE `ID`=\"" + objectId + "\";");

            while (resultSet.next()) {
                amount = resultSet.getDouble("ReadyCash");
            }
        } catch (SQLException sqlException) {
            pluginbase.getLogHandler().sqlLog("SELECT `Balance` FROM `LiquidBankAccounts` WHERE `ID`= " + objectId + ";", sqlException);
        }
        return amount;
    }

    /**
     * Bargeld Setter (Datentyp: Double)
     * Setzt einem Spieler eine bestimmte Menge an Bargeld.
     * @param starvalPlayer Spieler, für welchen das Bargeld gesetzt werden soll
     * @param amount Menge an Bargeld, welches gesetzt werden soll
     */
    public void setReadyCash(@NotNull StarvalPlayer starvalPlayer, double amount) {
        int objectId = starvalPlayer.getId();
        String name = starvalPlayer.getName();
        UUID uniqueId = starvalPlayer.getUniqueId();
        MySQLAPI.update("INSERT INTO `LiquidPlayers` (`ID`, `UUID`, `Name`, `ReadyCash`, `BankBalance`) VALUES ('" +
                objectId + "','" + uniqueId + "','" + name + "','" + amount + "','" + 0 + "');");
        pluginbase.getLogHandler().sqlInfo("INSERTION: Objekt - " + starvalPlayer.getName());
        pluginbase.getLogHandler().sqlInfo("SET: Geldmenge - " + amount);
    }

    /**
     * Bargeld Setter (Datentyp: Integer)
     * Setzt einem Spieler eine bestimmte Menge an Bargeld.
     * @param starvalPlayer Spieler, für welchen das Bargeld gesetzt werden soll
     * @param amount Menge an Bargeld, welche gesetzt werden soll
     */
    public void setReadyCash(@NotNull StarvalPlayer starvalPlayer, int amount) {
        int objectId = starvalPlayer.getId();
        String name = starvalPlayer.getName();
        UUID uniqueId = starvalPlayer.getUniqueId();
        MySQLAPI.update("INSERT INTO `LiquidPlayers` (`ID`, `UUID`, `Name`, `ReadyCash`, `BankBalance`) VALUES ('" +
                objectId + "','" + uniqueId + "','" + name + "','" + amount + "','" + 0 + "');");
        pluginbase.getLogHandler().sqlInfo("INSERTION: Objekt - " + starvalPlayer.getName());
        pluginbase.getLogHandler().sqlInfo("SET: Geldmenge - " + amount);
    }

    /**
     * Bankkonto Geld Setter (Datentyp: Double)
     * Setzt einem Bankkonto eine bestimmte Menge an Geld.
     * @param bankAccount Konto, für welches der Kontostand gesetzt werden soll
     * @param amount Menge an Geld, welche gesetzt werden soll
     */
    public void setBankAccountBalance(@NotNull BankAccount bankAccount, double amount) {
        int objectId = bankAccount.getId();
        String name = bankAccount.getName();
        MySQLAPI.update("INSERT INTO `LiquidBankAccounts` (`ID`, `Name`, `Balance`) VALUES ('" +
                objectId + "','" + name + "','" + amount + "');");
        pluginbase.getLogHandler().sqlInfo("INSERTION: Objekt - " + bankAccount.getName());
        pluginbase.getLogHandler().sqlInfo("SET: Geldmenge - " + amount);
    }

    /**
     * Bankkonto Geld Setter (Datentyp: Integer)
     * Setzt einem Bankkonto eine bestimmte Menge an Geld.
     * @param bankAccount Konto, für welches der Kontostand gesetzt werden soll
     * @param amount Menge an Geld, welche gesetzt werden soll
     */
    public void setBankAccountBalance(@NotNull BankAccount bankAccount, int amount) {
        int objectId = bankAccount.getId();
        String name = bankAccount.getName();
        MySQLAPI.update("INSERT INTO `LiquidBankAccounts` (`ID`, `Name`, `Balance`) VALUES ('" +
                objectId + "','" + name + "','" + amount + "');");
        pluginbase.getLogHandler().sqlInfo("INSERTION: Objekt - " + bankAccount.getName());
        pluginbase.getLogHandler().sqlInfo("SET: Geldmenge - " + amount);
    }

    public void addReadyCash(@NotNull StarvalPlayer starvalPlayer, double amount) {
        int objectId = starvalPlayer.getId();
        String name = starvalPlayer.getName();
        UUID uniqueId = starvalPlayer.getUniqueId();
        double previousAmount = getReadyCash(starvalPlayer);
        double currentAmount = previousAmount + amount;
        MySQLAPI.update("INSERT INTO `LiquidPlayers` (`ID`, `UUID`, `Name`, `ReadyCash`) VALUES ('" +
                objectId + "','" + uniqueId + "','" + name + "','" + currentAmount + "');");
    }

    public void addReadyCash(@NotNull StarvalPlayer starvalPlayer, int amount) {
        int objectId = starvalPlayer.getId();
        String name = starvalPlayer.getName();
        UUID uniqueId = starvalPlayer.getUniqueId();
        double previousAmount = getReadyCash(starvalPlayer);
        double currentAmount = previousAmount + amount;
        MySQLAPI.update("INSERT INTO `LiquidPlayers` (`ID`, `UUID`, `Name`, `ReadyCash`) VALUES ('" +
                objectId + "','" + uniqueId + "','" + name + "','" + currentAmount + "');");
    }


}
