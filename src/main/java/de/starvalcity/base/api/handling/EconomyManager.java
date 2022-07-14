package de.starvalcity.base.api.handling;

import de.starvalcity.base.Pluginbase;
import de.starvalcity.base.api.def.database.MySQLAPI;
import de.starvalcity.base.api.def.economy.BankAccount;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EconomyManager {

    private static Pluginbase pluginbase = new Pluginbase();

    public void attachBankAccount(BankAccount bankAccountObject, Object accountHolder) {
        int objectId = ObjectManager.getObjectId(bankAccountObject);
        pluginbase.getObjectManager().attachObject(bankAccountObject);
        if (!economyObjectExists(bankAccountObject)) {
            if (!idExists(objectId)) {
                MySQLAPI.update("INSERT INTO `LiquidEconomy` " +
                        "(`Object`, `Id`, `AccountHolder`) VALUES ('" + bankAccountObject + "','" + objectId + "','" + accountHolder + "');");
                pluginbase.getLogHandler().sqlInfo("Attaching: Object successfully attached and saved to database.");
            } else {
                pluginbase.getLogHandler().sqlCustomError("Attaching: Object already attached.", null);
            }
        } else {
            pluginbase.getLogHandler().sqlCustomError("Attaching: Object already attached.", null);
        }
    }

    public boolean economyObjectExists(Object economyObject) {
        ResultSet resultSet = MySQLAPI.query("SELECT `Object` FROM `LiquidEconomy` WHERE `Object` = \"" + economyObject + "\";");
        try {
            return resultSet.next();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return false;
    }

    public boolean idExists(int id) {
        int iterator = 0;
        boolean exist = true;
        try {

            ResultSet rs = MySQLAPI.query("SELECT `Id` FROM `LiquidEconomy` WHERE `Id` = " + id + ";");

            while (rs.next()) {
                iterator = rs.getInt("Id");
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        if(!(iterator > 0)) {
            exist = false;
        }
        return exist;
    }
}
