package de.starvalcity.base.api.def;

public abstract class DatabaseObject {

    public abstract void setValue(String statement, String table, String column, Object value);

}
