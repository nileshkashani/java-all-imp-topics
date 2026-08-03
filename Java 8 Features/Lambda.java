// A Functional Interface is an interface that contains exactly one abstract method.
// Java 8 introduced the @FunctionalInterface annotation to ensure compile-time checks for this constraint.
// Lambda expressions provide a clear and concise way to implement functional interfaces.

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.BiConsumer;

// Lambda expressions are essentially anonymous functions that do not belong to any class.
// Syntax: (parameters) -> { body } or (parameters) -> expression (if it is a single expression)

@FunctionalInterface // Annotation ensures that this interface can only have one abstract method
interface Add {
    // Single abstract method
    int addition(int a, int b);
}

public class Lambda {
    public static void main(String[] args) {
        
        // ----------------------------------------------------
        // 1. Custom Functional Interface Implementation using Lambda
        // ----------------------------------------------------
        // The type of a lambda expression must be a Functional Interface.
        // The parameters (a, b) match the signature of the 'addition' method.
        Add add = (a, b) -> a + b; // Implicitly returns the sum without needing 'return' keyword for single expression
        
        int result = add.addition(10, 20); // Invokes the lambda expression
        System.out.println("Custom Add Interface Sum: " + result);

        // ----------------------------------------------------
        // 2. Built-in Functional Interfaces (java.util.function package)
        // ----------------------------------------------------

        // 2.1 Predicate<T>: Accepts a single input of type T, performs a condition check, and returns a boolean value.
        // It represents a boolean-valued function of one argument.
        Predicate<Integer> isEven = (num) -> num % 2 == 0;
        // 'test(T t)' is the single abstract method in the Predicate interface.
        System.out.println("Is 10 even? " + isEven.test(10)); // Returns true
        System.out.println("Is 15 even? " + isEven.test(15)); // Returns false

        // 2.2 Consumer<T>: Accepts a single input of type T, performs an action, and returns no result (void).
        // It is used when an operation is executed on an object without expecting any return value.
        Consumer<Integer> printDouble = (num) -> System.out.println("Double of " + num + " is: " + (num * 2));
        // 'accept(T t)' is the single abstract method in the Consumer interface.
        printDouble.accept(10); // Outputs: 20

        // 2.3 Supplier<T>: Does not accept any inputs, but returns (supplies) a value of type T.
        // It is often used for lazy generation of values or object instantiation.
        Supplier<Double> randomValue = () -> Math.random();
        // 'get()' is the single abstract method in the Supplier interface.
        System.out.println("Supplied Random Value: " + randomValue.get());

        // 2.4 Function<T, R>: Accepts one input of type T and returns a result of type R.
        // It represents a function that transforms an input into an output.
        Function<String, Integer> stringLength = (str) -> str.length();
        // 'apply(T t)' is the single abstract method in the Function interface.
        System.out.println("Length of 'Hello World': " + stringLength.apply("Hello World"));

        // 2.5 Comparator<T>: Compares its two arguments for order. Returns negative, zero, or positive integer.
        // Used extensively in sorting operations.
        Comparator<Integer> compareNumbers = (num1, num2) -> num1 - num2;
        // 'compare(T o1, T o2)' is the single abstract method in the Comparator interface.
        System.out.println("Comparing 10 and 20: " + compareNumbers.compare(10, 20)); // Output: negative value (-10)

        // 2.6 BiConsumer<T, U>: Accepts two input arguments of types T and U and returns no result.
        BiConsumer<String, Integer> printDetails = (name, age) -> System.out.println(name + " is " + age + " years old.");
        // 'accept(T t, U u)' is the single abstract method in the BiConsumer interface.
        printDetails.accept("Nilesh", 20);

        // ----------------------------------------------------
        // 3. Variable Capture (Scope of Variables in Lambdas)
        // ----------------------------------------------------
        // Lambdas can access instance fields and static variables.
        // However, local variables from the enclosing scope MUST be final or effectively final (never modified).
        int outerFactor = 5; // Local variable (implicitly effectively final if not reassigned)
        
        Consumer<Integer> multiplyAndPrint = (val) -> {
            // outerFactor = 10; // Compilation Error! Local variables defined in an enclosing scope must be final or effectively final.
            System.out.println("Result of multiplication: " + (val * outerFactor));
        };
        multiplyAndPrint.accept(4); // Outputs 20
    }
}
