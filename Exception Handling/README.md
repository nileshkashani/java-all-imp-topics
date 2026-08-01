# Java Exception Handling

Welcome!

This folder contains a beginner-friendly guide to **Exception Handling** in Java. Every concept is explained using clear, simple language and accompanied by clean, well-commented code.

Whether you're learning Java for the first time, preparing for interviews, or revising for exams, these examples will help you master runtime error management in Java.

---

# What is Exception Handling?

Exception Handling is a mechanism in Java to handle runtime errors (such as `ArithmeticException`, `IOException`, `NullPointerException`, etc.) so that the normal flow of the application can be maintained and the program doesn't crash abruptly.

Think of it like this:
```text
Try Block     → "Let's run this code, it might crash"
Catch Block   → "If it crashes, do this instead"
Finally Block → "No matter what, do this cleanup"
```

---

# Topics Covered

| Topic | What You'll Learn | Code |
|-------|-------------------|------|
| **Try-Catch Block** | Learn how to capture exceptions at runtime and handle them gracefully using standard `try-catch` structures. | [View Code](./TryCatch.java) |
| **Exception Types** | Understand the Java exception hierarchy, differentiating between Checked (compile-time) and Unchecked (runtime) exceptions. | [View Code](./ExceptionTypes.java) |
| **Finally Block** | Learn how to perform cleanup operations. Understand when a `finally` block runs and the special scenarios where it doesn't. | [View Code](./FinallyBlock.java) |
| **Throw Keyword** | Learn how to explicitly throw built-in exceptions and create/throw custom exceptions under specific logic rules. | [View Code](./ThrowKeyword.java) |
| **Throws Keyword** | Understand exception propagation and how to declare exceptions in method signatures. | [View Code](./ThrowsKeyword.java) |

---

# Core Concepts in Detail

## 1. Java Exception Hierarchy

All exception and error classes inherit from the `Throwable` class:

```text
          Throwable
         /         \
    Exception       Error
     /     \          \ (e.g., OutOfMemoryError, StackOverflowError)
Checked   RuntimeException
Exceptions    \ (Unchecked Exceptions)
(e.g.,         (e.g., NullPointerException, ArithmeticException)
IOException)
```

- **Error**: Represents serious problems that a reasonable application should not try to catch (e.g., system out of memory, stack overflow).
- **Exception**: Represents conditions that a reasonable application might want to catch.

### Checked vs. Unchecked Exceptions

- **Checked Exceptions (Compile-time)**:
  - Checked at compile-time. The compiler forces the programmer to handle them using `try-catch` or declare them using `throws`.
  - *Use Cases*: Handling external factors beyond your direct control (e.g., opening files, database queries, network connections).
  - *Examples*: `IOException`, `FileNotFoundException`, `SQLException`.
- **Unchecked Exceptions (Runtime)**:
  - Not checked at compile-time. They extend `RuntimeException`.
  - *Use Cases*: Logic errors, programming bugs that can be avoided by writing better code.
  - *Examples*: `NullPointerException`, `ArithmeticException`, `ArrayIndexOutOfBoundsException`.

---

## 2. Finally Block and Non-Execution Conditions

The `finally` block is used to execute cleanup code (like closing streams, files, or database connections). It executes whether an exception occurs or not.

### When does `finally` NOT execute?
1. **JVM Termination**: If `System.exit(int status)` is called inside the `try` or `catch` block.
2. **JVM Crash**: If the Java Virtual Machine runs out of memory or crashes due to native errors.
3. **Infinite Loops or Thread Interruption**: If the thread executing the `try`/`catch` block gets stuck in an infinite loop or is terminated/killed abruptly before entering the `finally` block.

---

## 3. Throw vs. Throws

Both keywords are related to throwing exceptions, but they serve completely different purposes:

| Feature | `throw` | `throws` |
|---------|---------|----------|
| **Purpose** | Used to explicitly throw a single exception instance. | Used in method signatures to declare exceptions that might be thrown. |
| **Location** | Used inside a method body. | Used in the method signature. |
| **Syntax** | Followed by an exception *instance* (e.g., `throw new ArithmeticException()`). | Followed by exception *class names* (e.g., `throws IOException`). |
| **Capacity** | Can only throw one exception at a time. | Can declare multiple exceptions separated by commas (e.g., `throws IOException, SQLException`). |

---

# Code Navigation

```text
Exception Handling
│
├── README.md              (This Guide)
├── TryCatch.java          (Basic Exception Handling)
├── ExceptionTypes.java    (Checked vs Unchecked Exceptions)
├── FinallyBlock.java      (Cleanup and JVM exit conditions)
├── ThrowKeyword.java      (Explicit & Custom Exception Throwing)
└── ThrowsKeyword.java     (Exception Declaration & Propagation)
```

---

# What to Learn Next

After mastering Exception Handling, you can continue with:

- Collections Framework
- File Handling (using `try-with-resources`)
- Multithreading
- Generics

---

# Support

If you found this guide helpful, consider giving the repository a **Star**! Your support is highly appreciated.
