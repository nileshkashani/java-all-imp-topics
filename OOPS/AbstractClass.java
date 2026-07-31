public class AbstractClass {

    public static void main(String[] args) {

        // Cannot create object of abstract class.
        Shape shape = new Circle();

        shape.draw();
    }
}

// Abstract class can have abstract methods.
abstract class Shape {

    // Child class must implement this.
    abstract void draw();

    // Abstract class can also have normal methods.
    void welcome() {
        System.out.println("Welcome!");
    }
}

class Circle extends Shape {

    @Override
    void draw() {
        System.out.println("Drawing a Circle.");
    }
}