// Finally block: Code that always executes after try-catch block.

// Non-executing conditions:
// 1. System.exit() is called.
// 2. JVM crashes/hangs or hardware failure occurs.

public class FinallyBlock {
    public static void main(String[] args) {
        
        // Example 1: Normal try-catch-finally
        try {
            int data = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Finally block executed.");
        }

        // Example 2: System.exit(0) bypasses finally
        try {
            System.out.println("Exiting JVM...");
            System.exit(0); 
        } finally {
            System.out.println("This finally block will not run.");
        }
    }
}

//output

//Error: / by zero
//Finally block executed.
//Exiting JVM...
