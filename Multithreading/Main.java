// Multithreading in Java allows concurrent execution of two or more parts of a program.
// A thread is a lightweight sub-process, the smallest unit of execution.
//
// There are two primary ways to create a thread in Java:
// 1. By extending the Thread class:
//    - Inherit from the java.lang.Thread class.
//    - Override the run() method to define the thread's execution logic.
//    - Instantiate the sub-class and invoke start() to begin execution.
// 2. By implementing the Runnable interface:
//    - Implement the java.lang.Runnable interface and define the run() method.
//    - Instantiate the class, pass it to a Thread constructor, and invoke start() on the Thread object.
//    - Note: Implementing Runnable is preferred because Java only supports single inheritance. 
//      Implementing Runnable leaves the class free to inherit from another class.

// Method 1: Extending the Thread class
class MyThread extends Thread {

    @Override
    public void run() {
        for (int i = 1; i <= 150; i++) {
            System.out.println("hello (Thread class)");
        }
    }
}

// Method 2: Implementing the Runnable interface
class MyRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 150; i++) {
            System.out.println("hello (Runnable interface)");
        }
    }
}

public class Main {

    public static void main(String[] args) {

        // 1. Create and start a thread using the Thread class subclass
        MyThread t1 = new MyThread();
        t1.start(); // Starts a new thread (invokes MyThread's run method asynchronously)

        // 2. Create and start a thread using the Runnable interface implementation
        MyRunnable myRunnable = new MyRunnable();
        Thread t2 = new Thread(myRunnable); // Pass Runnable instance to Thread constructor
        t2.start(); // Starts a new thread (invokes MyRunnable's run method asynchronously)

        // Main thread execution
        for (int i = 1; i <= 150; i++) {
            System.out.println("Main Thread");
        }
    }
}
