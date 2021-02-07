package com.fxb.concurrency.example.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/cache")
public class CacheController {
    @Autowired
    private RedisClient redisClient;

    @RequestMapping("/set")
    @ResponseBody
    public String get(@RequestParam("key") String key, @RequestParam("value") String value){
        redisClient.set(key, value);
        return "SUCCESS";
    }
    @RequestMapping("/get")
    @ResponseBody
    public String get(@RequestParam("key") String key){
        return redisClient.get(key);
    }
}
