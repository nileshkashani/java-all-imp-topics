// String is simply a collection of characters.
// It is immutable in Java, meaning once initialized, it cannot be changed.

public class StringDeclaration {
    public static void main(String[] args) {
        // to declare a String, we use the String class.
        String str = "Hello World";
        System.out.println(str);

        // trying to change the String (immutability check)
        // Strings are immutable, so we cannot modify individual characters directly.
        // str.charAt(0) = 'N'; // Not Allowed! Compile-time error
        System.out.println(str);
    }
}

// Output:
// Hello World
// Hello World
