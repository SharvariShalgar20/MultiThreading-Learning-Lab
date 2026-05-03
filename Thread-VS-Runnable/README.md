# 02 - Thread vs Runnable

## Two Ways to Create a Thread

### 1. Extending Thread class
```java
class MyThread extends Thread {
    public void run() { ... }
}
new MyThread().start();
```

### 2. Implementing Runnable (Preferred)
```java
class MyRunnable implements Runnable {
    public void run() { ... }
}
new Thread(new MyRunnable()).start();
```

### 3. Lambda (Shortest)
```java
new Thread(() -> System.out.println("Hello")).start();
```

## Why Prefer Runnable over Thread?

| Reason | Explanation |
|---|---|
| Single Inheritance | Java doesn't allow multiple inheritance. Extending Thread blocks you from extending any other class. |
| Separation of Concern | Runnable separates the task (what to do) from the thread (how to run it). |
| Reusability | Same Runnable can be passed to multiple threads or an ExecutorService. |
| Best Practice | Industry standard for defining tasks. |

## Rule of Thumb
> Use `Runnable` (or lambda) unless you specifically need to override Thread behavior.
