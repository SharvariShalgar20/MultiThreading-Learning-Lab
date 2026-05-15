package com.sharvari.deadLockDemo;

public class Solution {

    static Object lockA = new Object();
    static Object lockB = new Object();

    Thread t1 = new Thread(() -> {
        synchronized (lockA) { synchronized (lockB) { System.out.println("T1 done"); } }
    });

    Thread t2 = new Thread(() -> {
        synchronized (lockA) { // same order: A then B
            synchronized (lockB) { System.out.println("T2 done"); }
        }
    });

    public void startThreads() {
        t1.start();
        t2.start();
    }
}


