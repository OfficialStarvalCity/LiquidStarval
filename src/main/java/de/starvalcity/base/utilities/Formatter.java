package de.starvalcity.base.utilities;

import org.jetbrains.annotations.Nullable;

/**
 * Der {@link Formatter} sorgt für die Formatierung und Übersetzung von Schriftzeichen zum internationalen Standard.
 */
public class Formatter {

    public static String escapeQuotes(@Nullable String string) {
        if (string == null) {
            return "";
        }
        return string.replace("'", "''");
    }


}
