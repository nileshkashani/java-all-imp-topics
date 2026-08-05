# 16. JVM Basics

Java Virtual Machine (JVM) is the engine that drives Java code execution. To understand how Java works, you must understand the components of the runtime environment: **JDK, JRE, JVM**, the memory structure (**Stack vs. Heap**), and **Garbage Collection**.

---

## 📌 Directory Navigation
- 📄 [JVMMemoryDemo.java](file:///c:/Users/Owner/desktop1/Next%20js/java0toHero/JVM%20Basics/JVMMemoryDemo.java) — Core Java code illustrating Stack memory, Heap memory, and Garbage Collection.

---

## 1. JDK vs. JRE vs. JVM

To write and run Java applications, we need tools that are grouped into three primary acronyms: **JDK**, **JRE**, and **JVM**.

```
+-------------------------------------------------------------+
| JDK (Java Development Kit)                                 |
|  - Compilers (javac)                                        |
|  - Debuggers, Javadoc, Jar packaging tools                  |
|                                                             |
|  +-------------------------------------------------------+  |
|  | JRE (Java Runtime Environment)                        |  |
|  |  - Standard Class Libraries (java.lang, java.util...) |  |
|  |  - Other support files                                |  |
|  |                                                       |  |
|  |  +-------------------------------------------------+  |  |
|  |  | JVM (Java Virtual Machine)                      |  |  |
|  |  |  - Execution Engine                             |  |  |
|  |  |  - Memory Areas (Stack, Heap, Method Area...)   |  |  |
|  |  +-------------------------------------------------+  |  |
|  +-------------------------------------------------------+  |
+-------------------------------------------------------------+
```

### 🧩 JVM (Java Virtual Machine)
* **What it is:** The heart of the Java platform. It is an abstract computing machine that runs compiled Java bytecode (`.class` files).
* **Role:** It compiles bytecode to native machine code at runtime (using the JIT - Just-In-Time Compiler) and executes it on the physical hardware.

### 📦 JRE (Java Runtime Environment)
* **What it is:** The software package that provides the libraries and resources needed to *run* a Java application.
* **Role:** It contains the JVM along with the core Java Class Libraries (e.g. math, collections, utilities). It does **not** contain development tools like a compiler.

### 🛠️ JDK (Java Development Kit)
* **What it is:** The full developer tool suite.
* **Role:** It contains everything in the JRE, plus compiler tools (like `javac`), debugging tools, documentation tools (`javadoc`), and packaging tools (`jar`) required to *write* and compile Java programs.

---

## 2. JVM Memory Structure: Stack vs. Heap

JVM splits the memory allocated to a Java program into several runtime data areas. The two most important memory regions for developers are the **Stack** and the **Heap**.

| Feature | Stack Memory | Heap Memory |
| :--- | :--- | :--- |
| **Purpose** | Stores local primitive variables and method call frames. | Stores all dynamically created objects and instance variables. |
| **Allocation** | LIFO (Last-In-First-Out) order per thread. | Arbitrary allocation throughout the whole application. |
| **Visibility** | Thread-private (each thread has its own Stack). | Globally shared (all threads access the same Heap). |
| **Lifetime** | Temporary (exists only while the method executes). | Exists until the object has no references and is garbage collected. |
| **Speed** | Extremely fast. | Slower than Stack due to dynamic allocation/lookup. |
| **Errors** | `java.lang.StackOverflowError` (e.g., deep recursion). | `java.lang.OutOfMemoryError` (Heap is full of objects). |

### Memory Allocation Workflow in Code
We demonstrate the memory differences in [JVMMemoryDemo.java](file:///c:/Users/Owner/desktop1/Next%20js/java0toHero/JVM%20Basics/JVMMemoryDemo.java):

1. **Stack Allocation (Primitives):**
   ```java
   int age = 25;
   ```
   Since `age` is a local primitive variable, its actual value (`25`) is stored directly on the Stack frame.
   * **Code Reference:** See [JVMMemoryDemo.java:L23](file:///c:/Users/Owner/desktop1/Next%20js/java0toHero/JVM%20Basics/JVMMemoryDemo.java#L23).

2. **Heap & Stack Allocation (Objects):**
   ```java
   Person p1 = new Person("Nilesh");
   ```
   Here, two things happen:
   * The actual `Person` object is created dynamically on the **Heap**.
   * A reference variable `p1` (holding the address of the Heap object) is created on the **Stack**.
   * **Code Reference:** See [JVMMemoryDemo.java:L30-31](file:///c:/Users/Owner/desktop1/Next%20js/java0toHero/JVM%20Basics/JVMMemoryDemo.java#L30-L31).

3. **Method Stack Frames (Method calls):**
   When `createTemporaryObject()` is called, a new Stack frame is pushed. A local object `tempPerson` is created. When the method finishes execution, its Stack frame is popped off. The object `"Karan"` is left on the Heap without any reference pointing to it.
   * **Code Reference:** See [JVMMemoryDemo.java:L60-70](file:///c:/Users/Owner/desktop1/Next%20js/java0toHero/JVM%20Basics/JVMMemoryDemo.java#L60-L70).

---

## 3. Garbage Collection (GC)

In older languages like C/C++, developers must manually allocate and deallocate memory. Java uses **Garbage Collection (GC)** to automatically manage memory, preventing memory leaks and freeing developers from manual cleanup.

### How Garbage Collection Works
1. **Unreachable Objects:** The JVM garbage collector automatically tracks which objects on the Heap are still in use (reachable). If an object has no references pointing to it, it is considered unreachable (dead).
2. **Mark and Sweep:**
   * **Mark:** The GC starts from "GC Roots" (active thread variables, static variables, etc.) and marks all reachable objects.
   * **Sweep:** The GC scans the Heap and sweeps away (reclaims memory from) all unmarked/unreachable objects.

### How to Make Objects Eligible for GC
An object becomes eligible for garbage collection when it can no longer be reached by the running application. We show this in two ways in our code:

* **Setting Reference to Null:**
  ```java
  p1 = null; // Nilesh object becomes unreachable and eligible for GC
  ```
  * **Code Reference:** See [JVMMemoryDemo.java:L38](file:///c:/Users/Owner/desktop1/Next%20js/java0toHero/JVM%20Basics/JVMMemoryDemo.java#L38).
* **Going Out of Scope:**
  Objects created inside a method (like `tempPerson` representing `"Karan"`) lose their reference as soon as the method terminates and its stack frame is popped.
  * **Code Reference:** See [JVMMemoryDemo.java:L67-70](file:///c:/Users/Owner/desktop1/Next%20js/java0toHero/JVM%20Basics/JVMMemoryDemo.java#L67-L70).

### Explicitly Suggesting GC
We can request the JVM to run garbage collection by calling `System.gc()`.
* **Important:** This is only a **suggestion** to the JVM. The JVM chooses the best time to perform garbage collection, so `System.gc()` does not guarantee immediate reclamation.
* **Code Reference:** See [JVMMemoryDemo.java:L43](file:///c:/Users/Owner/desktop1/Next%20js/java0toHero/JVM%20Basics/JVMMemoryDemo.java#L43).
