package Collections.Map;
import java.util.Comparator; //import Comparator
import java.util.TreeMap; //import TreeMap
import java.util.Map; //import Map interface

public class TreeMapCollection {
    public static void main(String[] args) {
        TreeMap<Integer, String> tm = new TreeMap<>(); //create a TreeMap (keys sorted automatically)

        //adding key-value pairs using put:
        tm.put(3, "Three");
        tm.put(1, "One");
        tm.put(4, "Four");
        tm.put(2, "Two");
        tm.put(1, "Updated One"); //updating value for duplicate key
        
        System.out.println("TreeMap elements (keys sorted automatically): " + tm);

        //accessing values:
        System.out.println("Value for key 2: " + tm.get(2));

        //navigation methods (returning keys or entries):
        System.out.println("First (lowest) key: " + tm.firstKey()); //gets the first key
        System.out.println("Last (highest) key: " + tm.lastKey()); //gets the last key
        System.out.println("First entry: " + tm.firstEntry()); //gets the first key-value entry
        
        //proximity methods:
        System.out.println("Key higher than 2: " + tm.higherKey(2)); //returns lowest key > 2
        System.out.println("Key lower than 2: " + tm.lowerKey(2)); //returns highest key < 2
        System.out.println("Ceiling entry of 3: " + tm.ceilingEntry(3)); //returns entry for least key >= 3

        //submaps/views:
        System.out.println("HeadMap (keys < 3): " + tm.headMap(3)); //returns view of keys < 3
        System.out.println("TailMap (keys >= 2): " + tm.tailMap(2)); //returns view of keys >= 2
        System.out.println("SubMap (1 <= keys < 4): " + tm.subMap(1, 4)); //returns view for keys 1 to 4

        //TreeMap with custom sorting order (using a comparator on keys):
        TreeMap<String, Integer> customSortedMap = new TreeMap<>(Comparator.reverseOrder());
        customSortedMap.put("Orange", 1);
        customSortedMap.put("Apple", 2);
        customSortedMap.put("Banana", 3);
        System.out.println("Reverse sorted keys TreeMap: " + customSortedMap);

        //removing elements:
        tm.remove(4); //removes key 4
        System.out.println("After removing key 4: " + tm);

        //iterating over TreeMap:
        System.out.println("Iterating over sorted TreeMap entries:");
        for (Map.Entry<Integer, String> entry : tm.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}
