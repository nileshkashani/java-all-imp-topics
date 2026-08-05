import java.util.ArrayList;
import java.util.List;
//4. @functional interface
@FunctionalInterface
interface Nilesh {
    void greet();
}

public class Main implements Nilesh {
    // examples of built in annotations

    // 1.
    @Override
    public void greet() {
        System.out.println("hello");
    }

    public static void main(String[] args) {
        Main mainObj = new Main();
        mainObj.greet();
        mainObj.oldMethod();

        // 3.
        @SuppressWarnings("rawtypes")
        List<Integer> list = new ArrayList<>();
        list.add(10);
        System.out.println(list);
    }

    // 2.
    @Deprecated
    public void oldMethod() {
        System.out.println("Old method");
    }

}
