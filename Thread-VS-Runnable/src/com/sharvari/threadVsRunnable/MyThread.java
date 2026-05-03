package com.sharvari.threadVsRunnable;

public class MyThread extends Thread{

    public void run() {
        System.out.println("Thread class: " + Thread.currentThread().getName());
    }
}
