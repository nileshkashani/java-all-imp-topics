package OOPS;

//basics about OOPS in java

//ENSURE THAT YOU KNOW JAVA FUNDAMENTALS BEFORE COMING TO OOPS

//IF YOU DIDN'T UNDERSTAND OOPS AT ONCE, DON'T WORRY, YOU'LL BE FAMILIER WITH IT.



 //Class
 //A class is a blueprint that defines
 //what an object will have and do.



public class Basics {
  public static void main(String[] args) {

        // Creating objects
        Student student1 = new Student();
        Student student2 = new Student();

        // Giving values
        student1.name = "Nilesh";
        student1.age = 20;

        student2.name = "Rahul";
        student2.age = 21;

        // Calling methods
        student1.introduce();
        student2.introduce();
    }
}


class Student {

    // Properties (Data)
    String name;
    int age;

    /*
     * Method
     * A method defines the behavior
     * of an object.
     */
    void introduce() {
        System.out.println("Hi, I am " + name);
        System.out.println("My age is " + age);
        System.out.println();
    }
}
