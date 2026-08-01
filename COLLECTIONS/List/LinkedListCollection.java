package Collections.List;
import java.util.LinkedList; //import LinkedList

public class LinkedListCollection {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(); //create a LinkedList of Strings

        //adding elements:
        list.add("Java"); //adds element to the end
        list.add("Python");
        list.add("C++");
        
        //adding elements at specific positions:
        list.addFirst("JavaScript"); //adds element at the beginning
        list.addLast("Kotlin"); //adds element at the end
        
        System.out.println("Initial LinkedList: " + list);

        //accessing elements:
        String firstElement = list.getFirst(); //gets the first element
        String lastElement = list.getLast(); //gets the last element
        String indexElement = list.get(2); //gets element at index 2
        
        System.out.println("First element: " + firstElement);
        System.out.println("Last element: " + lastElement);
        System.out.println("Element at index 2: " + indexElement);

        //updating elements:
        list.set(2, "TypeScript"); //replaces element at index 2
        System.out.println("After replacement: " + list);

        //checking if element exists:
        boolean containsPython = list.contains("Python"); //checks if Python is in the list
        System.out.println("Contains Python? " + containsPython);

        //Queue and Deque operations (peek, poll, offer):
        System.out.println("Peek first: " + list.peekFirst()); //retrieves but does not remove first element
        System.out.println("Peek last: " + list.peekLast()); //retrieves but does not remove last element
        
        list.offer("Go"); //adds to the tail (end) of the list
        System.out.println("After offer('Go'): " + list);
        
        String polled = list.poll(); //retrieves and removes the first element (head)
        System.out.println("Polled element: " + polled);
        System.out.println("After poll: " + list);

        //removing elements:
        list.removeFirst(); //removes the first element
        list.removeLast(); //removes the last element
        list.remove(1); //removes element at index 1
        
        System.out.println("After removals: " + list);
        System.out.println("Size of LinkedList: " + list.size()); //gets size of the list

        //iterating over the list using a for-each loop:
        System.out.println("Iterating over elements:");
        for (String lang : list) {
            System.out.println(lang);
        }
    }
}
