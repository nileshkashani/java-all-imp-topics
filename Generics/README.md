# Java Generics

Welcome!

This folder contains a beginner-friendly guide to **Generics** in Java. Every concept is explained using clear, simple language and accompanied by clean, well-commented code.

Whether you're learning Java for the first time, preparing for interviews, or revising for exams, these examples will help you master compile-time type safety and code reusability in Java.

---

# What are Generics?

Generics refer to parameterized types that allow writing code which works with multiple data types using a single class, interface, or method. They improve reusability and ensure type safety at compile time.

Think of it like this:
```text
Type Parameters → "Placeholders like <T> representing different types of objects"
Type Safety     → "Errors caught at compile time instead of failing at runtime"
Reusability     → "Write the logic once, use it for Integers, Strings, custom classes"
```

---

# Topics Covered

| Topic | What You'll Learn | Code |
|-------|-------------------|------|
| **Generic Classes** | Understand how to create class-level parameterized types and instantiate them. Learn how `T` acts as a placeholder. | [View Code](./Generics.java) |

---

# Core Concepts in Detail

## 1. Why Use Generics?
Before Java introduced Generics in JDK 5, collections like `ArrayList` stored objects as `Object` types. This had two major problems:
- **Manual Casting**: You had to manually cast the retrieved objects back to their original type.
- **Runtime Crashes**: If you mistakenly cast to the wrong type, the program crashed at runtime (e.g., throwing a `ClassCastException`).

```java
// BEFORE GENERICS (Prone to runtime errors)
List list = new ArrayList();
list.add("Hello");
String s = (String) list.get(0); // Manual cast required!

// WITH GENERICS (Compile-time type safety)
List<String> list = new ArrayList<>();
list.add("Hello");
String s = list.get(0); // No casting required, compiler checks everything!
```

---

## 2. Generic Classes & Wrapper Limitation
A generic class is declared by adding a type parameter (like `<T>`) after the class name. Within the class, `T` behaves like a normal type and is replaced with a concrete class type during object creation.

```java
class Test<T> {
    T obj;
    Test(T obj) { this.obj = obj; }
    T getObject() { return obj; }
}
```

### Wrapper Classes Restriction
> [!IMPORTANT]
> You **cannot** use primitives (like `int`, `char`, `double`, `boolean`) as type parameters. You must use their respective **Wrapper Classes** instead (e.g., `Integer`, `Character`, `Double`, `Boolean`).

```java
// INCORRECT
Test<int> obj = new Test<int>(10); // Compile-time error

// CORRECT
Test<Integer> obj = new Test<Integer>(10); // Works perfectly!
```

---

# Code Navigation

```text
Generics
│
├── README.md              (This Guide)
└── Generics.java          (Generic class definition & usage examples)
```

---

# What to Learn Next

After mastering Generics, you can continue with:

- Collections Framework (which heavily uses Generics)
- Generic Methods and Wildcards (`?`, `extends`, `super`)
- Multithreading

---

# Support

If you found this guide helpful, consider giving the repository a **Star**! Your support is highly appreciated.
