package com.fxb.concurrency.annotations.concurrent;

import com.fxb.concurrency.annotations.NotThreadSafe;
import com.fxb.concurrency.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@Slf4j
@ThreadSafe
public class CopyOnWriteArrayListExample {
    private final static int clientTotal = 5000;
    private final static int threadTotal = 200;
    private static List<Integer> arrayList = new CopyOnWriteArrayList<>();

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
        log.info("size : {}", arrayList.size());
    }

    private static void update(int _i) {
        arrayList.add(_i);
    }
}

