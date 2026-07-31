package OOPS;

public class SuperKeyword {

    public static void main(String[] args) {

        Dog dog = new Dog();

        dog.display();
    }
}

class Animal {

    String name = "Animal";

    Animal() {
        System.out.println("Animal constructor called.");
    }
}

class Dog extends Animal {

    String name = "Dog";

    Dog() {

        // Calls parent constructor.
        super();

        System.out.println("Dog constructor called.");
    }

    void display() {

        // super accesses parent members.
        System.out.println("Parent Name : " + super.name);

        // this accesses current object.
        System.out.println("Child Name  : " + this.name);
    }
}