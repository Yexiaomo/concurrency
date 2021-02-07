package com.fxb.concurrency.example.cache;

import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;

@Component
public class RedisClient {
    @Resource(name = "redisPool")
    private JedisPool jedisPool;

    public void set(String key, String value){
        Jedis jedis = null;
        try{
            jedis = jedisPool.getResource();
            jedis.set(key, value);
        }finally {
            if(jedis != null){
                jedis.close();
            }
        }
    }

    public String get(String key){
        Jedis jedis = null;
        String value;
        try{
            jedis = jedisPool.getResource();
            value = jedis.get(key);
        }finally {
            if(jedis != null){
                jedis.close();
            }
        }
        return value;
    }
}
