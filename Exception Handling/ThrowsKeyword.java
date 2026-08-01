// Throws keyword: Declares that a method might throw exceptions, delegating handling to caller.

import java.io.IOException;

public class ThrowsKeyword {
    
    // Method declares that it may throw IOException
    public static void checkDevice(int code) throws IOException {
        if (code == 0) {
            throw new IOException("Device Connection Failed!");
        }
        System.out.println("Device is connected.");
    }

    // Propagates the exception up the call stack
    public static void initialize(int code) throws IOException {
        checkDevice(code);
    }

    public static void main(String[] args) {
        // Caller handles the propagated checked exception
        try {
            initialize(0);
        } catch (IOException e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }
}

//output

//Caught: Device Connection Failed!
