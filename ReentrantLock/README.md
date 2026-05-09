# 04 - ReentrantLock & Lock Fairness

## What is ReentrantLock?
`ReentrantLock` is an advanced locking mechanism from `java.util.concurrent.locks`.  
It does everything `synchronized` does — plus more control.

## Basic Usage
```java
ReentrantLock lock = new ReentrantLock();

lock.lock();
try {
    // critical section
} finally {
    lock.unlock(); // always in finally!
}
```

## Why "Reentrant"?
A thread that already holds the lock can acquire it again without deadlocking itself.
```java
synchronized void outer() {
    inner(); // same thread can re-enter
}
synchronized void inner() { ... }
```

## Lock Fairness
```java
ReentrantLock lock = new ReentrantLock(true); // fair mode ON
```

| Mode | Behavior |
|---|---|
| Unfair (default) | Any waiting thread can get the lock (faster but unpredictable) |
| Fair (true) | Threads get the lock in the order they requested it (FIFO) |

## ReentrantLock vs synchronized

| Feature | synchronized | ReentrantLock |
|---|---|---|
| Fairness | No | Yes (optional) |
| Try to acquire | No | tryLock() |
| Timeout | No | tryLock(time, unit) |
| Interruptible | No | lockInterruptibly() |
| Manual unlock | No (auto) | Yes (required) |

## Key Methods
| Method | Description |
|---|---|
| lock() | Acquires the lock (blocks if unavailable) |
| unlock() | Releases the lock |
| tryLock() | Acquires lock only if available (non-blocking) |
| tryLock(time, unit) | Tries to acquire within a timeout |
| lockInterruptibly() | Acquires but can be interrupted |

## Rule of Thumb
> Use `ReentrantLock` when you need fairness, timeout, or tryLock.  
> Use `synchronized` for simple cases.