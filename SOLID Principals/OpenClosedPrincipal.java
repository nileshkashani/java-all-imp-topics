/**
 * OPEN/CLOSED PRINCIPLE (OCP)
 * 
 * Definition: Software entities (classes, modules, functions, etc.) should be 
 * OPEN for extension but CLOSED for modification.
 * 
 * In this design, we can easily add new payment methods (like Credit Card, UPI, etc.)
 * by implementing the PaymentMethod interface, without modifying the existing payment classes
 * or the core PaymentProcessor.
 */

// Common interface for payment methods
interface PaymentMethod {
    void process();
}

// 1. Core payment process (e.g. Credit Card)
class CreditCardPayment implements PaymentMethod {
    @Override
    public void process() {
        System.out.println("Processing Credit Card payment...");
    }
}

// 2. Extending behavior: Adding PayPal integration without modifying CreditCardPayment
class PaypalPayment implements PaymentMethod {
    @Override
    public void process() {
        System.out.println("Integrating and processing PayPal payment...");
    }
}

// 3. PaymentProcessor is closed for modification.
// It can handle any PaymentMethod without needing if-else or switch modifications!
class PaymentProcessor {
    public void execute(PaymentMethod paymentMethod) {
        paymentMethod.process();
    }
}

public class OpenClosedPrincipal {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();

        // Using standard credit card payment
        PaymentMethod card = new CreditCardPayment();
        processor.execute(card);

        // Using extended Paypal integration
        PaymentMethod paypal = new PaypalPayment();
        processor.execute(paypal);
    }    
}

