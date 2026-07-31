public class Encapsulation {

    public static void main(String[] args) {

        // Create an object
        Student student = new Student();

        // Set values using setters
        student.setName("Nilesh");
        student.setAge(20);

        // Get values using getters
        System.out.println("Name : " + student.getName());
        System.out.println("Age  : " + student.getAge());
    }
}

// Encapsulation means hiding data.
class Student {

    // Private variables cannot be accessed directly.
    private String name;
    private int age;

    // Setter updates the name.
    public void setName(String name) {
        this.name = name;
    }

    // Getter returns the name.
    public String getName() {
        return name;
    }

    // Setter updates the age.
    public void setAge(int age) {
        this.age = age;
    }

    // Getter returns the age.
    public int getAge() {
        return age;
    }
}