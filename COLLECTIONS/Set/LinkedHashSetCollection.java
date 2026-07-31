package COLLECTIONS.Set;
import java.util.ArrayList; //import ArrayList
import java.util.LinkedHashSet; //import LinkedHashSet

public class LinkedHashSetCollection {
    public static void main(String[] args) {
        LinkedHashSet<String> lhs = new LinkedHashSet<>(); //create a LinkedHashSet of Strings

        //adding elements (LinkedHashSet maintains insertion order):
        lhs.add("Dog");
        lhs.add("Cat");
        lhs.add("Elephant");
        lhs.add("Dog"); //attempting to add duplicate element
        
        System.out.println("LinkedHashSet elements (preserves insertion order): " + lhs);

        //checking if element exists:
        boolean containsCat = lhs.contains("Cat"); //checks if Cat is in the set
        System.out.println("Contains Cat? " + containsCat);

        //removing elements:
        lhs.remove("Elephant"); //removes Elephant from the set
        System.out.println("After removing Elephant: " + lhs);

        //converting LinkedHashSet to an Array:
        String[] animalArray = lhs.toArray(new String[0]); //converts set to array
        System.out.println("Array length from set: " + animalArray.length);

        //practical use case: removing duplicates from a List while preserving order:
        ArrayList<Integer> numberList = new ArrayList<>();
        numberList.add(5);
        numberList.add(2);
        numberList.add(5);
        numberList.add(9);
        numberList.add(2);
        System.out.println("List with duplicates: " + numberList);
        
        LinkedHashSet<Integer> uniqueNumbers = new LinkedHashSet<>(numberList); //removes duplicates & keeps order
        System.out.println("LinkedHashSet (no duplicates, order kept): " + uniqueNumbers);

        //checking size:
        System.out.println("Size of LinkedHashSet: " + lhs.size()); //gets size of the set

        //iterating over the set using a for-each loop:
        System.out.println("Iterating over elements:");
        for (String animal : lhs) {
            System.out.println(animal);
        }
    }
}
