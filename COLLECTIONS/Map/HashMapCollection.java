package COLLECTIONS.Map;
import java.util.HashMap; //import HashMap
import java.util.Map; //import Map interface

public class HashMapCollection {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>(); //create a HashMap (Key: String, Value: Integer)

        //adding key-value pairs using put:
        map.put("Alice", 25);
        map.put("Bob", 30);
        map.put("Charlie", 35);
        map.put("Alice", 28); //updating value for duplicate key "Alice"
        
        System.out.println("HashMap elements (unordered, unique keys): " + map);

        //putIfAbsent (inserts only if key doesn't exist):
        map.putIfAbsent("Bob", 40); //will not insert as Bob already exists
        map.putIfAbsent("David", 45); //will insert
        System.out.println("After putIfAbsent checks: " + map);

        //accessing values & getOrDefault:
        Integer aliceAge = map.get("Alice"); //gets value for key "Alice"
        System.out.println("Alice's age: " + aliceAge);
        System.out.println("Emma's age (getOrDefault): " + map.getOrDefault("Emma", 0)); //returns 0 since Emma is not present

        //replacing elements:
        map.replace("Bob", 32); //replaces Bob's age with 32
        System.out.println("After replacing Bob's value: " + map);

        //checking if key or value exists:
        boolean hasBob = map.containsKey("Bob"); //checks if key Bob exists
        boolean hasAge35 = map.containsValue(35); //checks if value 35 exists
        System.out.println("Contains key 'Bob'? " + hasBob);
        System.out.println("Contains value 35? " + hasAge35);

        //removing elements:
        map.remove("Charlie"); //removes key "Charlie" and its value
        System.out.println("After removing Charlie: " + map);

        //checking size:
        System.out.println("Size of HashMap: " + map.size()); //gets size of the map

        //iterating over HashMap keys:
        System.out.println("Iterating over keys:");
        for (String key : map.keySet()) {
            System.out.println("Key: " + key);
        }

        //iterating over HashMap values:
        System.out.println("Iterating over values:");
        for (Integer value : map.values()) {
            System.out.println("Value: " + value);
        }

        //iterating over HashMap entries (Key-Value pairs):
        System.out.println("Iterating over key-value entries:");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
    }
}
