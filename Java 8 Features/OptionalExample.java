// Optional<T> is a container object introduced in Java 8 which may or may not contain a non-null value.
// It is designed to represent optional values and prevent the infamous NullPointerException (NPE).
//
// Key Advantages of Optional:
// 1. Avoids boilerplate null checks (e.g., if (obj != null)).
// 2. Improves API design by explicitly showing that a method might return no value.

import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        String name = "Nilesh";
        String nullName = null;

        // ====================================================
        // PART 1: Creating Optional Objects
        // ====================================================
        System.out.println("=== Part 1: Creating Optionals ===");

        // 1.1 Optional.of(value) - Throws NullPointerException if the value passed is null.
        // Use only when you are 100% sure the value is NOT null.
        Optional<String> optName = Optional.of(name);
        System.out.println("Optional.of: " + optName);

        // 1.2 Optional.ofNullable(value) - Safe for null. If null is passed, returns an empty Optional.
        Optional<String> optNullName = Optional.ofNullable(nullName);
        System.out.println("Optional.ofNullable (null): " + optNullName);

        // 1.3 Optional.empty() - Returns a pre-created empty Optional instance.
        Optional<String> emptyOpt = Optional.empty();
        System.out.println("Optional.empty: " + emptyOpt);


        // ====================================================
        // PART 2: Checking Value Presence
        // ====================================================
        System.out.println("\n=== Part 2: Checking Presence ===");

        // 2.1 isPresent() - Returns true if value is present, false otherwise.
        if (optName.isPresent()) {
            System.out.println("optName has value: " + optName.get()); // get() retrieves the value, throws exception if empty
        }

        // 2.2 isEmpty() - Returns true if value is empty, false otherwise. (Added in Java 11 but good to know)
        if (optNullName.isEmpty()) {
            System.out.println("optNullName is empty!");
        }

        // 2.3 ifPresent(Consumer) - Execute a lambda only if the value is present.
        // Avoids if-check completely!
        optName.ifPresent(val -> System.out.println("Found name using ifPresent: " + val));


        // ====================================================
        // PART 3: Retrieving Values & Falling Back
        // ====================================================
        System.out.println("\n=== Part 3: Fallbacks ===");

        // 3.1 orElse(defaultValue) - Returns the value if present, otherwise returns the default value.
        String result1 = optNullName.orElse("Default Name (orElse)");
        System.out.println("orElse result: " + result1);

        // 3.2 orElseGet(Supplier) - Similar to orElse, but lazy. Takes a Supplier lambda.
        // Useful if generating the default value is computationally expensive.
        String result2 = optNullName.orElseGet(() -> "Default Name from Supplier (orElseGet)");
        System.out.println("orElseGet result: " + result2);

        // 3.3 orElseThrow(Supplier) - Throws a custom exception if the value is missing.
        try {
            String result3 = optNullName.orElseThrow(() -> new IllegalArgumentException("Name cannot be null!"));
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }


        // ====================================================
        // PART 4: Functional Mapping and Filtering (Stream-like operations)
        // ====================================================
        System.out.println("\n=== Part 4: Map & Filter on Optionals ===");

        Optional<String> upperNameOpt = optName
            .filter(n -> n.length() > 3) // Keeps value only if name length is > 3
            .map(String::toUpperCase);  // Transforms value to uppercase if present

        upperNameOpt.ifPresent(val -> System.out.println("Transformed and filtered result: " + val));

        // Attempting to filter out an element
        Optional<String> filteredName = optName.filter(n -> n.length() > 10);
        System.out.println("Is name length > 10? Present: " + filteredName.isPresent());
    }
}
