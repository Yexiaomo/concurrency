package com.fxb.concurrency.example.threadPool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class ThreadPoolExample4 {
    public static void main(String[] args) {
        final ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5); Executors.newScheduledThreadPool(5);
        //延迟3s执行
//        scheduledExecutorService.schedule(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("run");
//            }
//        }, 3, TimeUnit.SECONDS);
        //延迟1秒后每3秒执行一次
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                log.info("running");
            }
        }, 1, 2, TimeUnit.SECONDS);
//        scheduledExecutorService.shutdown();
    }
}
