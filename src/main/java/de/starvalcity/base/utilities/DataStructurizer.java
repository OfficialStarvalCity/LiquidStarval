package de.starvalcity.base.utilities;

import java.util.*;

/**
 * Der {@link DataStructurizer} sorgt für die Strukturierung und Konvertierung von internen Datenstrukturen.
 */
public class DataStructurizer {

    /**
     * Map Sortierung
     * Sortiert eine Map nach einem bestimmten Wert.
     * @param map Map, welche sortiert werden soll
     * @return sortierte LinkedHashMap
     * @param <K> Index
     * @param <V> Wert
     */
    public static <K, V extends Comparable<V>> Map<K, V> sortByValue(Map<K, V> map) {
        LinkedList<Map.Entry<K, V>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort(Map.Entry.comparingByValue());

        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : entryList) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

    /**
     * String Konvertierung
     * Konvertiert ein String Array zu einem Array um.
     * @param list Liste, welche konvertiert werden soll
     * @return Array aus dem String Array
     */
    public static String[] toArray(List<String> list) {
        return list.toArray(new String[0]);
    }

    /**
     * Array Konvertierung
     * Konvertiert ein Array zu einem HashSet.
     * @param values Werte aus dem Array, welche konvertiert werden sollen
     * @return HashSet aus dem Array
     */
    public static Set<String> fromArrayToSet(String... values) {
        HashSet<String> results = new HashSet<>();
        Collections.addAll(results, values);
        results.remove("");
        return results;
    }

    /**
     * Array-Liste Konvertierung
     * Konvertiert ein Array zu einer Liste.
     * @param values Werte aus dem Array, welche konvertiert werden sollen
     * @return Liste aus dem Array
     */
    public static List<String> fromArrayToList(String... values) {
        List<String> results = new ArrayList<>();
        Collections.addAll(results, values);
        results.remove("");
        return results;
    }



}
