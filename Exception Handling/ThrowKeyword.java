// Throw keyword: Used to explicitly throw a single exception.

// Custom exception extends RuntimeException (for Unchecked) or Exception (for Checked)
class InvalidAgeException extends RuntimeException {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class ThrowKeyword {
    public static void main(String[] args) {
        
        // Example 1: Throwing a built-in exception
        try {
            validate(15);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Example 2: Throwing a custom exception
        try {
            checkAge(-1);
        } catch (InvalidAgeException e) {
            System.out.println("Custom Error: " + e.getMessage());
        }
    }

    static void validate(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Age must be 18 or older.");
        }
    }

    static void checkAge(int age) {
        if (age < 0) {
            throw new InvalidAgeException("Age cannot be negative.");
        }
    }
}

//output

//Error: Age must be 18 or older.
//Custom Error: Age cannot be negative.
