package com.fxb.concurrency.example.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionExample {
    public static void main(String[] args) {
        final ReentrantLock reentrantLock = new ReentrantLock();
        final Condition condition = reentrantLock.newCondition();
        new Thread(()->{
            try {
                reentrantLock.lock();
                System.out.println("wait single ");// step1
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("get single ");// step4
            reentrantLock.unlock();
            System.out.println("thread1 end!");
        }).start();

        new Thread(()->{
            try {
                reentrantLock.lock();
                System.out.println("get lock");// step2
               Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            condition.signal();
            System.out.println("send single ");// step3
            reentrantLock.unlock();
            System.out.println("thread2 end!");
        }).start();
    }
}
