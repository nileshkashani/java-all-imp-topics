// Method references are a special type of lambda expressions. They’re often used to create simple lambda expressions by referencing existing methods.

// There are four kinds of method references:

//1. Static methods
//2. Instance methods of particular objects
//3. Instance methods of an arbitrary object of a particular type
//4. Constructor

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MethodReferences {
    public static void main(String[] args) {
        // 1. Static methods
        List<String> messages = Arrays.asList("hello", "baeldung", "readers!");
        messages.forEach(String::toUpperCase);  //forEach is a method of List interface which takes a Consumer functional interface as an argument.
        
        //2. Instance methods of particular objects
        
    }
}