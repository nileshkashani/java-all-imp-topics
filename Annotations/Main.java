
interface Nilesh {
    void greet();
}

public class Main implements Nilesh {
    //examples of built in annotations

    //1.
    @Override
    public void greet() {
        System.out.println("hello");
    }

    public static void main(String[] args) {
        Main mainObj = new Main();
        mainObj.greet();
    }   
    
    //2.
}
