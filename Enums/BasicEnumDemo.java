// Defining the Enum. An Enum (short for enumeration) is a special Java type
// that represents a fixed set of constants (unchangeable values).
enum Day {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY
}

public class BasicEnumDemo {
    public static void main(String[] args) {
        
        // 1. Assigning and referencing an enum constant
        Day today = Day.WEDNESDAY;
        System.out.println("Today is: " + today);

        // 2. Comparing enums
        // In Java, enums can be compared safely using the == operator because
        // they are singletons (only one instance of each constant exists).
        if (today == Day.WEDNESDAY) {
            System.out.println("It is mid-week!");
        }

        // 3. Using Enums in a Switch statement
        // Note: When switching on an enum, you do NOT write 'Day.MONDAY', just use the constant name 'MONDAY'.
        switch (today) {
            case MONDAY:
                System.out.println("Mondays are tough!");
                break;
            case FRIDAY:
                System.out.println("Fridays are great!");
                break;
            case SATURDAY:
            case SUNDAY:
                System.out.println("It is the weekend!");
                break;
            default:
                System.out.println("Just a regular weekday.");
                break;
        }

        // 4. Built-in Enum Methods
        System.out.println("\n--- Built-in Enum Methods ---");

        // values(): Returns an array containing all constants in the enum.
        System.out.println("Listing all days in order:");
        for (Day d : Day.values()) {
            // ordinal(): Returns the order/index of the enum constant (starting at 0).
            System.out.println("Index " + d.ordinal() + ": " + d);
        }

        // valueOf(String): Converts a string matching an enum constant name into that constant.
        // Note: This is case-sensitive and must match exactly.
        String inputDay = "FRIDAY";
        Day parsedDay = Day.valueOf(inputDay);
        System.out.println("\nParsed Day from string '" + inputDay + "': " + parsedDay);
    }
}
