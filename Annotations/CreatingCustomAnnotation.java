import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

/**
 * 1. Defining a Custom Annotation
 * 
 * - @Target: Specifies where this annotation can be applied. 
 *            ElementType.METHOD means it can only be placed on methods.
 * - @Retention: Specifies how long the annotation should be retained.
 *              RetentionPolicy.RUNTIME means the annotation is recorded in the class file
 *              by the compiler and is retained by the JVM at runtime, so we can read it via Reflection.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface ExampleCustomAnnotation {
    // Annotation element/attribute. It behaves like a method but represents a field.
    String message();
}

public class CreatingCustomAnnotation {

    // 2. Applying the Custom Annotation
    // We attach our custom annotation to the greet() method and provide a value for its message attribute.
    @ExampleCustomAnnotation(message = "nilesh")
    public void greet() throws NoSuchMethodException {
        
        // 3. Reading the Annotation using Reflection APIs at Runtime
        
        // Step A: Get the Method object representing this greet() method.
        // this.getClass() returns the class object of CreatingCustomAnnotation.
        // getDeclaredMethod("greet") retrieves the method object named "greet".
        Method m = this.getClass().getDeclaredMethod("greet");
        
        // Step B: Extract our custom annotation from the Method object.
        ExampleCustomAnnotation annotation = m.getAnnotation(ExampleCustomAnnotation.class);
        
        // Step C: Access the attribute value of the annotation and print it.
        System.out.println("Annotation message is: " + annotation.message());
    }

    public static void main(String[] args) {
        CreatingCustomAnnotation c = new CreatingCustomAnnotation();

        try {
            c.greet();
        } catch (NoSuchMethodException e) {
            System.err.println("Method not found: " + e.getMessage());
        }
    }
}

