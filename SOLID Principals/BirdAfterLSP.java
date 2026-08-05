/**
 * LISKOV SUBSTITUTION PRINCIPLE (LSP) - SOLUTION
 * 
 * We fix the LSP violation by removing the fly() method from the general Bird class.
 * Since not all birds can fly, we separate the flying capability into a dedicated Flyable interface.
 * 
 * - Now, only birds that can actually fly (like Sparrow) implement Flyable.
 * - Non-flying birds (like Penguin) only inherit the base Bird class behaviors (like eating) and do not support flying.
 * - This preserves subclass substitutability!
 */

public class BirdAfterLSP {

    static class Bird {
        public void eat() {
            System.out.println("Bird is eating");
        }
    }
     
    // Separated interface for flying capability
    interface Flyable {
        void fly();
    }

    // Sparrow extends Bird and implements Flyable because it can fly
    static class Sparrow extends Bird implements Flyable {
        @Override
        public void fly() {
            System.out.println("Sparrow is flying");
        }
    }

    // Penguin extends Bird but does NOT implement Flyable
    static class Penguin extends Bird {
        public void swim() {
            System.out.println("Penguin is swimming");
        }
    }

    public static void main(String[] args) {
        // Both Sparrow and Penguin are valid substitutable subtypes of Bird,
        // and neither is forced to support behaviors they are incapable of performing.
        
        System.out.println("--- Sparrow ---");
        Sparrow s = new Sparrow();
        s.eat();
        s.fly();

        System.out.println("\n--- Penguin ---");
        Penguin p = new Penguin();
        p.eat();
        p.swim();
    }
}


