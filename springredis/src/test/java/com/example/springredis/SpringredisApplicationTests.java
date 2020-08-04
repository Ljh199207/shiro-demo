package com.example.springredis;

import com.example.springredis.redis.util.RedisStringUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class SpringredisApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private RedisStringUtil redisUtil;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;


    @Test
    public void testString() {
        String value = "redis";
        boolean runoobkey = redisUtil.set("runoobkey", value);
        System.out.println(runoobkey);
    }

    @Test
    public void testGet() {
        String key = "runoobkey";
        String value = "redis";
        redisUtil.set(key, value);
        System.out.println(redisUtil.get(key, 2, 3));
    }

    @Test
    public void testTimeString() {
        String value = "redisTime";
        boolean runoobkey = redisUtil.set("time", value, 50, TimeUnit.SECONDS);
        System.out.println(runoobkey);
    }

    @Test
    public void testExpire() {
        String key = "time";
        if (redisUtil.hasKey(key)) {
            long time = redisUtil.getExpire(key);
            System.out.println(time);
        }
    }

    @Test
    public void testDel() {
        String key = "runoobkey";
        boolean de = redisUtil.del(key);
        System.out.println(de);
    }

    @Test
    public void testSetoffet() {
        String key = "runoobkey";
        String value = "redis";
        redisUtil.del(key);
        redisUtil.set(key, value, 4);
        System.out.println(redisUtil.get(key));
    }

    @Test
    public void testGetBit() {
        String key = "runoobkey";
        String value = "redis";
        redisUtil.del(key);
        redisUtil.set(key, value);
        System.out.println(redisUtil.getBit(key, 2));
    }

    @Test
    public void testSize() {
        String key = "runoobkey";
        String value = "redis";
        redisUtil.del(key);
        redisUtil.set(key, value);
        System.out.println(redisUtil.size(key));
    }

    @Test
    public void testSetAndGet() {
        String key = "runoobkey";
        String olevalue = "redisOld";
        String newvalue = "redisnew";
        redisUtil.del(key);
        //  redisUtil.set(key, olevalue);
        System.out.println(redisUtil.getAndSet(key, newvalue));
    }

    @Test
    public void testMulitGet() {
        String[] keys = {"runoobkey", "key1", "key2"};
        String value = "value";
        for (String key : keys) {
            redisUtil.set(key, value);
        }
        System.out.println(redisUtil.multiGet(keys));
    }

    @Test
    public void testSetIfAbsent() {
        String key = "runoobkey";
        String value = "redis";
        redisUtil.del(key);
        // redisUtil.set(key,value);
        System.out.println(redisUtil.setIfAbsent(key, value));
    }

    @Test
    public void setIfPresent() {
        String key = "runoobkey";
        String value = "redis";
        redisUtil.del(key);
        redisUtil.set(key, value);
        System.out.println(redisUtil.setIfPresent(key, value));
    }

    @Test
    public void testIncremement() {
        String key = "runoobkey";
        String value = "100";
        redisUtil.set(key, value);
        System.out.println(redisUtil.increment(key));
    }

    @Test
    public void testIncremement2() {
        String key = "runoobkey";
        String value = "100";
        redisUtil.set(key, value);
        System.out.println(redisUtil.increment(key, 2.5D));
    }

    @Test
    public void testappend() {
        String key = "runoobkey";
        String value = "100";
        String append = "append";
        redisUtil.set(key, value);
        redisUtil.append(key, append);
        System.out.println(redisUtil.get(key));
    }

}
