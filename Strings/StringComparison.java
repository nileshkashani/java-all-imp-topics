// String Comparison in Java.
// We can compare strings using the equals() method, equalsIgnoreCase() method, or the == operator.

public class StringComparison {
    public static void main(String[] args) {
        String str = "Hello World";
        String str1 = "Hello";
        
        // equals() method compares the contents of two Strings.
        System.out.println(str.equals(str1)); // false
        
        // equalsIgnoreCase() method compares the contents ignoring case.
        System.out.println(str.equalsIgnoreCase(str1)); // false

        // Why use .equals() instead of == ?
        // .equals() compares the contents of the strings, while
        // == compares memory addresses (references).
        
        String cmp1 = "Hello";
        String cmp2 = "Hello";
        // Returns true because Java uses String Constant Pool.
        // Since "new" keyword is not used, both point to the same memory location.
        System.out.println(cmp1 == cmp2); // true

        // Using the "new" keyword creates a new object in the heap memory,
        // so they point to different memory addresses.
        String cmp3 = new String("Hello");
        String cmp4 = new String("Hello");
        System.out.println(cmp3 == cmp4); // false (different memory addresses)
        System.out.println(cmp3.equals(cmp4)); // true (same content)
    }
}

// Output:
// false
// false
// true
// false
// true
