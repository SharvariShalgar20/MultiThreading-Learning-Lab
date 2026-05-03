package com.sharvari.threadVsRunnable;

public class ThreadVsRunnable {

    public static void main(String[] args) {

        //Thread with extending Thread class
        Thread t1 = new MyThread();

        //Thread with implementing Runnable interface
        Runnable runnable = new MyRunnable();
        Thread t2 = new Thread(runnable);

        t1.start();
        t2.start();

    }
}
