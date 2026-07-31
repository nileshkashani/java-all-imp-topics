package OOPS;


public class FinalKeyword {

    public static void main(String[] args) {

        Student student = new Student();

        student.display();
    }
}

class Student {

    // Final variable cannot be changed.
    final int rollNo = 101;

    // Final method cannot be overridden.
    final void display() {
        System.out.println("Roll No : " + rollNo);
    }
}

// Final class cannot be inherited.
final class College {

    void show() {
        System.out.println("Welcome to the college.");
    }
}

// The code below will give an error.

// class EngineeringCollege extends College {
//
// }