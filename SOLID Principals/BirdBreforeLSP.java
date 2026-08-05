/**
 * LISKOV SUBSTITUTION PRINCIPLE (LSP) - VIOLATION EXAMPLE
 * 
 * Definition: Subtypes must be substitutable for their base types.
 * This means a subclass should not break the expectations or behavior defined by the parent class.
 */

public class BirdBreforeLSP {

    // Base class representing all birds
    static class Bird {
        public void fly() {
            System.out.println("Bird is flying");
        }

        public void eat() {
            System.out.println("Bird is eating");
        }
    }

    // Penguin is a Bird, but it CANNOT fly!
    // Overriding fly() to print "cannot fly" violates LSP.
    // Any client code expecting a Bird to fly will behave unexpectedly when a Penguin is substituted.
    static class Penguin extends Bird {
        @Override
        public void fly() {
            System.out.println("Penguin cannot fly"); // VIOLATION: Subclass breaks parent's expected behavior
        }
    }

    public static void main(String[] args) {
        // Client code expects all Birds to be able to fly
        Bird p = new Penguin();
        
        p.fly(); // This violates LSP because the substituted subtype cannot fulfill the parent behavior!
        p.eat();    
    }
}


