package de.starvalcity.base.api.def.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * SQL Functions class
 */
public class SQLFunctions {

    private MySQLAPI mySQLAPI;

    public SQLFunctions(MySQLAPI mySQLAPI) {
        this.mySQLAPI = mySQLAPI;
    }

    /**
     * Integer Getter
     *
     * @param table      Targeted Table-Name
     * @param column     Targeted Column
     * @param identifier Column you target for
     * @param value      Value you target for
     * @return Returns the Integer you are searching for or '0'
     */
    public int getInteger(String table, String column, Object identifier, String value) {
        try {
            ResultSet resultSet = mySQLAPI.getConnection().prepareStatement
                    ("SELECT * FROM " + table + " WHERE " + identifier + " = '" + value + "'").executeQuery();
            if (resultSet.next()) return resultSet.getInt(column);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return 0;
    }


    /**
     * Double Getter
     *
     * @param table      Targeted Table-Name
     * @param column     Targeted Column
     * @param identifier Column you target for
     * @param value      Value you target for
     * @return Returns the Double you are searching for or '0'
     */
    public double getDouble(String table, String column, Object identifier, String value) {
        try {
            ResultSet resultSet = mySQLAPI.getConnection().prepareStatement
                    ("SELECT * FROM " + table + " WHERE " + identifier + " = '" + value + "'").executeQuery();
            if (resultSet.next()) return resultSet.getDouble(column);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return 0;
    }

    /**
     * String Getter
     *
     * @param table      Targeted Table-Name
     * @param column     Targeted Column
     * @param identifier Column you target for
     * @param value      Value you target for
     * @return Returns the String you are searching for or 'null'
     */
    public String getString(String table, String column, Object identifier, String value) {
        try {
            ResultSet resultSet = mySQLAPI.getConnection().prepareStatement
                    ("SELECT * FROM " + table + " WHERE " + identifier + " = '" + value + "'").executeQuery();
            if (resultSet.next()) return resultSet.getString(column);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    /**
     * Boolean Getter
     *
     * @param table      Targeted Table-Name
     * @param column     Targeted Column
     * @param identifier Column you target for
     * @param value      Value you target for
     * @return Returns the Boolean you are searching for or 'false'
     */
    public boolean getBoolean(String table, String column, Object identifier, String value) {
        try {
            ResultSet resultSet = mySQLAPI.getConnection().prepareStatement
                    ("SELECT * FROM " + table + " WHERE " + identifier + " = '" + value + "'").executeQuery();
            if (resultSet.next()) return resultSet.getBoolean(column);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return false;
    }

    /**
     * Long Getter
     *
     * @param table      Targeted Table-Name
     * @param column     Targeted Column
     * @param identifier Column you target for
     * @param value      Value you target for
     * @return Returns the Long you are searching for or 'null'
     */
    public Long getLong(String table, String column, Object identifier, String value) {
        try {
            ResultSet resultSet = mySQLAPI.getConnection().prepareStatement
                    ("SELECT * FROM " + table + " WHERE " + identifier + " = '" + value + "'").executeQuery();
            if (resultSet.next()) return resultSet.getLong(column);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    /**
     * Float Getter
     *
     * @param table      Targeted Table-Name
     * @param column     Targeted Column
     * @param identifier Column you target for
     * @param value      Value you target for
     * @return Returns the Float you are searching for or 'null'
     */
    public Float getFloat(String table, String column, Object identifier, String value) {
        try {
            ResultSet resultSet = mySQLAPI.getConnection().prepareStatement
                    ("SELECT * FROM " + table + " WHERE " + identifier + " = '" + value + "'").executeQuery();
            if (resultSet.next()) return resultSet.getFloat(column);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    /**
     * Method to return all entries for the give Column in the given Table
     *
     * @param table  Targeted Table-Name
     * @param column Targeted Column
     * @return Returns the Column you are searching for
     */
    public List<String> getResultsString(String table, String column) {
        List<String> list = new ArrayList<>();

        try {
            ResultSet resultSet = mySQLAPI.getConnection().prepareStatement("SELECT " + column + " FROM " + table).executeQuery();
            while (resultSet.next())
                list.add(resultSet.getString(column));

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return list;
    }

    /**
     * Method to return all entries for the give Column in the given Table
     *
     * @param table  Targeted Table-Name
     * @param column Targeted Column
     * @return Returns the Column you are searching for
     */
    public List<Integer> getResultsInteger(String table, String column) {
        List<Integer> list = new ArrayList<>();

        try {
            ResultSet resultSet = mySQLAPI.getConnection().prepareStatement("SELECT " + column + " FROM " + table).executeQuery();
            while (resultSet.next())
                list.add(resultSet.getInt(column));

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return list;
    }

    /**
     * Method to return a List value from an Text Column
     *
     * @param table      Targeted Table-Name
     * @param column     Targeted Column
     * @param identifier Column you target for
     * @param value      Value you target for
     * @return Returns the List you are searching for
     */
    public List<String> getList(String table, String column, Object identifier, String value) {
        List<String> list = new LinkedList<>();
        try {
            ResultSet resultSet = mySQLAPI.getConnection().prepareStatement
                    ("SELECT * FROM " + table + " WHERE " + identifier + " = '" + value + "'").executeQuery();
            if (resultSet.next()) {
                String s = resultSet.getString(column);
                if (s != null && !s.equalsIgnoreCase("[]")) {
                    String[] arrayOfString;
                    int i = (arrayOfString = s.replace("[", "").replace("]", "").split(", ")).length;

                    for (byte b = 0; b < i; ++b) {
                        String string = arrayOfString[b];
                        list.add(string.trim());
                    }
                }
            }
        } catch (SQLException var3) {
            var3.printStackTrace();
        }
        return list;
    }

    /**
     * Method to check if a Table contains content
     * @param table Targeted Table-Name
     * @return Returns true if the Table contains content
     */
    public boolean nullCheck(String table) {
        try {
            ResultSet resultSet = mySQLAPI.getConnection().prepareStatement("SELECT * From " + table).executeQuery();
            if(resultSet.next())
                return true;
            else
                return false;
        } catch (SQLException var3) {
            var3.printStackTrace();
            return false;
        }
    }

    /**
     * Method to check if a Table exists
     * @param table
     * @return Returns true if the Table exists
     */
    public boolean tableExists(String table) {
        try {
            ResultSet resultSet = mySQLAPI.getDatabaseMetaData().getTables(null, null, table, null);
            return resultSet.next();
        } catch (SQLException var3) {
            var3.printStackTrace();
            return false;
        }
    }

    /**
     * Method to get the Database
     *
     * @return Database
     */
    public MySQLAPI getMySQLAPI() {
        return mySQLAPI;
    }

    /**
     * Method to set the Database
     *
     * @param database Database to set
     */
    public void setDatabase(MySQLAPI mySQLAPI) {
        this.mySQLAPI = mySQLAPI;
    }

}
