# 08 - Executor Framework

## What is the Executor Framework?
Managing threads manually (new Thread().start()) is fine for small programs.
But in real applications, creating a new thread for every task is expensive and uncontrollable.

The Executor Framework (java.util.concurrent) solves this by managing threads for you.

## The Problem with Manual Threads
new Thread(task1).start();

new Thread(task2).start();

new Thread(task3).start();

// 1000 tasks = 1000 threads = OutOfMemoryError

## Core Interfaces

| Interface | Description |
|---|---|
| Executor | Basic interface — just execute(Runnable) |
| ExecutorService | Adds lifecycle management (shutdown, submit, invokeAll) |
| ScheduledExecutorService | Adds scheduling (run after delay, run periodically) |

## Creating Executors — Factory Methods (Executors class)

| Method | Description |
|---|---|
| Executors.newFixedThreadPool(n) | Fixed number of threads |
| Executors.newCachedThreadPool() | Creates threads as needed, reuses idle ones |
| Executors.newSingleThreadExecutor() | Single thread, tasks run sequentially |
| Executors.newScheduledThreadPool(n) | For delayed or periodic tasks |

## Basic Usage
```java
ExecutorService executor = Executors.newFixedThreadPool(3);

executor.execute(() -> System.out.println("Task 1 - " + Thread.currentThread().getName()));
executor.execute(() -> System.out.println("Task 2 - " + Thread.currentThread().getName()));
executor.execute(() -> System.out.println("Task 3 - " + Thread.currentThread().getName()));

executor.shutdown(); // gracefully stop after completing tasks
```

## Lifecycle Methods

| Method | Description |
|---|---|
| execute(Runnable) | Fire and forget — no return value |
| submit(Callable) | Returns a Future to get result later |
| shutdown() | Stop accepting new tasks, finish existing ones |
| shutdownNow() | Try to stop all running tasks immediately |
| awaitTermination(time, unit) | Wait for all tasks to finish after shutdown |
| isShutdown() | Returns true if shutdown was called |
| isTerminated() | Returns true if all tasks finished after shutdown |

## Rule of Thumb
> Never use new Thread() in production code.
> Always use ExecutorService to manage threads.