// Generics in Java allow writing code that works with multiple data types
// using a single class, interface, or method. They ensure type safety at compile time.

// A generic class that uses the type parameter <T>
class Test<T> {
    T obj;

    Test(T obj) {
        this.obj = obj;
    }

    public T getObject() {
        return this.obj;
    }
}

public class Generics {
    public static void main(String[] args) {
        // 1. Instance of Integer type
        // Note: Primitives (like int, char, double) cannot be used as type parameters.
        // We must use wrapper classes like Integer.
        Test<Integer> iObj = new Test<Integer>(15);
        System.out.println(iObj.getObject());

        // 2. Instance of String type
        Test<String> sObj = new Test<String>("Hello");
        System.out.println(sObj.getObject());
    }
}

// Output:
// 15
