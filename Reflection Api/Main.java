import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

// Target class A representing a typical class to inspect/manipulate
class A {
    private String name;
    private int rollno;
    public String city;
    private static int objectCount = 0;

    // Public default constructor
    public A() {
        objectCount++;
    }

    // Private parameterized constructor
    private A(String name, int rollno, String city) {
        this.name = name;
        this.rollno = rollno;
        this.city = city;
        objectCount++;
    }

    // Private method
    private void show() {
        System.out.println("Private show() method invoked: Name=" + name + ", RollNo=" + rollno + ", City=" + city);
    }

    // Public parameterized method
    public void updateInfo(String name, int rollno) {
        this.name = name;
        this.rollno = rollno;
        System.out.println("Public updateInfo() method invoked. Updated Name=" + this.name + ", RollNo=" + this.rollno);
    }

    // Public static method
    public static int getObjectCount() {
        return objectCount;
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            // === 1. Obtaining Class Object ===
            // Class.forName() is used when the fully qualified class name is known as a string at runtime
            Class<?> clazz = Class.forName("A");
            System.out.println("=== Class Information ===");
            System.out.println("Class Name: " + clazz.getName());
            System.out.println("Simple Name: " + clazz.getSimpleName());
            System.out.println("Modifiers: " + Modifier.toString(clazz.getModifiers()));

            // === 2. Inspecting and Invoking Constructors ===
            System.out.println("\n=== Constructors ===");
            // getDeclaredConstructors() returns all constructors regardless of access modifiers
            Constructor<?>[] constructors = clazz.getDeclaredConstructors();
            for (Constructor<?> cons : constructors) {
                System.out.println("Constructor: " + cons.getName() + " | Parameters: " + Arrays.toString(cons.getParameterTypes()));
            }

            // Instantiating using a private parameterized constructor
            Constructor<?> privateCons = clazz.getDeclaredConstructor(String.class, int.class, String.class);
            // setAccessible(true) bypasses Java access control checks (private access)
            privateCons.setAccessible(true);
            A obj = (A) privateCons.newInstance("Anshu", 10, "Delhi");
            System.out.println("Object instantiated successfully via private constructor.");

            // === 3. Inspecting and Modifying Fields ===
            System.out.println("\n=== Fields ===");
            // getDeclaredFields() returns all fields declared in the class
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                System.out.println("Field: " + field.getName() + " | Type: " + field.getType().getSimpleName() + " | Modifiers: " + Modifier.toString(field.getModifiers()));
            }

            // Modifying a private field
            Field nameField = clazz.getDeclaredField("name");
            nameField.setAccessible(true); // Bypass private protection
            System.out.println("Original 'name' value: " + nameField.get(obj));
            nameField.set(obj, "Nilesh"); // Sets new value
            System.out.println("Modified 'name' value: " + nameField.get(obj));

            // === 4. Inspecting and Invoking Methods ===
            System.out.println("\n=== Methods ===");
            // getDeclaredMethods() returns all methods declared in the class
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println("Method: " + method.getName() + " | Return Type: " + method.getReturnType().getSimpleName() + " | Modifiers: " + Modifier.toString(method.getModifiers()));
            }

            // Invoking a public method with parameters
            Method updateMethod = clazz.getDeclaredMethod("updateInfo", String.class, int.class);
            updateMethod.invoke(obj, "Karan", 25);

            // Invoking a private method with no parameters
            Method showMethod = clazz.getDeclaredMethod("show");
            showMethod.setAccessible(true);
            showMethod.invoke(obj); // Invokes 'show' on our instance 'obj'

            // Invoking a static method
            Method countMethod = clazz.getDeclaredMethod("getObjectCount");
            // Pass 'null' as target object for static methods
            int count = (Integer) countMethod.invoke(null);
            System.out.println("Static method 'getObjectCount' result: " + count);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

