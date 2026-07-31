package COLLECTIONS.Map;
import java.util.LinkedHashMap; //import LinkedHashMap
import java.util.Map; //import Map interface

public class LinkedHashMapCollection {
    public static void main(String[] args) {
        LinkedHashMap<String, String> lhm = new LinkedHashMap<>(); //create a LinkedHashMap (default insertion order)

        //adding key-value pairs (LinkedHashMap preserves key insertion order):
        lhm.put("One", "First");
        lhm.put("Two", "Second");
        lhm.put("Three", "Third");
        lhm.put("One", "Updated First"); //updating value for duplicate key
        
        System.out.println("LinkedHashMap elements (preserves key insertion order): " + lhm);

        //accessing values:
        String val = lhm.get("Two");
        System.out.println("Value for key 'Two': " + val);

        //checking if key exists:
        boolean containsThree = lhm.containsKey("Three");
        System.out.println("Contains key 'Three'? " + containsThree);

        //removing elements:
        lhm.remove("Three");
        System.out.println("After removing 'Three': " + lhm);

        //LinkedHashMap with access order configuration (useful for LRU cache implementation):
        //Parameters: initialCapacity, loadFactor, accessOrder (true for access-order, false for insertion-order)
        LinkedHashMap<String, Integer> accessOrderMap = new LinkedHashMap<>(16, 0.75f, true);
        accessOrderMap.put("A", 100);
        accessOrderMap.put("B", 200);
        accessOrderMap.put("C", 300);
        
        System.out.println("Access-order map before access: " + accessOrderMap);
        accessOrderMap.get("B"); //accesses key B, moving it to the end
        accessOrderMap.get("A"); //accesses key A, moving it to the end
        System.out.println("Access-order map after accessing 'B' and 'A': " + accessOrderMap);

        //iterating over entries:
        System.out.println("Iterating over LinkedHashMap:");
        for (Map.Entry<String, String> entry : lhm.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
