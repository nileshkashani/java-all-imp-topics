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

*Note: The remaining three principles (Liskov Substitution, Interface Segregation, and Dependency Inversion) will be covered in separate source files in the future.*

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
