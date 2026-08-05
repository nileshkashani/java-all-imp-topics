class Bird{
    public void eat(){
        System.out.println("Bird is eating");
    }
}
 
interface Flyable {
    public void fly();
}

class sparrow extends Bird implements Flyable{
    @Override
    public void fly() {
        System.out.println("Sparrow is flying");
    }
}

class Penguin extends Bird {
    public void swim(){
        System.out.println("Penguin is swimming");
    }
}

public class BirdAfterLSP {
    public static void main(String[] args) {
        Penguin p = new Penguin();
        p.swim();
        p.eat();
    }
}
