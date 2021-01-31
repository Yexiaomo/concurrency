package com.fxb.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class CyclicBarrierExample2 {
    final static CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

    public static void main(String[] args) {
        final ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 15; i++) {
            final int threadNum = i;
            exec.execute(()->{
                try {
                    test(threadNum);
                } catch (Exception e) {
                    log.error("{}",e);
                }
            });
        }
        exec.shutdown();
    }

    private static void test(int threadNum) throws InterruptedException {
        Thread.sleep(1000);
        log.info("{} is ready", threadNum);
        try {
            cyclicBarrier.await(200, TimeUnit.MILLISECONDS);
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        log.info("{} is continue", threadNum);
    }
}
