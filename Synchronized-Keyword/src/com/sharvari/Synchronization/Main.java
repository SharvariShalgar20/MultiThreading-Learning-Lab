package com.sharvari.Synchronization;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        SynchProblem c = new SynchProblem();
        Thread t1 = new Thread(() -> { for (int i = 0; i < 1000; i++) c.increment(); });
        Thread t2 = new Thread(() -> { for (int i = 0; i < 1000; i++) c.increment(); });
        t1.start(); t2.start();
        t1.join(); t2.join();
        System.out.println("Expected: 2000, Got: " + c.count); // Often wrong!

        SynchSolution c1 = new SynchSolution(); //added Synchronized Keyword
        Thread t3 = new Thread(() -> { for (int i = 0; i < 1000; i++) c1.increment(); });
        Thread t4 = new Thread(() -> { for (int i = 0; i < 1000; i++) c1.increment(); });
        t3.start(); t4.start();
        t3.join(); t4.join();
        System.out.println("Expected: 2000, Got: " + c1.count1);  // count will always be 2000!

    }
}
