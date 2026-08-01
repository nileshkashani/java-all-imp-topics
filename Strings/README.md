# Java Strings

Welcome!

This folder contains a beginner-friendly guide to **Strings** in Java. Every concept is explained using clear, simple language and accompanied by clean, well-commented code.

Whether you're learning Java for the first time, preparing for interviews, or revising for exams, these examples will help you master string manipulation and properties in Java.

---

# What is a String in Java?

A String in Java is an object that represents a sequence of character values. In Java, strings are **immutable**, which means once a String object is created, its value cannot be changed.

Think of it like this:
```text
String Pool  → "Memory space optimized for storing unique string literals"
Immutability → "Modifying a string actually creates a brand new string"
Comparison   → ".equals() checks content, whereas == checks reference (address)"
```

---

# Topics Covered

| Topic | What You'll Learn | Code |
|-------|-------------------|------|
| **String Declaration** | Understand how to declare strings and learn about the concept of immutability. | [View Code](./StringDeclaration.java) |
| **String Concatenation** | Learn how to join multiple strings together using the `+` operator and `.concat()` method. | [View Code](./StringConcatenation.java) |
| **String Comparison** | Understand the difference between `.equals()`, `.equalsIgnoreCase()`, and `==`. | [View Code](./StringComparison.java) |
| **String Methods** | Master essential built-in string helper functions like `.length()`, `.substring()`, case conversions, and trimming. | [View Code](./StringMethods.java) |
| **Escape Sequences** | Learn how to format and display special characters like quotes, backslashes, tabs, and newlines in Java. | [View Code](./EscapeSequences.java) |
| **String Numeric Addition** | Understand Java's left-to-right evaluation and coercion rules when mixing strings and numbers with the `+` operator. | [View Code](./StringNumericAddition.java) |

---

# Core Concepts in Detail

## 1. Immutability
In Java, String objects are immutable. Any modification (like appending, changing characters, or case conversion) does not modify the original string. Instead, it returns a new string reference.
```java
String str = "Hello";
str.concat(" World"); // Does not change 'str'
System.out.println(str); // Output: Hello

str = str.concat(" World"); // Assigning to reference
System.out.println(str); // Output: Hello World
```

## 2. String Pool vs. Heap Memory
To save memory, Java uses a special memory region called the **String Constant Pool (SCP)**.
- **String Literals**: When you declare a string like `String s1 = "Hello"`, Java checks the pool first. If it exists, it returns the reference. If not, it creates it in the pool.
- **Using `new` Keyword**: When you declare a string like `String s2 = new String("Hello")`, Java is forced to create a new object in the heap memory outside the pool.

```text
                  Heap Memory
         ┌───────────────────────────┐
         │                           │
         │   s2 ───► [ String Object ] ("Hello")
         │                           │
         │     String Constant Pool  │
         │    ┌──────────────────────┐
         │    │                      │
         │    │  s1 ───► ["Hello"]   │
         │    │                      │
         │    └──────────────────────┘
         └───────────────────────────┘
```
Because of this:
- `s1 == s2` is `false` (different memory references).
- `s1.equals(s2)` is `true` (same character sequence content).

---

## 3. String & Numeric Addition Rules
When using the `+` operator in Java:
1. If **both** operands are numbers, standard mathematical addition is performed.
2. If **any** operand is a String, the `+` operator is treated as concatenation, converting the non-string operand to a string.
3. Expressions are evaluated from **left to right**.

Examples:
- `10 + 20 + " Hello"` → `30 + " Hello"` → `"30 Hello"`
- `"Hello " + 10 + 20` → `"Hello 10" + 20` → `"Hello 1020"`
- `"Hello " + (10 + 20)` → `"Hello " + 30` → `"Hello 30"` (Parentheses override precedence)

---

## 4. Escape Sequences List
Java uses a backslash `\` to represent special character sequences:

| Escape Sequence | Character Represented | Example |
|---|---|---|
| `\"` | Double Quote (`"`) | `\"Hello\"` → `"Hello"` |
| `\\` | Backslash (`\`) | `C:\\Path` → `C:\Path` |
| `\'` | Single Quote (`'`) | `\'s` → `'s` |
| `\n` | Newline (Line Break) | `A\nB` → Starts B on a new line |
| `\t` | Tab (Indent space) | `Col1\tCol2` → Aligns text into columns |

---

# Code Navigation

```text
Strings
│
├── README.md                 (This Guide)
├── StringDeclaration.java    (Declaration & Immutability basics)
├── StringConcatenation.java  (Combining strings using + or concat)
├── StringComparison.java     (equals, equalsIgnoreCase, and ==)
├── StringMethods.java        (length, substring, trim, indexOf)
├── EscapeSequences.java      (Special characters like \n, \t, \", \\)
└── StringNumericAddition.java (Adding strings containing numbers)
```

---

# What to Learn Next

After mastering Strings, you can continue with:

- String Builder and String Buffer (mutable string classes)
- Exception Handling
- Collections Framework
- Object-Oriented Programming (OOP)

---

# Support

If you found this guide helpful, consider giving the repository a **Star**! Your support is highly appreciated.
