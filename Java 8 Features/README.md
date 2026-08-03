# Java 8 Features

Welcome!

This directory contains a beginner-friendly guide to the features introduced in **Java 8**. Java 8 was one of the most significant releases of the Java programming language because it introduced functional programming concepts, making code more concise, readable, and expressive.

Every feature here is documented with single-line comments so you can easily understand what each line of code is doing.

---

# Key Concepts Covered

| Feature | Description | File |
| :--- | :--- | :--- |
| **Lambda Expressions** | Learn how to write concise, anonymous functions using the `(parameters) -> body` syntax and work with functional interfaces (like `Predicate`, `Consumer`, `Supplier`, `Function`). | [View Code](./Lambda.java) |
| **Method References** | Learn the shorthand notation for lambdas using the `::` operator (Static methods, instance methods of specific objects, arbitrary object instance methods, and constructor references). | [View Code](./MethodReferences.java) |
| **Stream API** | Master working with sequences of data using pipeline processing (sources, intermediate lazy operations like `filter()`/`map()`, and terminal operations like `forEach()`/`collect()`). | [View Code](./Streams.java) |
| **Default & Static Methods** | Understand how default and static concrete methods can exist in interfaces, and how multiple inheritance default method conflicts are resolved. | [View Code](./DefaultStaticMethods.java) |
| **Optional Class** | See how to use `Optional<T>` to avoid `NullPointerException` (NPE) and handle missing values safely using fallback strategies. | [View Code](./OptionalExample.java) |
| **Date and Time API** | Use the modern, thread-safe `java.time` package featuring `LocalDate`, `LocalTime`, `LocalDateTime`, `ZonedDateTime`, `DateTimeFormatter`, `Period`, and `Duration`. | [View Code](./DateTimeAPI.java) |
| **StringJoiner & Base64** | Learn utility features like joining collections of strings with delimiters, prefix, and suffix, and encoding/decoding messages using the built-in `Base64` class. | [View Code](./StringJoinerBase64.java) |

---

# Why is Java 8 so Important?

Java 8 represented a massive shift in how we write Java. Before Java 8, Java was purely object-oriented and often required verbose, boilerplate-heavy code (e.g. using anonymous inner classes for simple listeners). 

By introducing **Functional Interfaces** and **Lambda Expressions**, Java allowed programmers to pass functions as arguments, enabling:
1. **Conciseness**: Write significantly less boilerplate code.
2. **Readability**: Easier to understand intent (especially when utilizing the Stream API).
3. **Parallel Execution**: Making parallel processing of streams easy without having to manually manage threads.
4. **Safety**: Overhauling legacy date/time calculations and reducing null reference exceptions.

---

# How to Run the Code

To run any of the files in this directory, open your terminal inside this folder and run:
```bash
javac <FileName>.java
java <FileName>
```

For example, to run the Stream API example:
```bash
javac Streams.java
java Streams
```
