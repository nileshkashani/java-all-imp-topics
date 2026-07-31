# Java Collections Framework

Welcome!

This repository is a beginner-friendly guide to the **Java Collections Framework (JCF)**. Every collection class and interface is explained using simple language and accompanied by clean, well-commented code.

Whether you're learning Java for the first time, preparing for interviews, revising for college exams, or getting ready for Spring Boot development, these examples will help you understand Java's most commonly used data structures.

---

# What is the Java Collections Framework?

The **Java Collections Framework (JCF)** is a set of built-in **interfaces** and **classes** that provides efficient ways to store, manage, and manipulate groups of objects.

Instead of creating your own data structures from scratch, Java provides ready-to-use implementations like **ArrayList**, **HashMap**, **HashSet**, and many more.

The Collections Framework is mainly divided into three interfaces:

```text
Collections Framework
│
├── List
│   ├── ArrayList
│   └── LinkedList
│
├── Map
│   ├── HashMap
│   ├── LinkedHashMap
│   └── TreeMap
│
└── Set
    ├── HashSet
    ├── LinkedHashSet
    └── TreeSet
```

---

# Topics Covered

| Topic | What You'll Learn | Code |
|-------|-------------------|------|
| **ArrayList** | Learn how dynamic arrays work in Java. Understand automatic resizing, indexing, insertion, deletion, searching, iteration, sorting, and commonly used methods. Best suited when fast random access is required. | [View Code](./List/ArrayListCollection.java) |
| **LinkedList** | Learn how elements are connected using nodes. Understand efficient insertion and deletion, queue/deque operations, and when LinkedList performs better than ArrayList. | [View Code](./List/LinkedListCollection.java) |
| **HashMap** | Learn how Java stores data as key-value pairs using hashing. Understand insertion, retrieval, updating, deletion, iteration, and handling duplicate keys. | [View Code](./Map/HashMapCollection.java) |
| **LinkedHashMap** | Learn how LinkedHashMap maintains insertion order while providing fast key-value lookups. Understand ordered iteration and common use cases. | [View Code](./Map/LinkedHashMapCollection.java) |
| **TreeMap** | Learn how TreeMap automatically stores keys in sorted order using a Red-Black Tree. Understand sorting, navigation methods, and ordered maps. | [View Code](./Map/TreeMapCollection.java) |
| **HashSet** | Learn how HashSet stores only unique elements using hashing. Understand duplicate removal, searching, iteration, and common set operations. | [View Code](./Set/HashSetCollection.java) |
| **LinkedHashSet** | Learn how LinkedHashSet maintains insertion order while ensuring uniqueness. Ideal when both uniqueness and predictable iteration order are required. | [View Code](./Set/LinkedHashSetCollection.java) |
| **TreeSet** | Learn how TreeSet automatically stores unique elements in sorted order. Understand sorting, navigation methods, and ordered set operations. | [View Code](./Set/TreeSetCollection.java) |

---

# Collections Overview

| Interface / Class | Description | Ordering | Duplicates | Null Values | Best Use Case |
|-------------------|-------------|----------|------------|-------------|---------------|
| **List** | An ordered collection that stores elements by index. | Maintains insertion order | Allowed | Allowed | When element order and index-based access are required. |
| **ArrayList** | Dynamic array implementation of List with fast random access. | Maintains insertion order | Allowed | Allowed | Frequent read operations and random access. |
| **LinkedList** | Doubly linked list implementation with efficient insertions and deletions. | Maintains insertion order | Allowed | Allowed | Frequent insertions and deletions. |
| **Set** | Collection that stores only unique elements. | Depends on implementation | Not Allowed | Depends on implementation | When duplicate elements should be avoided. |
| **HashSet** | Hash table implementation of Set with no guaranteed order. | No ordering | Not Allowed | One null allowed | Fast searching and duplicate removal. |
| **LinkedHashSet** | HashSet that preserves insertion order. | Maintains insertion order | Not Allowed | One null allowed | Unique elements with predictable iteration order. |
| **TreeSet** | Red-Black Tree implementation that keeps elements sorted. | Sorted order | Not Allowed | Null not allowed | Automatically sorted unique elements. |
| **Map** | Stores data as key-value pairs where keys are unique. | Depends on implementation | Duplicate keys not allowed | Depends on implementation | Mapping keys to values. |
| **HashMap** | Hash table implementation of Map with fast lookups. | No ordering | Duplicate keys not allowed | One null key and multiple null values | General-purpose key-value storage. |
| **LinkedHashMap** | HashMap that maintains insertion order. | Maintains insertion order | Duplicate keys not allowed | One null key and multiple null values | Ordered key-value storage. |
| **TreeMap** | Red-Black Tree implementation that stores keys in sorted order. | Sorted by keys | Duplicate keys not allowed | Null keys not allowed | Sorted maps and range-based operations. |

---

# Code Navigation

```text
Collections Framework
│
├── List
│   ├── ArrayListCollection.java
│   └── LinkedListCollection.java
│
├── Map
│   ├── HashMapCollection.java
│   ├── LinkedHashMapCollection.java
│   └── TreeMapCollection.java
│
└── Set
    ├── HashSetCollection.java
    ├── LinkedHashSetCollection.java
    └── TreeSetCollection.java
```

---

# List vs Set vs Map

| Feature | List | Set | Map |
|---------|------|-----|-----|
| Stores | Elements | Unique Elements | Key-Value Pairs |
| Duplicate Elements | Allowed | Not Allowed | Duplicate Keys Not Allowed |
| Maintains Order | Yes | Depends on Implementation | Depends on Implementation |
| Index Based | Yes | No | No |
| Null Values | Allowed | Depends on Implementation | Depends on Implementation |

---

# Why Learn the Collections Framework?

Understanding the Collections Framework is important because it helps you write code that is:

- Efficient
- Reusable
- Easy to Maintain
- Optimized for Performance
- Scalable
- Suitable for Real-World Applications

The Collections Framework is one of the most frequently asked topics in Java interviews and is heavily used in Spring Boot, Hibernate, and enterprise Java applications.

---

# Who Is This Repository For?

This repository is suitable for:

- Java Beginners
- College Students
- Placement Preparation
- Interview Preparation
- Spring Boot Learners
- Anyone revising Java fundamentals

---

# What to Learn Next

After completing the Collections Framework, you can continue with:

- Exception Handling
- File Handling
- Multithreading
- Generics
- Streams API
- Lambda Expressions
- JDBC
- Java 8 Features
- Spring Boot

---

# Support

If you found this repository helpful, consider giving it a **Star**.

Your support motivates the development of more beginner-friendly Java learning resources.