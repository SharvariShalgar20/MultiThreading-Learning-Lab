# 07 - Thread Communication (wait / notify)

## The Problem
Sometimes threads need to **coordinate** — one thread produces data, another consumes it.  
Without coordination, the consumer may run before data is ready.

## The Solution — wait() and notify()
These methods allow threads to communicate through a shared object.

| Method | Description |
|---|---|
| wait() | Releases the lock and pauses the thread until notified |
| notify() | Wakes up one waiting thread |
| notifyAll() | Wakes up all waiting threads |

## Rules — Must Know
- All three methods must be called **inside a synchronized block/method**.
- They are called on the **shared object** (the lock), not the thread.
- Always use `while` (not `if`) to check the condition after waking up.

## Pattern
```java
// Waiting thread
synchronized(lock) {
    while (!conditionMet) {
        lock.wait();        // releases lock, waits
    }
    // proceed
}

// Notifying thread
synchronized(lock) {
    conditionMet = true;
    lock.notify();          // wakes up waiting thread
}
```

## Why while and not if?
```java
// WRONG
if (!hasItem) wait();   // may wake up spuriously, condition may still be false

// CORRECT
while (!hasItem) wait(); // always re-check after waking up
```

## wait() vs sleep()

| | wait() | sleep() |
|---|---|---|
| Releases lock? | ✅ Yes | ❌ No |
| Called on | Object | Thread |
| Woken by | notify() | timeout only |
| Must be synchronized? | ✅ Yes | ❌ No |

## Rule of Thumb
> Use `wait/notify` for producer-consumer style coordination.  
> Use `sleep` only when you want to pause for a fixed time.