class Bird{
    public void fly(){
        System.out.println("Bird is flying");
    }

    public void eat(){
        System.out.println("Bird is eating");
    }
}

class Penguin extends Bird{
    public void fly(){
        System.out.println("Penguin cannot fly"); //VIOLATES LSP
    }
}

public class BirdBreforeLSP {
    public static void main(String[] args) {
        Bird p = new Penguin();
        p.fly(); //VIOLATES LSP to fix, we can create interface named Flyable and implement it in only specific child class which can fly.
        p.eat();    
    }
}
