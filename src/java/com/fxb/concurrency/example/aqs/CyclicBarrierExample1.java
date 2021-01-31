package com.fxb.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
@Slf4j
public class CyclicBarrierExample1 {

    public static void main(String[] args) {
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
        final ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 15; i++) {
            final int threadNum = i;
            exec.execute(()->{
                try {
                    log.info("{} is ready", threadNum);
                    cyclicBarrier.await();
                    log.info("{} is continue", threadNum);
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
        exec.shutdown();
    }
}
