// Useful built-in String methods in Java.

public class StringMethods {
    public static void main(String[] args) {
        String str = "Hello World";

        // 1. length() - returns the length of the String
        System.out.println(str.length()); // 11

        // 2. substring(startIndex, endIndex) - slicing a String
        // Returns characters from startIndex to endIndex - 1
        System.out.println(str.substring(0, 5)); // Hello

        // 3. toUpperCase() and toLowerCase() - changing case
        System.out.println(str.toUpperCase()); // HELLO WORLD
        System.out.println(str.toLowerCase()); // hello world

        // 4. indexOf(character) - find index of a character
        System.out.println(str.indexOf('W')); // 6

        // 5. trim() - removing leading and trailing spaces
        String str3 = "   Hello World   ";
        System.out.println(str3.trim()); // "Hello World"
    }
}

// Output:
// 11
// Hello
// HELLO WORLD
// hello world
// 6
// Hello World
