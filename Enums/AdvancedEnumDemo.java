// In Java, an enum is more than a list of constants. It is a full class!
// This means it can have fields, constructors, methods, and even implement interfaces or abstract methods.
enum OrderStatus {
    // 1. Defining enum constants with values passed to the constructor.
    // Each constant also implements the abstract method 'canTransitionTo'.
    
    PENDING(1, "Order has been placed but not processed yet") {
        @Override
        public boolean canTransitionTo(OrderStatus nextStatus) {
            // A pending order can be processed or cancelled.
            return nextStatus == PROCESSING || nextStatus == CANCELLED;
        }
    },
    PROCESSING(2, "Order is being packed and prepared") {
        @Override
        public boolean canTransitionTo(OrderStatus nextStatus) {
            // A processing order can be shipped or cancelled.
            return nextStatus == SHIPPED || nextStatus == CANCELLED;
        }
    },
    SHIPPED(3, "Order is in transit") {
        @Override
        public boolean canTransitionTo(OrderStatus nextStatus) {
            // A shipped order can only progress to delivered.
            return nextStatus == DELIVERED;
        }
    },
    DELIVERED(4, "Order has reached its destination") {
        @Override
        public boolean canTransitionTo(OrderStatus nextStatus) {
            // Delivered is a final state; cannot transition further.
            return false;
        }
    },
    CANCELLED(5, "Order was cancelled") {
        @Override
        public boolean canTransitionTo(OrderStatus nextStatus) {
            // Cancelled is a final state; cannot transition further.
            return false;
        }
    };

    // 2. Custom fields
    private final int code;
    private final String description;

    // 3. Custom Constructor
    // Note: Enum constructors MUST be private. You cannot call 'new OrderStatus(...)' outside of this enum.
    // The constructor is automatically called by the JVM to instantiate the constants.
    private OrderStatus(int code, String description) {
        this.code = code;
        this.description = description;
    }

    // 4. Custom Getter Methods
    public int getCode() {
        return this.code;
    }

    public String getDescription() {
        return this.description;
    }

    // 5. Normal Instance Method
    public boolean isFinalState() {
        return this == DELIVERED || this == CANCELLED;
    }

    // 6. Abstract Method
    // Each enum constant is forced to override this method and implement its own logic.
    public abstract boolean canTransitionTo(OrderStatus nextStatus);
}

public class AdvancedEnumDemo {
    public static void main(String[] args) {
        // Retrieve current status
        OrderStatus status = OrderStatus.PENDING;

        System.out.println("--- Current Order Details ---");
        System.out.println("Status: " + status);
        System.out.println("Status Code: " + status.getCode());
        System.out.println("Description: " + status.getDescription());
        System.out.println("Is Final State? " + status.isFinalState());

        System.out.println("\n--- Testing Transitions ---");
        
        OrderStatus next = OrderStatus.PROCESSING;
        System.out.println("Can transition from " + status + " to " + next + "? " + status.canTransitionTo(next));
        
        next = OrderStatus.DELIVERED;
        System.out.println("Can transition from " + status + " to " + next + "? " + status.canTransitionTo(next));

        // Iterate over advanced enum constants
        System.out.println("\n--- All Available Statuses ---");
        for (OrderStatus os : OrderStatus.values()) {
            System.out.println("Code: " + os.getCode() + " | Status: " + os + " | Final state: " + os.isFinalState());
        }
    }
}
