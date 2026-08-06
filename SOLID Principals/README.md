# SOLID Principles in Java

**SOLID** is a set of five design principles in Object-Oriented Programming (OOP) introduced by Robert C. Martin (Uncle Bob). These principles help developers write software that is clean, readable, maintainable, and easy to extend over time.

The acronym stands for:
1. **S** - Single Responsibility Principle (SRP)
2. **O** - Open/Closed Principle (OCP)
3. **L** - Liskov Substitution Principle (LSP)
4. **I** - Interface Segregation Principle (ISP)
5. **D** - Dependency Inversion Principle (DIP)

---

## 📌 Directory Navigation
- 📄 [SingleResponsibility.java](file:///c:/Users/Owner/desktop1/Next%20js/java0toHero/SOLID%20Principals/SingleResponsibility.java) — Demo for the Single Responsibility Principle.
- 📄 [OpenClosedPrincipal.java](file:///c:/Users/Owner/desktop1/Next%20js/java0toHero/SOLID%20Principals/OpenClosedPrincipal.java) — Demo for the Open/Closed Principle.
- 📄 [BirdBreforeLSP.java](file:///c:/Users/Owner/desktop1/Next%20js/java0toHero/SOLID%20Principals/BirdBreforeLSP.java) — Violation of Liskov Substitution Principle.
- 📄 [BirdAfterLSP.java](file:///c:/Users/Owner/desktop1/Next%20js/java0toHero/SOLID%20Principals/BirdAfterLSP.java) — Resolution of LSP violation.
- 📄 [InterfaceSegregation.java](file:///c:/Users/Owner/desktop1/Next%20js/java0toHero/SOLID%20Principals/InterfaceSegregation.java) — Demo for the Interface Segregation Principle.

*Note: The remaining principle (Dependency Inversion) will be covered in separate source files in the future.*

---

## 1. S - Single Responsibility Principle (SRP)

> *"A class should have one, and only one, reason to change."*

### 💡 The Core Concept
A class should focus on **one single responsibility or role**. If a class does too many things, it becomes bloated, fragile, and changes in one feature might break unrelated features in the same class.

### 🥖 Real-World Analogy: The Bakery Workflow
In a professional bakery, you don't have one single employee who bakes the bread, manages the inventory, cleans the shop, and handles the cash register. Instead:
- The **Baker** only bakes.
- The **Inventory Manager** only tracks stock levels.
- The **Salesperson** only handles sales and checkout.

### 💻 Code Explanation
In [SingleResponsibility.java](file:///c:/Users/Owner/desktop1/Next%20js/java0toHero/SOLID%20Principals/SingleResponsibility.java), we split these jobs into three dedicated classes:
* `Baker`: Responsible only for the baking logic. (See [SingleResponsibility.java:L13-18](file:///c:/Users/Owner/desktop1/Next%20js/java0toHero/SOLID%20Principals/SingleResponsibility.java#L13-L18))
* `InventoryManager`: Responsible only for managing stock. (See [SingleResponsibility.java:L20-25](file:///c:/Users/Owner/desktop1/Next%20js/java0toHero/SOLID%20Principals/SingleResponsibility.java#L20-L25))
* `SalesPerson`: Responsible only for customer transactions. (See [SingleResponsibility.java:L27-32](file:///c:/Users/Owner/desktop1/Next%20js/java0toHero/SOLID%20Principals/SingleResponsibility.java#L27-L32))

---

## 2. O - Open/Closed Principle (OCP)

> *"Software entities (classes, modules, functions, etc.) should be open for extension, but closed for modification."*

### 💡 The Core Concept
You should be able to add new functionality (extend the behavior) to a class **without modifying** its existing code. If you have to change a class's source code every time requirements change, you risk introducing bugs to already-tested code.

### 🔌 Real-World Analogy: Power Outlets
Wall sockets are designed to be **open for extension** (you can plug in a phone charger, a laptop, or a TV) but **closed for modification** (you don't have to tear open the wall and rewire the house every time you buy a new appliance). The plug interface acts as the contract.

### 💻 Code Explanation
In [OpenClosedPrincipal.java](file:///c:/Users/Owner/desktop1/Next%20js/java0toHero/SOLID%20Principals/OpenClosedPrincipal.java):
* We define a common `PaymentMethod` interface. (See [OpenClosedPrincipal.java:L13-16](file:///c:/Users/Owner/desktop1/Next%20js/java0toHero/SOLID%20Principals/OpenClosedPrincipal.java#L13-L16))
* If we want to add PayPal integration alongside Credit Cards, we do not modify `CreditCardPayment` or `PaymentProcessor`. Instead, we **extend** the behavior by adding a new class `PaypalPayment`. (See [OpenClosedPrincipal.java:L25-30](file:///c:/Users/Owner/desktop1/Next%20js/java0toHero/SOLID%20Principals/OpenClosedPrincipal.java#L25-L30))
* `PaymentProcessor` is **closed for modification** because its `execute()` method takes a polymorphic `PaymentMethod` parameter and runs it without caring about the concrete implementation details. (See [OpenClosedPrincipal.java:L33-39](file:///c:/Users/Owner/desktop1/Next%20js/java0toHero/SOLID%20Principals/OpenClosedPrincipal.java#L33-L39))

---

## 3. L - Liskov Substitution Principle (LSP)

> *"Subtypes must be substitutable for their base types."*

### 💡 The Core Concept
If class `B` is a subclass of class `A`, we should be able to replace `A` with `B` without breaking the correctness or behavior of our program. 
- A subclass should **extend** the behavior of the parent class, but it should not **narrow it down** or disable capabilities expected of the parent.

### 🐧 Real-World Analogy: Toy Duck vs. Real Duck
A kid plays with a toy duck that takes batteries and squeaks. If the kid substitutes a real duck, it doesn't take batteries! Although they both look like "ducks", they cannot be substituted blindly in the same program because the toy duck requires a specific `replaceBatteries()` interface.

### 💻 Code Explanation

#### The Violation:
In [BirdBreforeLSP.java](file:///c:/Users/Owner/desktop1/Next%20js/java0toHero/SOLID%20Principals/BirdBreforeLSP.java), class `Bird` defines a `fly()` method.
- When `Penguin` inherits `Bird`, it is forced to inherit the `fly()` method.
- Since penguins cannot fly, it overrides it to print "cannot fly" (or throw an exception).
- This violates LSP! Any code expecting a `Bird` class to fly will fail or have unexpected behavior when a `Penguin` is passed. (See [BirdBreforeLSP.java:L21-26](file:///c:/Users/Owner/desktop1/Next%20js/java0toHero/SOLID%20Principals/BirdBreforeLSP.java#L21-L26)).

#### The Solution:
In [BirdAfterLSP.java](file:///c:/Users/Owner/desktop1/Next%20js/java0toHero/SOLID%20Principals/BirdAfterLSP.java), we solve this:
- We remove `fly()` from the base `Bird` class because not all birds can fly. (See [BirdAfterLSP.java:L12-16](file:///c:/Users/Owner/desktop1/Next%20js/java0toHero/SOLID%20Principals/BirdAfterLSP.java#L12-L16)).
- We create a separate `Flyable` interface. (See [BirdAfterLSP.java:L19-21](file:///c:/Users/Owner/desktop1/Next%20js/java0toHero/SOLID%20Principals/BirdAfterLSP.java#L19-L21)).
- `sparrow` inherits `Bird` and implements `Flyable` because it can fly. (See [BirdAfterLSP.java:L24-29](file:///c:/Users/Owner/desktop1/Next%20js/java0toHero/SOLID%20Principals/BirdAfterLSP.java#L24-L29)).
- `Penguin` inherits `Bird` but does not implement `Flyable`. It can implement other behaviors like `swim()`. (See [BirdAfterLSP.java:L32-37](file:///c:/Users/Owner/desktop1/Next%20js/java0toHero/SOLID%20Principals/BirdAfterLSP.java#L32-L37)).
- Now, client code can substitute subclasses of `Bird` safely without unexpected errors.

---

## 4. I - Interface Segregation Principle (ISP)

> *"Clients should not be forced to depend on interfaces they do not use."*

### 💡 The Core Concept
Focuses on keeping interfaces specific and well-defined. We should avoid "fat" interfaces by using multiple small, client-specific interfaces, each with a clear and specific responsibility. This ensures that implementing classes are not forced to write dummy implementations for methods they don't need.

### 🥖 Real-World Analogy: The Restaurant Menu
Suppose you enter a restaurant and you are a pure vegetarian. If the waiter gives you a general menu card that includes vegetarian items, non-vegetarian items, drinks, and sweets, you are forced to parse information that is irrelevant to you.
Instead:
- The customer should receive a menu relevant to their needs (vegetarian only).
- Splitting a common, large menu into smaller, specific menus reduces unnecessary dependencies and minimizes future changes.

### 💻 Code Explanation
In [InterfaceSegregation.java](file:///c:/Users/Owner/desktop1/Next%20js/java0toHero/SOLID%20Principals/InterfaceSegregation.java), we split a single general menu interface into smaller, specialized interfaces:
* `IVegetarianMenu`: (See [InterfaceSegregation.java:L18-20](file:///c:/Users/Owner/desktop1/Next%20js/java0toHero/SOLID%20Principals/InterfaceSegregation.java#L18-L20))
* `INonVegetarianMenu`: (See [InterfaceSegregation.java:L23-25](file:///c:/Users/Owner/desktop1/Next%20js/java0toHero/SOLID%20Principals/InterfaceSegregation.java#L23-L25))
* `IDrinkMenu`: (See [InterfaceSegregation.java:L28-30](file:///c:/Users/Owner/desktop1/Next%20js/java0toHero/SOLID%20Principals/InterfaceSegregation.java#L28-L30))

These interfaces are implemented by specialized classes that only contain the relevant items:
* `VegetarianMenu` implements `IVegetarianMenu`. (See [InterfaceSegregation.java:L33-38](file:///c:/Users/Owner/desktop1/Next%20js/java0toHero/SOLID%20Principals/InterfaceSegregation.java#L33-L38))
* `NonVegetarianMenu` implements `INonVegetarianMenu`. (See [InterfaceSegregation.java:L41-46](file:///c:/Users/Owner/desktop1/Next%20js/java0toHero/SOLID%20Principals/InterfaceSegregation.java#L41-L46))
* `DrinkMenu` implements `IDrinkMenu`. (See [InterfaceSegregation.java:L49-54](file:///c:/Users/Owner/desktop1/Next%20js/java0toHero/SOLID%20Principals/InterfaceSegregation.java#L49-L54))

Finally, `MenuDisplay` accesses these specific interfaces to only print the menus relevant to the specific customer type, avoiding any unnecessary dependencies. (See [InterfaceSegregation.java:L57-71](file:///c:/Users/Owner/desktop1/Next%20js/java0toHero/SOLID%20Principals/InterfaceSegregation.java#L57-L71))

