# 03 - Synchronized Keyword

## The Problem — Race Condition
When multiple threads access and modify shared data at the same time, the result becomes unpredictable.

Thread-1 reads count = 5

Thread-2 reads count = 5

Thread-1 writes count = 6

Thread-2 writes count = 6   ← increment lost!

Expected: 7, Got: 6 — this is a **race condition**.

## The Solution — synchronized
The `synchronized` keyword ensures only **one thread** can execute a block/method at a time.

```java
synchronized void increment() {
    count++; // now thread-safe
}
```

## How It Works
- Every object in Java has a built-in **monitor lock**.
- When a thread enters a synchronized method, it acquires the lock.
- Other threads trying to enter must **wait** until the lock is released.

## synchronized — Two Ways

### 1. Synchronized Method
```java
synchronized void increment() { count++; }
```

### 2. Synchronized Block (more granular)
```java
void increment() {
    synchronized(this) { count++; }
}
```

## Key Points
| Point | Detail |
|---|---|
| Lock | Acquired on the object instance (or class for static) |
| Granularity | Method-level or block-level |
| Limitation | No timeout, no fairness control |
| Performance | Can cause contention if overused |

## When to Use
Use `synchronized` when multiple threads **read and write** the same shared variable.