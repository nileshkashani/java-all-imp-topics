# Java Enums (Enumerations)

An **Enum** (short for enumeration) is a special Java type used to define a collection of constants (unchangeable values). Using enums is much better than declaring static final variables because it provides **type-safety** and makes the code cleaner and more readable.

---

## 📌 Directory Navigation
- 📄 [BasicEnumDemo.java](file:///c:/Users/Owner/desktop1/Next%20js/java0toHero/Enums/BasicEnumDemo.java) — Basic enum declarations, comparisons, switch statements, and built-in methods.
- 📄 [AdvancedEnumDemo.java](file:///c:/Users/Owner/desktop1/Next%20js/java0toHero/Enums/AdvancedEnumDemo.java) — Enums with fields, custom constructors, getters, instance methods, and abstract methods.

---

## 1. Basic Enums
A simple enum contains just a list of constants. We demonstrate basic enums in [BasicEnumDemo.java](file:///c:/Users/Owner/desktop1/Next%20js/java0toHero/Enums/BasicEnumDemo.java):

### Declaring an Enum
You define an enum using the `enum` keyword:
```java
enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}
```
* **Code Reference:** See [BasicEnumDemo.java:L3-11](file:///c:/Users/Owner/desktop1/Next%20js/java0toHero/Enums/BasicEnumDemo.java#L3-L11).

### A. Referencing & Comparing Enums
Enums are compared using the `==` operator rather than the `.equals()` method. This is safe because each enum constant is unique (singleton):
```java
Day today = Day.WEDNESDAY;
if (today == Day.WEDNESDAY) { ... }
```
* **Code Reference:** See [BasicEnumDemo.java:L15-22](file:///c:/Users/Owner/desktop1/Next%20js/java0toHero/Enums/BasicEnumDemo.java#L15-L22).

### B. Enum in Switch Statement
Enums make switch statements clean. Note that you don't prefix constants inside the `case` blocks (write `case MONDAY`, not `case Day.MONDAY`):
* **Code Reference:** See [BasicEnumDemo.java:L24-42](file:///c:/Users/Owner/desktop1/Next%20js/java0toHero/Enums/BasicEnumDemo.java#L24-L42).

### C. Built-in Methods
Every Java enum inherits the following built-in methods from `java.lang.Enum`:
1. `values()`: Returns an array of all enum constants. Great for iterating through enums.
2. `ordinal()`: Returns the index of the constant in the enum declaration (starts at `0`).
3. `valueOf(String)`: Converts a String into its corresponding enum constant (case-sensitive).
* **Code Reference:** See [BasicEnumDemo.java:L44-59](file:///c:/Users/Owner/desktop1/Next%20js/java0toHero/Enums/BasicEnumDemo.java#L44-L59).

---

## 2. Advanced Enums (Enums as Classes)
Unlike some other languages, Java enums are full-featured classes. This allows them to contain properties and behaviors. We demonstrate advanced enums in [AdvancedEnumDemo.java](file:///c:/Users/Owner/desktop1/Next%20js/java0toHero/Enums/AdvancedEnumDemo.java):

### A. Fields & Custom Constructor
You can attach additional values to each enum constant. To do this, you define fields and a constructor:
- **Important:** Enum constructors **must** be `private`. You cannot instantiate an enum yourself using `new`. The JVM instantiates them automatically.
```java
enum OrderStatus {
    PENDING(1, "Placed but not processed"),
    PROCESSING(2, "Being packed");

    private final int code;
    private final String description;

    private OrderStatus(int code, String description) {
        this.code = code;
        this.description = description;
    }
}
```
* **Code Reference:** See [AdvancedEnumDemo.java:L43-53](file:///c:/Users/Owner/desktop1/Next%20js/java0toHero/Enums/AdvancedEnumDemo.java#L43-L53).

### B. Getter & Instance Methods
You can define public getter methods to retrieve these fields, as well as regular instance methods to evaluate conditions:
```java
public int getCode() { return this.code; }
public boolean isFinalState() { return this == DELIVERED || this == CANCELLED; }
```
* **Code Reference:** See [AdvancedEnumDemo.java:L55-66](file:///c:/Users/Owner/desktop1/Next%20js/java0toHero/Enums/AdvancedEnumDemo.java#L55-L66).

### C. Abstract Methods in Enums
You can declare an abstract method inside an enum. If you do, **every individual constant** must override and implement this method. This is incredibly powerful for applying state-pattern transitions or behavior specialization:
```java
public abstract boolean canTransitionTo(OrderStatus nextStatus);
```
* **Code Reference:** See [AdvancedEnumDemo.java:L68-71](file:///c:/Users/Owner/desktop1/Next%20js/java0toHero/Enums/AdvancedEnumDemo.java#L68-L71) and individual constant overrides in [AdvancedEnumDemo.java:L5-41](file:///c:/Users/Owner/desktop1/Next%20js/java0toHero/Enums/AdvancedEnumDemo.java#L5-L41).
