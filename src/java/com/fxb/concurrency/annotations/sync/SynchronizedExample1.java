package com.fxb.concurrency.annotations.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class SynchronizedExample1 {

    //修饰代码块
    public void test1(int j){
        synchronized (this){
            for (int i = 0; i < 5; i++) {
                log.info("test1 print {}-i : {}", j, i);
            }
        }
    }
    //修饰方法
    public synchronized void test2(int j){
        for (int i = 0; i < 5; i++) {
            log.info("test2 print {}-i : {}", j, i);
        }
    }

    public static void main(String[] args) {
        SynchronizedExample1 example1 = new SynchronizedExample1();
        SynchronizedExample1 example2 = new SynchronizedExample1();
        ExecutorService executorService = Executors.newCachedThreadPool();

//        executorService.execute(example1::test1);
//        executorService.execute(example1::test2);

//        executorService.execute(()->{
//            example1.test1(1);
//        });
//        executorService.execute(()->{
//            example2.test1(2);
//        });

        executorService.execute(()->{
            example1.test2(1);
        });
        executorService.execute(()->{
            example2.test2(2);
        });
    }
}
