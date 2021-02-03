package com.fxb.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
@Slf4j
public class ForkJoinExample extends RecursiveTask<Integer> {
    private int start;
    private int end;
    private static final int threshold = 5;

    public ForkJoinExample(int start, int end) {
        this.start = start;
        this.end = end;
    }
    @Override
    protected Integer compute() {
        int res = 0;
        if (end - start <= threshold){
            for(int i = start; i <= end; i++){
                res += i;
            }
        }else{
            int mid = (end - start) / 2 + start;
            ForkJoinExample leftForkJoin = new ForkJoinExample(start, mid);
            ForkJoinExample rightForkJoin = new ForkJoinExample(mid+1, end);
            leftForkJoin.fork();
            rightForkJoin.fork();
            res = leftForkJoin.join() + rightForkJoin.join();
        }
        return res;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final ForkJoinPool forkJoinPool = new ForkJoinPool();
        final ForkJoinExample forkJoinExample = new ForkJoinExample(1, 100);
        final ForkJoinTask<Integer> forkJoinTask = forkJoinPool.submit(forkJoinExample);
        log.info("res ： {}", forkJoinTask.get());
    }
}
