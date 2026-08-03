// Java 8 introduced the ability to add concrete method implementations inside interfaces.
// This is achieved using the 'default' and 'static' keywords.
//
// Why default methods?
// 1. Backward Compatibility: Allows adding new methods to interfaces without breaking existing implementing classes.
// 2. Simplifies code by removing the need for helper utility classes.
//
// Why static methods?
// 1. Utility Methods: Allows putting helper/utility methods directly inside the interface, rather than a separate class (like Collections).
// 2. Cannot be overridden by implementing classes.

// Interface A has a default method and a static method
interface Vehicle {
    // Abstract method: MUST be implemented by any concrete class
    void start();

    // Default method: Concrete method that implementing classes inherit automatically.
    // They can choose to override it if they want to change the default behavior.
    default void honk() {
        System.out.println("Vehicle is honking: Beep Beep!");
    }

    // Static method: Belongs to the Interface class itself.
    // It cannot be overridden, and must be called using the Interface name.
    static void serviceInfo() {
        System.out.println("Vehicles need regular servicing every 5000 km.");
    }
}

// Another interface to show multiple inheritance conflict resolution
interface Alarm {
    // Interface Alarm also defines a default method with the exact same name 'honk'
    default void honk() {
        System.out.println("Alarm is sounding: WOO WOO WOO!");
    }
}

// -----------------------------------------------------------------------------
// Case 1: Simple Implementation inheriting default behavior
// -----------------------------------------------------------------------------
class Car implements Vehicle {
    // implementing the abstract method
    @Override
    public void start() {
        System.out.println("Car engine started using push button.");
    }
    // inherits Vehicle's default honk() automatically. We do not override it here.
}

// -----------------------------------------------------------------------------
// Case 2: Multiple Inheritance default method collision resolution
// -----------------------------------------------------------------------------
// If a class implements two interfaces that contain default methods with the exact same signature,
// the class must override the method to resolve the ambiguity (otherwise it will cause compilation error).
class MultiPurposeVehicle implements Vehicle, Alarm {
    @Override
    public void start() {
        System.out.println("MultiPurposeVehicle started.");
    }

    // Overriding the conflicting default method is MANDATORY here
    @Override
    public void honk() {
        // Option A: Provide a completely new custom implementation
        System.out.println("MultiPurposeVehicle honks with custom tone.");

        // Option B: Explicitly specify which interface's default method to call using Super keyword
        Vehicle.super.honk(); // calls Vehicle's default honk()
        Alarm.super.honk();   // calls Alarm's default honk()
    }
}

public class DefaultStaticMethods {
    public static void main(String[] args) {
        System.out.println("=== 1. Interface Default Method (No Override) ===");
        Car myCar = new Car();
        myCar.start();
        myCar.honk(); // Call inherited default method

        System.out.println("\n=== 2. Interface Static Method ===");
        // Vehicle.serviceInfo() is called directly on the interface, NOT the object
        Vehicle.serviceInfo(); 
        // myCar.serviceInfo(); // Compilation Error! Interface static methods are not inherited by implementing class objects.

        System.out.println("\n=== 3. Multiple Inheritance Conflict Resolution ===");
        MultiPurposeVehicle mpv = new MultiPurposeVehicle();
        mpv.start();
        mpv.honk(); // Call overridden version resolving conflict
    }
}
