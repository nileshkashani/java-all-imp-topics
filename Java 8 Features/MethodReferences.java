// Method references are a shorthand notation of a lambda expression to call an existing method.
// If a lambda expression only calls an existing method, you can replace it with a method reference.
// The double colon operator (::) is used in Java to reference a method.

// There are four distinct kinds of method references:
// 1. Reference to a static method: ContainingClass::staticMethodName
// 2. Reference to an instance method of a particular object: containingObject::instanceMethodName
// 3. Reference to an instance method of an arbitrary object of a particular type: ContainingType::methodName
// 4. Reference to a constructor: ClassName::new

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

// A custom class to help demonstrate comparing (Instance Method of a particular object)
class NumberComparator {
    public int compareInts(Integer i1, Integer i2) {
        return i1.compareTo(i2); // Standard comparison returning negative, zero, or positive
    }
}

// A custom class to demonstrate Constructor Reference
class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class MethodReferences {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(100, 50, 20);

        // ----------------------------------------------------
        // 1. Reference to a Static Method (ContainingClass::staticMethodName)
        // ----------------------------------------------------
        // Equivalent Lambda: (msg) -> System.out.println(msg)
        // Here, we reference the static 'println' method of the static object 'System.out'.
        System.out.println("--- 1. Static Method Reference ---");
        numbers.forEach(System.out::println); 


        // ----------------------------------------------------
        // 2. Reference to an Instance Method of a Particular Object (containingObject::instanceMethodName)
        // ----------------------------------------------------
        // Equivalent Lambda: (a, b) -> comparatorInstance.compareInts(a, b)
        // Here, we reference the 'compareInts' method of a specific object instance 'comparatorInstance'.
        System.out.println("\n--- 2. Instance Method of a Specific Object Reference ---");
        NumberComparator comparatorInstance = new NumberComparator();
        
        // Pass the method reference to sorted() which expects a Comparator
        numbers.stream()
            .sorted(comparatorInstance::compareInts) // references comparatorInstance's method
            .forEach(System.out::println);


        // ----------------------------------------------------
        // 3. Reference to an Instance Method of an Arbitrary Object of a Particular Type (ContainingType::methodName)
        // ----------------------------------------------------
        // Equivalent Lambda: (val) -> val.floatValue()
        // The first parameter of the functional interface is the target object, and the method is invoked on it.
        System.out.println("\n--- 3. Instance Method of an Arbitrary Object of a Type ---");
        
        // map() takes Function<Integer, Float> here. 
        // Inside map, Integer::floatValue means: take each Integer object from stream and call .floatValue() on it.
        numbers.stream()
            .map(Integer::floatValue) 
            .forEach(System.out::println);


        // ----------------------------------------------------
        // 4. Reference to a Constructor (ClassName::new)
        // ----------------------------------------------------
        // We can associate a constructor reference with a functional interface matching the constructor parameters.
        System.out.println("\n--- 4. Constructor Reference ---");

        // 4.1 Supplying an empty List (No-argument constructor)
        // Equivalent Lambda: () -> new ArrayList<Integer>()
        Supplier<ArrayList<Integer>> listSupplier = ArrayList::new; 
        ArrayList<Integer> arrayList = listSupplier.get(); // Creates a new ArrayList
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);
        System.out.println("ArrayList populated using Constructor Reference: " + arrayList);

        // 4.2 Constructor with argument (Single-argument constructor)
        // Equivalent Lambda: (name) -> new Person(name)
        // Function<String, Person> takes a String (input) and returns a Person (output).
        Function<String, Person> personCreator = Person::new;
        Person person = personCreator.apply("Nilesh"); // Calls new Person("Nilesh")
        System.out.println("Created person name: " + person.getName());
    }
}