# Java Annotations

Annotations in Java provide **metadata** (data about data) for our code. They do not directly change the execution of the code, but they are incredibly useful for giving instructions to the compiler, IDE, or runtime environments.

---

## 📌 Directory Navigation
- 📄 [Main.java](file:///c:/Users/Owner/desktop1/Next%20js/java0toHero/Annotations/Main.java) — Examples of built-in annotations.
- 📄 [CreatingCustomAnnotation.java](file:///c:/Users/Owner/desktop1/Next%20js/java0toHero/Annotations/CreatingCustomAnnotation.java) — Creating custom annotations and reading them via Reflection.

---

## 1. Built-in Annotations
Java provides several standard built-in annotations to help you write cleaner code and avoid common mistakes. These are demonstrated in [Main.java](file:///c:/Users/Owner/desktop1/Next%20js/java0toHero/Annotations/Main.java):

### A. `@Override`
* **What it does:** Tells the compiler that the annotated method overrides a method from a parent class or an interface.
* **Why it's useful:** It prevents spelling mistakes. If you misspell the method name or mismatch the parameters, the compiler will instantly show an error.
* **Code Reference:** See [Main.java:L17-26](file:///c:/Users/Owner/desktop1/Next%20js/java0toHero/Annotations/Main.java#L17-L26) where the `greet()` method overrides the interface.

### B. `@Deprecated`
* **What it does:** Marks a method, class, or field as outdated/obsolete.
* **Why it's useful:** It warns other developers that they should avoid using this element because it may be removed in future versions of your code.
* **Code Reference:** See [Main.java:L49-57](file:///c:/Users/Owner/desktop1/Next%20js/java0toHero/Annotations/Main.java#L49-L57) where `oldMethod()` is marked deprecated.

### C. `@SuppressWarnings`
* **What it does:** Instructs the compiler to silence specific compiler warnings.
* **Why it's useful:** If you intentionally write raw types (non-generic collections) or have unused variables, you can prevent warnings from cluttering your console.
* **Code Reference:** See [Main.java:L36-47](file:///c:/Users/Owner/desktop1/Next%20js/java0toHero/Annotations/Main.java#L36-L47) where `@SuppressWarnings("rawtypes")` is used.

### D. `@FunctionalInterface`
* **What it does:** Ensures that an interface has exactly **one** abstract method.
* **Why it's useful:** It prevents developers from accidentally adding more abstract methods to the interface. Functional interfaces are crucial for implementing Lambda Expressions.
* **Code Reference:** See [Main.java:L4-13](file:///c:/Users/Owner/desktop1/Next%20js/java0toHero/Annotations/Main.java#L4-L13) where `interface Nilesh` is defined.

---

## 2. Custom Annotations
Java allows you to define your own annotations using the `@interface` keyword. This is demonstrated in [CreatingCustomAnnotation.java](file:///c:/Users/Owner/desktop1/Next%20js/java0toHero/Annotations/CreatingCustomAnnotation.java).

Creating custom annotations consists of three key steps:

### Step 1: Defining the Annotation & Meta-Annotations
We use meta-annotations (annotations that apply to other annotations) to define how our annotation works:
* `@Target(ElementType.METHOD)`: Restricts the annotation so it can only be placed on methods.
* `@Retention(RetentionPolicy.RUNTIME)`: Ensures the annotation is stored in the `.class` file and remains available at runtime, allowing us to read it programmatically.

```java
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface ExampleCustomAnnotation {
    String message(); // This acts as an attribute of the annotation
}
```
* **Code Reference:** See [CreatingCustomAnnotation.java:L7-22](file:///c:/Users/Owner/desktop1/Next%20js/java0toHero/Annotations/CreatingCustomAnnotation.java#L7-L22).

### Step 2: Applying the Custom Annotation
We apply the annotation to a method by prefixing it with `@` and specifying values for its attributes:
```java
@ExampleCustomAnnotation(message = "nilesh")
public void greet() { ... }
```
* **Code Reference:** See [CreatingCustomAnnotation.java:L26-29](file:///c:/Users/Owner/desktop1/Next%20js/java0toHero/Annotations/CreatingCustomAnnotation.java#L26-L29).

### Step 3: Reading Annotations dynamically using Reflection
Because we specified `RetentionPolicy.RUNTIME`, we can inspect the method at runtime to fetch the annotation value:
1. **Get the class template:** `this.getClass()`
2. **Find the target method:** `getClass().getDeclaredMethod("greet")`
3. **Extract the custom annotation:** `m.getAnnotation(ExampleCustomAnnotation.class)`
4. **Access the value:** `annotation.message()`

* **Code Reference:** See [CreatingCustomAnnotation.java:L31-43](file:///c:/Users/Owner/desktop1/Next%20js/java0toHero/Annotations/CreatingCustomAnnotation.java#L31-L43).
