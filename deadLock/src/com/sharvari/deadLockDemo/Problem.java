package com.sharvari.deadLockDemo;

public class Problem {
    static Object lockA = new Object();
    static Object lockB = new Object();

    Thread t1 = new Thread(() -> {
        synchronized (lockA) {
            System.out.println("T1 holds A, waiting for B...");
            try { Thread.sleep(100); } catch (InterruptedException e) {}
            synchronized (lockB) { System.out.println("T1 got B"); }
        }
    });

    Thread t2 = new Thread(() -> {
        synchronized (lockB) {                          // T2 holds B
            System.out.println("T2 holds B, waiting for A...");
            synchronized (lockA) { System.out.println("T2 got A"); } // waits for A forever
        }
    });

    public void startThreads() {
        t1.start();
        t2.start();
    }
    // Both threads wait forever — DEADLOCK!
}
