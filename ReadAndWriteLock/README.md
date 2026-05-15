# 05 - ReadWriteLock

## The Problem
Using `synchronized` or `ReentrantLock` for reads is wasteful.  
**Reading doesn't modify data** — multiple threads can safely read at the same time.

## The Solution — ReadWriteLock
`ReadWriteLock` has two locks:
- **Read Lock** — Multiple threads can hold it simultaneously
- **Write Lock** — Only one thread can hold it, and no readers allowed

```java
ReadWriteLock rwLock = new ReentrantReadWriteLock();

// Reading
rwLock.readLock().lock();
try { /* read data */ }
finally { rwLock.readLock().unlock(); }

// Writing
rwLock.writeLock().lock();
try { /* write data */ }
finally { rwLock.writeLock().unlock(); }
```

## Lock Compatibility Table

| | Read Lock | Write Lock |
|---|---|---|
| Read Lock | ✅ Allowed | ❌ Blocked |
| Write Lock | ❌ Blocked | ❌ Blocked |

## When to Use
| Scenario | Best Choice |
|---|---|
| Mostly reads, rare writes | ReadWriteLock ✅ |
| Equal reads and writes | ReentrantLock |
| Simple single operation | synchronized |

## Key Points
- Use when your data is **read frequently but written rarely** (e.g., config, cache).
- Writer gets **exclusive access** — no readers or other writers allowed.
- Readers can all run **in parallel** as long as no writer is active.

## Real World Example
> A configuration object read by 100 threads but updated only once an hour — perfect for ReadWriteLock.