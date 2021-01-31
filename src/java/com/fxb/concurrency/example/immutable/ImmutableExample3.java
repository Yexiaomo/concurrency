package com.fxb.concurrency.example.immutable;

import com.fxb.concurrency.annotations.ThreadSafe;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ThreadSafe
public class ImmutableExample3 {
    private final static ImmutableList<Integer> list = ImmutableList.of(1,2,3);

    private final static ImmutableSet<Integer> set = ImmutableSet.copyOf(list);

    private final static ImmutableMap<Integer, Integer> map = ImmutableMap.of(1,1,2,2,3,3);
    private final static ImmutableMap<Integer, Integer> map2 = ImmutableMap.<Integer,Integer>builder().put(1,1).put(2,2).put(3,3).build();
    public static void main(String[] args) {
        //更新操作,编译器不会报错，但会报异常 UnsupportedOperationException
//        list.add(4);
//        set.add(4);
        System.out.println(map2.get(3));
    }

}
