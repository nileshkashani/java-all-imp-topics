import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface ExampleCustomAnnotation {
    String message();
}

public class CreatingCustomAnnotation {
    @ExampleCustomAnnotation(message = "nilesh")
    public void greet() throws NoSuchMethodException {
        Method m = this.getClass().getDeclaredMethod("greet");
        System.out.println(m.getAnnotation(ExampleCustomAnnotation.class).message());
    }

    public static void main(String[] args) {
        CreatingCustomAnnotation c = new CreatingCustomAnnotation();

        try {
            c.greet();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
