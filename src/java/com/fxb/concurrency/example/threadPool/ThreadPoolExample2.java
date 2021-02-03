package com.fxb.concurrency.example.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample2 {
    public static void main(String[] args) {
        final ExecutorService exec = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int _i =  i;
            exec.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("task:"+ _i);
                }
            });
        }
        exec.shutdown();
    }
}
