package com.sharvari.threadLifeCycle;

public class ThreadLifeCycle {
    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(() -> {
            System.out.println("RUNNING");
            try { Thread.sleep(500); } catch (InterruptedException e) {}
            System.out.println("TERMINATING");
        });

        System.out.println("State after creation: " + t.getState());   // NEW
        t.start();
        System.out.println("State after start: " + t.getState());       // RUNNABLE
        Thread.sleep(100);
        System.out.println("State while sleeping: " + t.getState());    // TIMED_WAITING
        t.join();
        System.out.println("State after finish: " + t.getState());      // TERMINATED
    }
}
