package com.fxb.concurrency.example.lock;

import com.fxb.concurrency.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Slf4j
@ThreadSafe
public class ReentrantReadWriteLockExample {

    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private static Lock readLock = readWriteLock.readLock();
    private static Lock writeLock = readWriteLock.writeLock();

    private static Map<String, Data> map = new HashMap<>();

    public Data get(String key){
        readLock.lock();
        try {
            return map.get(key);
        }finally {
            readLock.unlock();
        }
    }
    public Set<String> getKeys(){
        readLock.lock();
        try {
            return map.keySet();
        }finally {
            readLock.unlock();
        }
    }
    public Data put(String key, Data val){
        writeLock.lock();
        try {
            return map.put(key, val);
        }finally {
            writeLock.unlock();
        }
    }



    public static void main(String[] args) {
        log.info("{}", map.put("1", new Data()));
    }
}
class Data{

}