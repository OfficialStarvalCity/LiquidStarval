package de.starvalcity.base.api.def;

import de.starvalcity.base.api.def.database.MySQLAPI;

import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class TableHandler {

    public boolean idExists(int id, String table) {
        int iterator = 0;
        boolean exist = true;

        try {

            ResultSet rs = MySQLAPI.query("SELECT `ID` FROM " + "`" + table + "`" + " WHERE `ID` =" + id + ";");

            while (rs.next()) {
                iterator = rs.getInt("ID");
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        if (!(iterator > 0)) {
            exist = false;
        }
        return exist;
    }

}
