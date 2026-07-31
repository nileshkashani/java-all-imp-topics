package OOPS;
public class ThisKeyword {

    public static void main(String[] args) {

        Student student = new Student("Nilesh", 20);

        student.display();
    }
}

class Student {

    String name;
    int age;

    // this refers to the current object.
    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void display() {
        System.out.println("Name : " + this.name);
        System.out.println("Age  : " + this.age);
    }
}