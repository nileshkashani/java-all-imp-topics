package Collections.Set;
import java.util.Comparator; //import Comparator
import java.util.TreeSet; //import TreeSet

public class TreeSetCollection {
    public static void main(String[] args) {
        TreeSet<Integer> ts = new TreeSet<>(); //create a TreeSet of Integers

        //adding elements (TreeSet stores elements in natural sorted order):
        ts.add(40);
        ts.add(10);
        ts.add(30);
        ts.add(20);
        ts.add(10); //attempting to add duplicate element
        
        System.out.println("TreeSet elements (sorted automatically): " + ts);

        //navigation methods:
        System.out.println("First (lowest) element: " + ts.first()); //gets the first element
        System.out.println("Last (highest) element: " + ts.last()); //gets the last element
        
        //range/proximity methods:
        System.out.println("Higher than 20: " + ts.higher(20)); //returns the least element strictly greater than 20
        System.out.println("Lower than 20: " + ts.lower(20)); //returns the greatest element strictly less than 20
        System.out.println("Ceiling of 25: " + ts.ceiling(25)); //returns least element >= 25
        System.out.println("Floor of 25: " + ts.floor(25)); //returns greatest element <= 25

        //retrieving subsets/ranges:
        System.out.println("HeadSet (elements < 30): " + ts.headSet(30)); //returns view of elements < 30
        System.out.println("TailSet (elements >= 20): " + ts.tailSet(20)); //returns view of elements >= 20
        System.out.println("SubSet (20 <= elements < 40): " + ts.subSet(20, 40)); //returns view between 20 and 40

        //TreeSet with custom sorting order (using a comparator):
        TreeSet<String> customSortedSet = new TreeSet<>(Comparator.reverseOrder()); //sorts in reverse alphabetical order
        customSortedSet.add("Apple");
        customSortedSet.add("Banana");
        customSortedSet.add("Orange");
        System.out.println("Reverse sorted TreeSet: " + customSortedSet);

        //checking if element exists:
        boolean contains30 = ts.contains(30); //checks if 30 is in the set
        System.out.println("Contains 30? " + contains30);

        //removing elements:
        ts.remove(30); //removes 30 from the set
        System.out.println("After removing 30: " + ts);

        //checking size:
        System.out.println("Size of TreeSet: " + ts.size()); //gets size of the set

        //iterating over the set using a for-each loop:
        System.out.println("Iterating over sorted elements:");
        for (Integer num : ts) {
            System.out.println(num);
        }
    }
}
