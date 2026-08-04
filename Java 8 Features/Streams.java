// The Stream API in Java 8 is used to process collections of objects in a functional style.
// A Stream is a sequence of elements supporting sequential and parallel aggregate operations.
// Note: Streams do NOT store data; they operate on a source (like a List, Set, or Array) and do not modify the original source.

// A Stream pipeline consists of three steps:
// 1. Source: Where the elements come from (e.g., Collection, Array, Generator function).
// 2. Intermediate Operations: Transforming the stream into another stream (e.g., filter, map, sorted).
//    - Intermediate operations are LAZY; they are not executed until a terminal operation is called.
// 3. Terminal Operation: Triggers execution and produces a result or side-effect (e.g., forEach, collect, reduce, count).
//    - Once a terminal operation is invoked, the stream is consumed and cannot be reused.
//
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {

        // ====================================================
        // PART 1: Different Ways to Create a Stream
        // ====================================================
        System.out.println("=== Part 1: Stream Creation ===");

        // 1.1 Creating a Stream from an Array using Arrays.stream(array)
        int[] intArray = {1, 2, 3, 4, 5};
        System.out.print("Stream from Array: ");
        Arrays.stream(intArray) // Creates an IntStream
            .forEach(val -> System.out.print(val + " ")); // Terminal operation printing each value
        System.out.println();

        // 1.2 Creating a Stream from a Collection using Collection.stream()
        List<Integer> list = Arrays.asList(5, 4, 3, 2, 1);
        System.out.print("Sorted Stream from List: ");
        list.stream() // Creates Stream<Integer>
            .sorted() // Intermediate operation: sorts elements in natural order
            .forEach(val -> System.out.print(val + " ")); // Terminal operation
        System.out.println();

        // 1.3 Creating a Stream using Stream.of()
        System.out.print("Stream from Stream.of(): ");
        Stream.of("Apple", "Banana", "Cherry", "Date", "Elderberry")
            .filter(str -> str.length() > 4) // Intermediate operation: filters words with length > 4
            .forEach(str -> System.out.print(str + " ")); // Terminal operation
        System.out.println();

        // 1.4 Creating an infinite Stream using Stream.iterate() and limiting it
        System.out.print("Stream using Stream.iterate(): ");
        Stream.iterate(0, i -> i + 1) // Generates infinite sequence: 0, 1, 2, 3...
            .limit(10) // Intermediate operation: stops after 10 elements
            .forEach(val -> System.out.print(val + " ")); // Terminal operation
        System.out.println();


        // ====================================================
        // PART 2: Demonstrating Lazy Evaluation
        // ====================================================
        System.out.println("\n=== Part 2: Lazy Evaluation Demonstration ===");
        
        List<String> names = Arrays.asList("Alex", "Brian", "Charles");

        // We create a stream pipeline, apply intermediate operations, but NO terminal operation yet
        Stream<String> nameStream = names.stream()
            .filter(name -> {
                System.out.println("Filter executed for: " + name);
                return name.startsWith("B");
            })
            .map(name -> {
                System.out.println("Map executed for: " + name);
                return name.toUpperCase();
            });

        System.out.println("Stream pipeline created, but terminal operation has NOT been called yet.");
        System.out.println("Calling terminal operation now:");
        // Once a terminal operation is called (like forEach), filter and map actually run
        nameStream.forEach(name -> System.out.println("Terminal Output: " + name));


        // ====================================================
        // PART 3: Key Stream Operations
        // ====================================================
        System.out.println("\n=== Part 3: Intermediate and Terminal Operations ===");

        List<Integer> inputNumbers = List.of(1, 2, 3, 4, 5, 6, 2, 4, 5, 6, 3, 2, 4, 4);

        // 3.1 count() - Count the number of distinct even squares
        long count = inputNumbers.stream()
            .filter(num -> num % 2 == 0)      // Intermediate: Keep only even numbers
            .map(num -> num * num)            // Intermediate: Square each number (e.g. 4, 16, 36...)
            .distinct()                       // Intermediate: Remove duplicates (e.g. keeps unique squares)
            .sorted()                         // Intermediate: Sort ascending
            .peek(val -> System.out.print("Processing " + val + " | ")) // Intermediate: peek/debug step
            .count();                         // Terminal: Return the total count of elements
        System.out.println("\nNumber of unique squares of even numbers: " + count);

        // 3.2 reduce() - Accumulate elements into a single result
        List<String> fruits = List.of("Apple", "Banana", "Cherry", "Date", "Elderberry");
        
        // reduce(identity, accumulator) takes a starting identity and applies a function to combine elements
        String concatenatedUppercaseFruits = fruits.stream()
            .map(String::toUpperCase) // Intermediate: convert strings to UPPERCASE
            .sorted()                 // Intermediate: sort alphabetically
            .reduce("", (accumulated, element) -> accumulated + " " + element); // Terminal: accumulate elements
        System.out.println("Concatenated fruits: " + concatenatedUppercaseFruits.trim());

        // 3.3 collect(Collectors.toList()) - Gather stream elements into a new List
        List<Integer> nameLengths = fruits.stream()
            .map(String::length) // Intermediate: transform string into its length (int)
            .collect(Collectors.toList()); // Terminal: collect the results into a List
        System.out.println("Lengths of each fruit name: " + nameLengths);

        //3.4 using flatmap() to convert nested stream to single stream
        List<List<Integer>> nestedList = List.of(List.of(1, 2, 3), List.of(4, 5), List.of(6, 7, 8));

        List<Integer> flattenedList = nestedList.stream()
            .flatMap(List::stream) // Intermediate: convert nested stream to single stream
            //above line also can be written as:  .flatmap(l -> l.stream())
            .collect(Collectors.toList()); // Terminal: collect the results into a List
        System.out.println("Flattened list: " + flattenedList);
    }
}