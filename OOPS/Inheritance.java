public class Inheritance {

    public static void main(String[] args) {

        // Dog gets properties from Animal.
        Dog dog = new Dog();

        dog.eat();
        dog.bark();
    }
}

// Parent class
class Animal {

    void eat() {
        System.out.println("Animal is eating.");
    }
}

// Child class inherits Animal.
class Dog extends Animal {

    void bark() {
        System.out.println("Dog is barking.");
    }
}