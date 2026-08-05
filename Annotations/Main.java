import java.util.ArrayList;
import java.util.List;

/**
 * 4. @FunctionalInterface
 * This annotation is used to design interfaces with exactly ONE abstract method.
 * It prevents developers from accidentally adding more abstract methods, 
 * which makes the interface eligible for use with Lambda Expressions.
 */
@FunctionalInterface
interface Nilesh {
    void greet();
}

public class Main implements Nilesh {

    /**
     * 1. @Override
     * Tells the compiler that this method is overriding a method from a parent interface or class.
     * If the method name or signature does not match any method in the parent, the compiler raises an error.
     * This prevents subtle bugs due to spelling mistakes in method names.
     */
    @Override
    public void greet() {
        System.out.println("hello");
    }

    public static void main(String[] args) {
        Main mainObj = new Main();
        mainObj.greet();
        
        // We are calling a deprecated method here. The compiler/IDE will show a strike-through or warning,
        // but it still runs.
        mainObj.oldMethod();

        /**
         * 3. @SuppressWarnings
         * Tells the compiler to suppress specific compile-time warnings (like raw types, unchecked operations, etc.).
         * Below, we use a raw list without specifying generics (e.g. List<String>). 
         * Normally this triggers a rawtypes warning, but @SuppressWarnings("rawtypes") tells the compiler to ignore it.
         */
        @SuppressWarnings("rawtypes")
        List rawList = new ArrayList();
        rawList.add("Hello raw type");
        rawList.add(10);
        System.out.println("List elements: " + rawList);
    }

    /**
     * 2. @Deprecated
     * Marks this method as obsolete or outdated.
     * It tells other developers: "This method works, but there is a better way. Avoid using it because it may be removed in the future."
     */
    @Deprecated
    public void oldMethod() {
        System.out.println("Old method");
    }
}

