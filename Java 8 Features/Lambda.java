// A functional interface is an interface with exactly one abstract method.
// Lambda expressions in Java must be assigned to a functional interface target type.

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

//lambda with custom functional interface
interface Add{
    int addition(int a, int b);
}

public class Lambda {
   public static void main(String[] args){
        
        // Lambda expression to add two numbers
        Add add = (a, b) -> a + b;
        
        int result = add.addition(10, 20);
        System.out.println("Sum: " + result);


        //lambda with inbuilt interface

        //1.Predicate: Tests a condition and returns true/false.

        Predicate <Integer> p = (num)->{
            return num%2 == 0;
        };
        System.out.println(p.test(10)); //test is one and only abstract function in functional interface Predicate

        //2.Consumer: Performs an operation on a given input, returns nothing.
        Consumer <Integer> c = (num)->{
            System.out.println(num*2); //returns square of a number.
        };
        c.accept(10); //accept is one and only abstract function in functional interface Consumer

        //3.Supplier: Provides a value (no input).

        Supplier <Integer> s = ()->{
            return 10;
        };
        System.out.println(s.get()); //get is one and only abstract function in functional interface Supplier

        //4.Function: Takes one input and returns one output.

        Function <Integer, Integer> f = (num)->{
            return num*2;
        };
        System.out.println(f.apply(10)); //apply is one and only abstract function in functional interface Function\

        //5.Comparator: Compares two objects and returns the result.

        Comparator<Integer> com = (a, b)->{
            return a-b;
        };
        System.out.println(com.compare(10, 20)); //compare is one and only abstract function in functional interface Comparator
    }
}

