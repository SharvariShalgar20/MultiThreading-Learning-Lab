# 01 - Thread Lifecycle

## What is a Thread?
A thread is the smallest unit of execution in Java. Every Java program starts with one thread — the **main thread**.

## Thread States
A thread goes through the following states during its lifetime:

NEW → RUNNABLE → (BLOCKED / WAITING / TIMED_WAITING) → TERMINATED

| State | Description |
|---|---|
| NEW | Thread created but not started yet |
| RUNNABLE | Thread is running or ready to run |
| BLOCKED | Waiting to acquire a lock |
| WAITING | Waiting indefinitely for another thread (wait()) |
| TIMED_WAITING | Waiting for a specified time (sleep(), join(timeout)) |
| TERMINATED | Thread has finished execution |

## Key Methods
| Method | Description |
|---|---|
| start() | Starts the thread (calls run() internally) |
| run() | Contains the task logic |
| sleep(ms) | Pauses thread for given milliseconds |
| join() | Waits for a thread to finish |
| getState() | Returns current state of thread |

## Important Note
- Never call run() directly — it won't create a new thread.
- Always call start() to launch a new thread.