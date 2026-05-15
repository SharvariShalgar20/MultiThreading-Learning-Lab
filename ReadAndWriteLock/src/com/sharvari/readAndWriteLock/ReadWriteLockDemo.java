package com.sharvari.readAndWriteLock;

import java.util.concurrent.locks.*;

class SharedData {
    int value = 0;
    ReadWriteLock rwLock = new ReentrantReadWriteLock();

    // Multiple threads can read simultaneously
    void read(String name) {
        rwLock.readLock().lock();
        try {
            System.out.println(name + " reads: " + value);
            Thread.sleep(100);
        } catch (InterruptedException e) {}
        finally { rwLock.readLock().unlock(); }
    }

    // Only one thread can write at a time
    void write(int val) {
        rwLock.writeLock().lock();
        try {
            value = val;
            System.out.println("Written: " + val);
        } finally { rwLock.writeLock().unlock(); }
    }
}

public class ReadWriteLockDemo {
    public static void main(String[] args) {

        SharedData data = new SharedData();
        new Thread(() -> data.write(42)).start();
        new Thread(() -> data.read("Reader-1")).start();
        new Thread(() -> data.read("Reader-2")).start();

    }
}
