# Java Reflection API - A Comprehensive Guide

Reflection in Java is a powerful feature that allows an executing Java program to examine, inspect, and modify the runtime behavior of applications. It is widely used in enterprise frameworks like Spring, Hibernate, JUnit, and Jackson to perform tasks dynamically without hardcoding class names, methods, or fields.

---

## 1. What is Java Reflection?
By default, Java is a strongly typed, static language where type checking happens at compile time. However, Reflection enables **dynamic inspection** of classes, interfaces, fields, methods, constructors, and annotations at runtime, even if they are declared `private` or are unknown at compile time.

### Why use Reflection?
- **Framework Development**: Allows frameworks to instantiate user-defined classes and inject dependencies (e.g., Spring's `@Autowired`).
- **Development Tools**: IDEs use reflection to auto-complete methods, lists of fields, etc.
- **Serialization/Deserialization**: Libraries like Jackson convert JSON to Java objects by discovering field names dynamically.
- **Testing**: Testing frameworks like JUnit use reflection to find and run methods annotated with `@Test`.

---

## 2. Core Reflection Classes
Java Reflection is part of the `java.lang.reflect` package. The core classes include:

| Class | Description |
| :--- | :--- |
| `java.lang.Class` | Represents a class or interface in a running Java application. The entry point for all reflection operations. |
| `java.lang.reflect.Constructor` | Represents a single constructor of a class, allowing dynamic object creation. |
| `java.lang.reflect.Field` | Represents a field (variable) of a class or interface, allowing dynamic read/write access. |
| `java.lang.reflect.Method` | Represents a method on a class or interface, enabling dynamic method invocation. |
| `java.lang.reflect.Modifier` | Provides static methods and constants to decode class and member access modifiers (e.g., `public`, `private`, `static`, `final`). |

---

## 3. Step-by-Step Concepts with Code Explanations

### A. Obtaining the `Class` Object
Before inspecting a class, you must obtain its `Class` instance. There are three ways to do this:

1. **Using `.class` Syntax (Compile-time)**:
   ```java
   Class<?> clazz = A.class;
   ```
2. **Using `getClass()` (Runtime on an instance)**:
   ```java
   A obj = new A();
   Class<?> clazz = obj.getClass();
   ```
3. **Using `Class.forName()` (Runtime on String name)**:
   ```java
   Class<?> clazz = Class.forName("A");
   ```

---

### B. Inspecting and Invoking Constructors
You can inspect constructors to find their parameters or instantiate classes dynamically.

- `getDeclaredConstructors()`: Returns all constructors, including public, protected, package, and private.
- `getConstructors()`: Returns only public constructors.
- `getDeclaredConstructor(Class<?>... parameterTypes)`: Gets a specific constructor.
- `newInstance(Object... initargs)`: Creates a new instance.

**Example: Bypassing a Private Constructor**
```java
Constructor<?> privateCons = clazz.getDeclaredConstructor(String.class, int.class, String.class);

// Force access to a private constructor
privateCons.setAccessible(true);

// Instantiate the object
A obj = (A) privateCons.newInstance("Anshu", 10, "Delhi");
```

---

### C. Inspecting and Modifying Fields
Reflection allows you to read or write field values, even private ones.

- `getDeclaredFields()`: Returns all fields (public, protected, package, private) of the class.
- `getFields()`: Returns only public fields (including inherited ones).
- `getDeclaredField(String name)`: Returns a specific field by name.
- `setAccessible(true)`: Temporarily disables Java's access check.
- `get(Object obj)`: Gets the field value on the given object instance.
- `set(Object obj, Object value)`: Sets the field value on the given object instance.

**Example: Modifying a Private Field**
```java
Field nameField = clazz.getDeclaredField("name");
nameField.setAccessible(true); // Bypass private encapsulation

// Read value
String val = (String) nameField.get(obj); 

// Write new value
nameField.set(obj, "Nilesh");
```

---

### D. Inspecting and Invoking Methods
You can query method metadata (arguments, return types, exceptions) and invoke them dynamically.

- `getDeclaredMethods()`: Returns all methods declared in the class (excluding inherited ones).
- `getMethods()`: Returns all public methods (including inherited ones).
- `getDeclaredMethod(String name, Class<?>... parameterTypes)`: Finds a specific method.
- `invoke(Object obj, Object... args)`: Invokes the method on the target object with arguments. Pass `null` as the first argument if the method is static.

**Example: Invoking Private and Static Methods**
```java
// 1. Invoking a public method with parameters
Method updateMethod = clazz.getDeclaredMethod("updateInfo", String.class, int.class);
updateMethod.invoke(obj, "Karan", 25);

// 2. Invoking a private method with no parameters
Method showMethod = clazz.getDeclaredMethod("show");
showMethod.setAccessible(true);
showMethod.invoke(obj);

// 3. Invoking a static method (no instance object needed; pass null)
Method countMethod = clazz.getDeclaredMethod("getObjectCount");
int count = (Integer) countMethod.invoke(null);
```

---

### E. Decoding Modifiers
All reflected elements (`Class`, `Field`, `Method`, `Constructor`) have a `getModifiers()` method. This returns an integer representing modifier flags. Use the `Modifier` class to read them:
```java
int modifiers = clazz.getModifiers();
boolean isPublic = Modifier.isPublic(modifiers);
boolean isStatic = Modifier.isStatic(modifiers);
String allModifiers = Modifier.toString(modifiers); // e.g. "public static final"
```

---

## 4. Key API Methods Reference Table

| Method Name | Return Type | Purpose / Description |
| :--- | :--- | :--- |
| `getName()` | `String` | Returns the fully qualified name of the class (e.g., `java.lang.String`). |
| `getSimpleName()` | `String` | Returns the class name without package prefix (e.g., `String`). |
| `getModifiers()` | `int` | Returns modifier flags (encoded as an integer) for the class or member. |
| `getSuperclass()` | `Class<?>` | Returns the superclass of the current class. |
| `getInterfaces()` | `Class<?>[]` | Returns an array of interfaces implemented by the class. |
| `setAccessible(boolean flag)` | `void` | Enables (`true`) or disables (`false`) Java access control checks for fields/methods/constructors. |
| `newInstance(Object... args)` | `T` | *Deprecated in Java 9+ on Class level* (use `Constructor.newInstance` instead) to instantiate objects. |

---

## 5. Drawbacks and Limitations of Reflection

Although reflection is highly flexible, it should be used with caution due to the following drawbacks:

1. **Performance Overhead**:
   Reflection involves dynamic resolution (searching classes, matching signatures), which is significantly slower than direct Java bytecode execution. JVM optimizations (like JIT compilation) cannot optimize reflective operations as effectively.
2. **Security Restrictions**:
   A `SecurityManager` at runtime might block reflection activities, particularly modifying private states or bypassing standard access constraints.
3. **Encapsulation Breakdown**:
   Using `setAccessible(true)` breaches OOP encapsulation principles. Internal implementation details are exposed, making code fragile when upgrading library versions where internal details might change.
4. **Lack of Compile-time Type Safety**:
   Since methods and constructors are looked up using String names and dynamic types, typos or type mismatches will trigger runtime exceptions (`NoSuchMethodException`, `IllegalAccessException`, etc.) instead of compile-time errors.
