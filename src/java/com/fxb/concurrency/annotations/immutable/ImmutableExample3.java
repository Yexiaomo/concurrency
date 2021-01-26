package com.fxb.concurrency.annotations.immutable;

import com.fxb.concurrency.annotations.ThreadSafe;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.Map;

@Slf4j
@ThreadSafe
public class ImmutableExample3 {
    public static Map<Integer, Integer> map = Maps.newHashMap();
    static {
        map.put(1,1);
        map.put(2,2);
        map.put(3,3);
        map = Collections.unmodifiableMap(map);
    }

    public static void main(String[] args) {
        //更新操作不会报错，但会报异常 UnsupportedOperationException
        map.put(1, 111);
        log.info("map(1) = {}", map.get(1));
    }

}
