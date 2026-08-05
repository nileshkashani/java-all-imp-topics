class Person {
    String name; // Instance variable, stored on the Heap as part of the Person object

    Person(String name) {
        this.name = name;
    }

    // Overriding finalize() is deprecated in modern Java but it is the easiest way
    // to visually show when an object is actually reclaimed by the Garbage Collector.
    @Override
    @SuppressWarnings("deprecation")
    protected void finalize() throws Throwable {
        System.out.println("🚮 Garbage Collector: Reclaiming memory for Person '" + name + "'!");
        super.finalize();
    }
}

public class JVMMemoryDemo {

    public static void main(String[] args) {
        System.out.println("--- Starting JVM Memory Demo ---");

        // 1. Stack Allocation (Primitive Local Variable)
        // 'age' is a primitive type (int), so its actual value (25) is stored directly on the Stack.
        int age = 25; 

        // 2. Stack & Heap Allocation (Object reference)
        // 'p1' is a reference variable.
        // - 'p1' is stored on the Stack.
        // - The actual Person object ('new Person("Nilesh")') is created and stored on the Heap.
        // - 'p1' holds the memory address pointing to the Person object on the Heap.
        Person p1 = new Person("Nilesh");
        System.out.println("Created person: " + p1.name);

        // Call a method to see how local variables are pushed and popped from the Stack.
        createTemporaryObject();

        // 3. Making an Object Eligible for Garbage Collection
        System.out.println("\nMaking p1 ('Nilesh') eligible for GC by setting reference to null...");
        // Setting 'p1' to null removes the link to the object on the Heap.
        // Since there are no other active references pointing to "Nilesh" on the Heap,
        // this object is now eligible for Garbage Collection.
        p1 = null; 

        // 4. Requesting Garbage Collection
        System.out.println("Requesting JVM to run Garbage Collection (System.gc())...");
        // Note: System.gc() is a request, not a guarantee that JVM will run GC immediately.
        // But usually in simple test scripts, JVM will execute it.
        System.gc();

        // Give the JVM a split second to run GC threads so we can see the console output.
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("--- End of JVM Memory Demo ---");
    }

    public static void createTemporaryObject() {
        System.out.println("\n--- Inside createTemporaryObject() method ---");
        // 'tempPerson' reference variable is pushed onto the Stack.
        // The "Karan" object is allocated on the Heap.
        Person tempPerson = new Person("Karan");
        System.out.println("Created temporary person: " + tempPerson.name);

        // When this method ends, 'tempPerson' is popped off the Stack.
        // The "Karan" object on the Heap has no active references left,
        // making it eligible for GC when the method returns!
        System.out.println("Exiting createTemporaryObject() method...");
    }
}
