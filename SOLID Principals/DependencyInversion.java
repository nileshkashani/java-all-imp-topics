/**
 * DEPENDENCY INVERSION PRINCIPLE (DIP)
 * 
 * Definition:
 * 1. High-level modules should not depend on low-level modules. Both should depend on abstractions.
 * 2. Abstractions should not depend on details. Details should depend on abstractions.
 * 
 * Analogy:
 * Consider a desktop computer. If the computer's motherboard was directly soldered to a specific keyboard 
 * and monitor model, you couldn't upgrade or change them without replacing or rebuilding the computer.
 * Instead, computers use standardized ports/interfaces (like USB and HDMI). The Computer (high-level)
 * depends on these ports (abstractions), and Keyboards/Monitors (low-level/details) implement these 
 * interfaces. This allows you to swap any USB keyboard or HDMI monitor seamlessly.
 */

// 1. Abstraction for Keyboard input device
interface Keyboard {
    void type();
}

// 2. Abstraction for Monitor display device
interface Monitor {
    void display();
}

// Concrete Low-level implementation: Mechanical Keyboard
class MechanicalKeyboard implements Keyboard {
    @Override
    public void type() {
        System.out.println("Typing on a Mechanical Keyboard (click-clack!)...");
    }
}

// Concrete Low-level implementation: Membrane Keyboard
class MembraneKeyboard implements Keyboard {
    @Override
    public void type() {
        System.out.println("Typing on a quiet Membrane Keyboard...");
    }
}

// Concrete Low-level implementation: LED Monitor
class LEDMonitor implements Monitor {
    @Override
    public void display() {
        System.out.println("Displaying high-resolution colors on LED Monitor...");
    }
}

// Concrete Low-level implementation: Projector
class Projector implements Monitor {
    @Override
    public void display() {
        System.out.println("Projecting screen onto a large wall...");
    }
}

// High-level module: WindowsComputer
// It does not depend on concrete MechanicalKeyboard or LEDMonitor classes.
// Instead, it depends on Keyboard and Monitor interfaces via constructor dependency injection.
class WindowsComputer {
    private final Keyboard keyboard;
    private final Monitor monitor;

    // Depend on abstractions in the constructor
    public WindowsComputer(Keyboard keyboard, Monitor monitor) {
        this.keyboard = keyboard;
        this.monitor = monitor;
    }

    public void startWorking() {
        System.out.println("Computer is starting up...");
        keyboard.type();
        monitor.display();
    }
}

public class DependencyInversion {
    public static void main(String[] args) {
        // We can build a Computer using a Mechanical Keyboard and LED Monitor
        Keyboard mechKeyboard = new MechanicalKeyboard();
        Monitor ledMonitor = new LEDMonitor();
        WindowsComputer officePC = new WindowsComputer(mechKeyboard, ledMonitor);
        
        System.out.println("--- Office PC ---");
        officePC.startWorking();

        System.out.println();

        // Or we can build one using a Membrane Keyboard and a Projector,
        // without changing the WindowsComputer class at all!
        Keyboard silentKeyboard = new MembraneKeyboard();
        Monitor largeProjector = new Projector();
        WindowsComputer presentationPC = new WindowsComputer(silentKeyboard, largeProjector);

        System.out.println("--- Presentation PC ---");
        presentationPC.startWorking();
    }
}
