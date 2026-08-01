import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MethodReferences {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(1000);
        l.add(2);
        l.add(3);
        l.add(4);
        l.stream()
            .sorted()
            .forEach(System.out::println);
         
    }
}