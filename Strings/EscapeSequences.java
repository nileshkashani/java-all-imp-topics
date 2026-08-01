// Escape Sequences (Special Characters) in Java Strings.
// Escape characters start with a backslash (\) and are used to insert special characters in strings.

public class EscapeSequences {
    public static void main(String[] args) {
        // 1. \" - Inserts a double quote inside a string literal
        String doubleQuote = "He said, \"Hello World!\"";
        System.out.println(doubleQuote);

        // 2. \\ - Inserts a backslash character
        String backslash = "The folder path is C:\\Users\\Owner\\Documents";
        System.out.println(backslash);

        // 3. \' - Inserts a single quote inside a character or string literal
        String singleQuote = "It\'s a beautiful day.";
        System.out.println(singleQuote);

        // 4. \n - Inserts a newline (moves to the next line)
        String newline = "Hello\nWorld";
        System.out.println(newline);

        // 5. \t - Inserts a tab spaces
        String tab = "Name:\tJohn\tAge:\t25";
        System.out.println(tab);
    }
}

// Output:
// He said, "Hello World!"
// The folder path is C:\Users\Owner\Documents
// It's a beautiful day.
// Hello
// World
// Name:	John	Age:	25
