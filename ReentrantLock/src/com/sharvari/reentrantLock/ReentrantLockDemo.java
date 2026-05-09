package com.sharvari.reentrantLock;

import java.util.concurrent.locks.ReentrantLock;

class Counter {
    int count = 0;
    // fair=true → threads get lock in order they requested (FIFO)
    ReentrantLock lock = new ReentrantLock(true);

    void increment() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock(); // always unlock in finally!
        }
    }
}

public class ReentrantLockDemo {
    public static void main(String[] args) throws InterruptedException{

        Counter c = new Counter();
        Thread t1 = new Thread(() -> { for (int i = 0; i < 1000; i++) c.increment(); });
        Thread t2 = new Thread(() -> { for (int i = 0; i < 1000; i++) c.increment(); });
        t1.start(); t2.start();
        t1.join(); t2.join();
        System.out.println("Count: " + c.count); // 2000
    }
}
