import java.util.Arrays;

class A{
    private String name;
    private int rollno;
    private String city;

    A(String name, int rollno, String city){
        this.name = name;
        this.rollno = rollno;
        this.city = city;
    }

    public void show(){
        System.out.println(name + " " + rollno + " " + city);
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        Class<?> c = Class.forName("A");
        
        Arrays.stream(c.getDeclaredMethods())
            .forEach(System.out::println);
    }
}
