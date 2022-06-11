package de.starvalcity.base.utilities;

import org.jetbrains.annotations.Nullable;

public class Formatter {

    public static String escapeQuotes(@Nullable String string) {
        if (string == null) {
            return "";
        }
        return string.replace("'", "''");
    }


}
