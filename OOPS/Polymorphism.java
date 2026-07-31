package OOPS;

public class Polymorphism {

    public static void main(String[] args) {

        // Parent reference points to child object.
        Animal animal = new Dog();

        // Java decides which method to call.
        animal.sound();
    }
}

// Parent class
class Animal {

    void sound() {
        System.out.println("Animal makes a sound.");
    }
}

// Child class
class Dog extends Animal {

    // Override the parent's method.
    @Override
    void sound() {
        System.out.println("Dog says Woof!");
    }
}