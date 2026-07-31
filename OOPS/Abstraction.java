public class Abstraction {

    public static void main(String[] args) {

        // We cannot create Shape directly.
        Shape shape = new Circle();

        shape.draw();
    }
}

// Abstract class can have abstract methods.
abstract class Shape {

    // Child classes must implement this method.
    abstract void draw();
}

// Circle provides its own implementation.
class Circle extends Shape {

    @Override
    void draw() {
        System.out.println("Drawing a Circle.");
    }
}