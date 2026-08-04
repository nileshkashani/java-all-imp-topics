// Main.java - Minimal comments. Refer to README.md for detailed documentation.

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(getName() + " (Thread class) is running... Step: " + i);
            try {
                // Thread.sleep() pauses the execution of the thread
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(getName() + " was interrupted.");
            }
        }
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(Thread.currentThread().getName() + " (Runnable interface) is running... Step: " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " was interrupted.");
            }
        }
    }
}

public class Main {
    private static int counter = 0;

    // Synchronized method to avoid race conditions
    private static synchronized void increment() {
        counter++;
    }

    public static void main(String[] args) {
        System.out.println("=== 1. Starting Threads ===");
        MyThread t1 = new MyThread();
        t1.setName("WorkerThread-1");
        
        Thread t2 = new Thread(new MyRunnable(), "WorkerThread-2");

        // Start execution of both threads
        t1.start();
        t2.start();

        try {
            // join() forces the main thread to wait until t1 and t2 finish execution
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n=== 2. Thread Synchronization ===");
        Thread syncThread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) increment();
        });
        Thread syncThread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) increment();
        });

        syncThread1.start();
        syncThread2.start();

        try {
            syncThread1.join();
            syncThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Final synchronized counter value (Expected 2000): " + counter);

        System.out.println("\n=== 3. Daemon Thread ===");
        Thread daemonThread = new Thread(() -> {
            while (true) {
                System.out.println("Daemon thread background task running...");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    break;
                }
            }
        });
        // Daemon status must be set before starting the thread
        daemonThread.setDaemon(true);
        daemonThread.start();

        System.out.println("Main thread execution finished. Daemon thread exits with JVM.");
    }
}

