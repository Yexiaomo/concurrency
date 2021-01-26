package com.fxb.concurrency.annotations.immutable;

import com.fxb.concurrency.annotations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

@Slf4j
@NotThreadSafe
public class ImmutableExample1 {
    public static final int n = 1;
    public static final String s = "abc";
    public static final int[] arr = new int[]{1,2,3};
    public static final HashMap<Integer, Integer> map = new HashMap<>();
    static {
        map.put(1,1);
        map.put(2,2);
        map.put(3,3);
    }

    public static void main(String[] args) {
//        n = 2;
//        s = "aaaa";
//        arr = null;
        arr[0] = 111;
        map.put(1, 11);
        log.info("arr[0] = {}", arr[0]);
        log.info("map(1) = {}", map.get(1));
    }

}
