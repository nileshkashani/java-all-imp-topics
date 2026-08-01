package Collections.Set;
import java.util.HashSet; //import HashSet

public class HashSetCollection {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>(); //create a HashSet of Strings

        //adding elements:
        set.add("Apple");
        set.add("Banana");
        set.add("Orange");
        set.add("Apple"); //attempting to add duplicate element
        
        System.out.println("HashSet elements (no duplicates, unordered): " + set);

        //checking if element exists:
        boolean containsBanana = set.contains("Banana"); //checks if Banana is in the set
        System.out.println("Contains Banana? " + containsBanana);

        //checking size and if empty:
        System.out.println("Size of HashSet: " + set.size()); //gets size of the set
        System.out.println("Is HashSet empty? " + set.isEmpty()); //checks if set is empty

        //removing elements:
        set.remove("Orange"); //removes Orange from the set
        System.out.println("After removing Orange: " + set);

        //demonstrating Set math operations (Union, Intersection, Difference):
        HashSet<String> anotherSet = new HashSet<>();
        anotherSet.add("Banana");
        anotherSet.add("Mango");
        anotherSet.add("Grapes");
        
        System.out.println("Another Set: " + anotherSet);

        //1. Subset check:
        System.out.println("Is anotherSet a subset of set? " + set.containsAll(anotherSet));

        //2. Intersection:
        HashSet<String> intersection = new HashSet<>(set);
        intersection.retainAll(anotherSet); //keeps only elements present in both sets
        System.out.println("Intersection: " + intersection);

        //3. Difference (set - anotherSet):
        HashSet<String> difference = new HashSet<>(set);
        difference.removeAll(anotherSet); //removes all elements of anotherSet from set
        System.out.println("Difference (set - anotherSet): " + difference);

        //4. Union:
        HashSet<String> union = new HashSet<>(set);
        union.addAll(anotherSet); //merges both sets
        System.out.println("Union: " + union);

        //iterating over the set using a for-each loop:
        System.out.println("Iterating over elements:");
        for (String fruit : set) {
            System.out.println(fruit);
        }

        //clearing all elements:
        set.clear(); //removes all elements from the set
        System.out.println("After clear, size: " + set.size());
    }
}
