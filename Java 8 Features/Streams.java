import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {
        //streams is used to reduce code content and increase its readability.

        //there are mainly three steps to achieve streams in java.

        //1. create a stream using array/list/file/any other data source.

        //2. Apply Immidiate operation (using functions like .filter(), .map(), .sorted(), etc.)

        //3. Apply Terminal operation (using functions like .forEach(), .collect(), .reduce(), etc.)


        //streams can be created using mainly 4 different ways.

        //1. using Arrays.stream(a);
        int []a = {1,2,3,4,5};
        Arrays.stream(a) //create stream
            .forEach(System.out::println); //terminal operation
        
        //2. using any collections .stream() method
        List<Integer> list = Arrays.asList(5,4,3,2,1);
        list.stream() //create stream
            .sorted() //immediate operation
            .forEach(System.out::println); //terminal operation
        
        //3. using Stream.of()
        Stream.of("Apple", "Banana", "Cherry", "Date", "Elderberry")
            .filter(e -> e.length() > 4) //immediate operation
            .forEach(System.out::println); //terminal operation

        //4. using Stream.iterate()
        Stream.iterate(0, i->i+1).limit(10).forEach(System.out::println); //terminal operation
    }
}