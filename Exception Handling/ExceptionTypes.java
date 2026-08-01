// Exception Types: Checked (Compile-time) and Unchecked (Runtime) Exceptions.

// Checked Exception: Checked by compiler. Must be handled or declared.
// Unchecked Exception: Checked at runtime. Extends RuntimeException.

import java.io.FileReader;
import java.io.FileNotFoundException;

public class ExceptionTypes {
    public static void main(String[] args) {
        
        // Example 1: Unchecked Exception (ArrayIndexOutOfBoundsException)
        int[] numbers = {1, 2, 3};
        try {
            System.out.println(numbers[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught Unchecked: " + e);
        }

        // Example 2: Checked Exception (FileNotFoundException)
        try {
            FileReader reader = new FileReader("non_existent_file.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Caught Checked: " + e);
        }
    }
}

//output

//Caught Unchecked: java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 3
//Caught Checked: java.io.FileNotFoundException: non_existent_file.txt (The system cannot find the file specified)
