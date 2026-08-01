// Method references are a special type of lambda expressions. They’re often used to create simple lambda expressions by referencing existing methods.

// There are four kinds of method references:

//1. Static methods
//2. Instance methods of particular objects
//3. Instance methods of an arbitrary object of a particular type
//4. Constructor

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class CompareInt implements Comparator<Integer>{
    @Override
    public int compare(Integer i1,Integer i2){
        return i1.compareTo(i2);
    }
}

public class MethodReferences {
    public static void main(String[] args) {
        // 1. Static methods
        List<Integer> messages = Arrays.asList(100, 50, 20);
        messages.forEach(System.out::println);  //forEach is a method of List interface which takes a Consumer functional interface as an argument.\

        //2. Instance methods of particular objects
        CompareInt c = new CompareInt();
        messages.stream()
            .sorted(c::compare)
            .forEach(System.out::println);


        //3. Instance methods of an arbitrary object of a particular type
        
    }
}