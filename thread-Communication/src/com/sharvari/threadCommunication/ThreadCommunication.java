package com.sharvari.threadCommunication;

class SharedBox {
    int item = 0;
    boolean hasItem = false;

    synchronized void produce(int val) throws InterruptedException {
        while (hasItem) wait();         // wait if box is full
        item = val;
        hasItem = true;
        System.out.println("Produced: " + val);
        notify();                       // wake up consumer
    }

    synchronized void consume() throws InterruptedException {
        while (!hasItem) wait();        // wait if box is empty
        System.out.println("Consumed: " + item);
        hasItem = false;
        notify();                       // wake up producer
    }
}

public class ThreadCommunication {
    public static void main(String[] args) {

        SharedBox box = new SharedBox();
        new Thread(() -> {
            try { for (int i = 1; i <= 3; i++) box.produce(i); }
            catch (InterruptedException e) {}
        }).start();

        new Thread(() -> {
            try { for (int i = 1; i <= 3; i++) box.consume(); }
            catch (InterruptedException e) {}
        }).start();
    }
}
