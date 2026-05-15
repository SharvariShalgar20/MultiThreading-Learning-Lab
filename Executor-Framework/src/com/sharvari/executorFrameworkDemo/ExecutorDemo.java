package com.sharvari.executorFrameworkDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorDemo {

    public static void main(String[] args) throws InterruptedException {
        // Fixed pool of 3 threads handling 6 tasks
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 6; i++) {
            int taskId = i;
            executor.execute(() -> {
                System.out.println("Task " + taskId + " running on " + Thread.currentThread().getName());
                try { Thread.sleep(500); } catch (InterruptedException e) {}
                System.out.println("Task " + taskId + " done");
            });
        }

        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println("All tasks finished");
    }
}
