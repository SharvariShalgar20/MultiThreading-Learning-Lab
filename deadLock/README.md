# 06 - Deadlock

## What is Deadlock?
Deadlock occurs when two or more threads are **waiting for each other's locks forever** — none can proceed.

## How It Happens
Thread-1 holds Lock-A, waiting for Lock-B

Thread-2 holds Lock-B, waiting for Lock-A

→ Both wait forever = DEADLOCK

## Four Conditions for Deadlock (all must be true)
| Condition | Meaning |
|---|---|
| Mutual Exclusion | Only one thread can hold a lock at a time |
| Hold and Wait | Thread holds one lock while waiting for another |
| No Preemption | Locks can't be forcibly taken away |
| Circular Wait | Thread-1 waits for Thread-2, Thread-2 waits for Thread-1 |

## Prevention — Fix Circular Wait
The simplest fix: **always acquire locks in the same order**.

❌ Deadlock:

Thread-1: Lock A → Lock B

Thread-2: Lock B → Lock A

✅ Fixed:

Thread-1: Lock A → Lock B

Thread-2: Lock A → Lock B  ← same order

## Other Prevention Strategies
| Strategy | How |
|---|---|
| Lock ordering | Always acquire locks in a fixed global order |
| tryLock() with timeout | Use ReentrantLock.tryLock(time) and back off if failed |
| Lock fewer resources | Minimize how many locks a thread needs at once |

