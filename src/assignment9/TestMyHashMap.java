package assignment9;

/*
 * Course: CS 3401
 * Section:
 * Name: Thomas Hamilton
 * Professor: Alan Shaw
 * Assignment #: 9
 */

public class TestMyHashMap {
    public static void main(String[] args) {
        // Create a map
        MyMap<String, Integer> map = new MyHashMap<String, Integer>();

        map.put("Smith", 30);
        map.put("Anderson", 31);
        map.put("Lewis", 29);
        map.put("Cook", 29);
        map.put("Smith", 65);

        System.out.println("Entries in map: " + map);

        System.out.println("The age for " + "Lewis is " +
                map.get("Lewis"));

        System.out.println("Is Smith in the map? " +
                map.containsKey("Smith"));
        System.out.println("Is age 33 in the map? " +
                map.containsValue(33));

        System.out.println("Entries in map: " + map);

        System.out.println("Get all entries that match key: " + map.getAll("Smith"));

        map.remove("Smith");

        map.clear();
        System.out.println("Entries in map: " + map);
    }
}