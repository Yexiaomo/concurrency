package com.fxb.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class FutureExample  {
    static class MyCallable implements Callable<String>{

        @Override
        public String call() throws Exception {
            log.info("do something in Callable");
            Thread.sleep(5000);
            return "done";
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final ExecutorService exec = Executors.newCachedThreadPool();
        final Future<String> future = exec.submit(new MyCallable());
        log.info("do something in main");
        Thread.sleep(1000);
        log.info("result: {}", future.get());
        exec.shutdown();
    }
}
