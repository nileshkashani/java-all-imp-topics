package Collections.List;
import java.util.ArrayList; //import ArrayList
import java.util.Collections; //import Collections utility class for sorting

public class ArrayListCollection {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>(); //create new ArrayList object al

        //adding elements: 
        al.add(5);
        al.add(3);
        al.add(8);
        al.add(1);
        al.add(2);
        System.out.println("Initial ArrayList: " + al);

        //adding element at specific index:
        al.add(2, 10); //inserts 10 at index 2
        System.out.println("After insertion at index 2: " + al);

        //accessing elements:
        int value = al.get(3); //gets element at index 3
        System.out.println("Element at index 3: " + value);

        //updating elements:
        al.set(1, 20); //updates element at index 1 to 20
        System.out.println("After update: " + al);

        //checking size and if empty:
        System.out.println("Size of ArrayList: " + al.size());
        System.out.println("Is empty? " + al.isEmpty());

        //checking if element exists:
        System.out.println("Contains 8? " + al.contains(8));
        System.out.println("Index of 10: " + al.indexOf(10)); //finds first occurrence of 10

        //removing elements:
        al.remove(0); //removes element at index 0
        al.remove(Integer.valueOf(8)); //removes the element 8 by object wrapper
        System.out.println("After removals: " + al);

        //sorting the ArrayList:
        Collections.sort(al); //sorts elements in natural ascending order
        System.out.println("Sorted ArrayList: " + al);

        //iterating over ArrayList:
        System.out.println("Iterating using for-each:");
        for (Integer num : al) {
            System.out.println(num);
        }

        //clearing all elements:
        al.clear(); //removes all elements
        System.out.println("After clear, size: " + al.size());
    }
}