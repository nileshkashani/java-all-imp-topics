package OOPS;


public class Interfaces {

    public static void main(String[] args) {

        Car car = new Car();

        car.start();
        car.stop();
    }
}

// Interface defines what a class should do.
interface Vehicle {

    void start();

    void stop();
}

// A class implements an interface.
class Car implements Vehicle {

    @Override
    public void start() {
        System.out.println("Car Started.");
    }

    @Override
    public void stop() {
        System.out.println("Car Stopped.");
    }
}