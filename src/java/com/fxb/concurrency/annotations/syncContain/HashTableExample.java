package com.fxb.concurrency.annotations.syncContain;

import com.fxb.concurrency.annotations.NotThreadSafe;
import com.fxb.concurrency.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@Slf4j
@ThreadSafe
public class HashTableExample {
    private final static int clientTotal = 5000;
    private final static int threadTotal = 200;
    private static Map<Integer, Integer> map = new Hashtable<>();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            final int _i = i;
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    update(_i);
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("size : {}", map.size());
    }

    private static void update(int _i) {
        map.put(_i,_i);
    }
}

