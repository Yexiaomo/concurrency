package com.fxb.concurrency.example.atomic;

import com.fxb.concurrency.annotations.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

@Slf4j
@ThreadSafe
public class AtomicExample5 {
    @Getter
    private  volatile int count = 5;
    private static AtomicIntegerFieldUpdater<AtomicExample5> updater = AtomicIntegerFieldUpdater.newUpdater(AtomicExample5.class,"count");
    private static AtomicExample5 atomicExample5 = new AtomicExample5();
    public static void main(String[] args) {
        if(updater.compareAndSet(atomicExample5,5, 55)){
            log.info("1 update success, count: {}",atomicExample5.getCount());
        }
        if(updater.compareAndSet(atomicExample5,5, 55)){
            log.info("2 update success, count: {}",atomicExample5.getCount());
        }else{
            log.info("3 update failed, count: {}",atomicExample5.getCount());
        }
    }
}
