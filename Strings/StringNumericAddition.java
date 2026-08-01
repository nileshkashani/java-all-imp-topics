// String Addition containing Numbers in Java.
// When adding (concatenating) strings and numbers, Java evaluates expression from left to right.
// If any operand is a String, the '+' operator acts as concatenation.

public class StringNumericAddition {
    public static void main(String[] args) {
        // 1. Adding two strings containing numbers
        String numStr1 = "10";
        String numStr2 = "20";
        System.out.println(numStr1 + numStr2); // Concatenates: "1020"

        // 2. Adding a number and a string containing a number
        int val = 30;
        System.out.println(numStr1 + val); // Concatenates: "1030"

        // 3. Left-to-right evaluation cases:
        
        // Case A: Number + Number + String
        // The numbers are added first, then the result is concatenated with the string.
        System.out.println(10 + 20 + " Hello"); // "30 Hello"

        // Case B: String + Number + Number
        // The string is concatenated with the first number, producing a string.
        // Then, that string is concatenated with the second number.
        System.out.println("Hello " + 10 + 20); // "Hello 1020"
        
        // Case C: Using parentheses to force addition
        System.out.println("Hello " + (10 + 20)); // "Hello 30"
    }
}

// Output:
// 1020
// 1030
// 30 Hello
// Hello 1020
// Hello 30
