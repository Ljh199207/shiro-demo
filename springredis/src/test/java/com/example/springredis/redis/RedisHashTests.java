package com.example.springredis.redis;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ljh
 * @date 2019-11-26 15:39
 */
@SpringBootTest
public class RedisHashTests {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void testHash() {
        String key = "key";
        String hashKey1 = "hashKey1";
        String hashKey2 = "hashKey2";
        String hashKey3 = "hashKey3";
        String value1 = "value1";
        String value2 = "value2";
        String value3 = "value3";
        redisTemplate.opsForHash().put(key, hashKey1, value1);
        redisTemplate.opsForHash().put(key, hashKey2, value2);
        redisTemplate.opsForHash().put(key, hashKey3, value3);
        Map<Object, Object> map = redisTemplate.opsForHash().entries(key);
        System.out.println(map);
    }

    @Test
    public void Testmulti() {
        //开启事务
        redisTemplate.setEnableTransactionSupport(true);
        redisTemplate.multi();
        redisTemplate.opsForValue().set("StringKey", "StringValue");
        String key = (String) redisTemplate.opsForValue().get("StringKey");
        System.out.println("key" + key);
        List<Object> exec = redisTemplate.exec();
        String key1 = (String) redisTemplate.opsForValue().get("StringKey");
        System.out.println("key1" + key1);
        exec.forEach(e -> System.out.println(e.toString()));
    }


    @Test
    public void testHashDel() {
        String key = "key";
        String hashKey1 = "hashKey1";
        String hashKey2 = "hashKey2";
        String hashKey3 = "hashKey3";
        String value1 = "value1";
        String value2 = "value2";
        String value3 = "value3";
        redisTemplate.opsForHash().delete(key);
        redisTemplate.opsForHash().put(key, hashKey1, value1);
        redisTemplate.opsForHash().put(key, hashKey2, value2);
        redisTemplate.opsForHash().put(key, hashKey3, value3);
        redisTemplate.opsForHash().delete(key, hashKey1);
        Map<Object, Object> map = redisTemplate.opsForHash().entries(key);
        System.out.println(map);
    }

    @Test
    public void hasKey() {
        String key = "key";
        String hashKey1 = "hashKey1";
        String hashKey2 = "hashKey2";
        String hashKey3 = "hashKey3";
        String value1 = "value1";
        String value2 = "value2";
        String value3 = "value3";
        //redisTemplate.opsForHash().delete(key,hashKey1,hashKey2,hashKey3);
        redisTemplate.opsForHash().put(key, hashKey1, value1);
        redisTemplate.opsForHash().put(key, hashKey2, value2);
        redisTemplate.opsForHash().put(key, hashKey3, value3);
        System.out.println(redisTemplate.opsForHash().hasKey(key, hashKey1));
    }

    @Test
    public void values() {
        String key = "key";
        String hashKey1 = "hashKey1";
        String hashKey2 = "hashKey2";
        String hashKey3 = "hashKey3";
        String value1 = "value1";
        String value2 = "value2";
        String value3 = "value3";
        redisTemplate.opsForHash().delete(key, hashKey1, hashKey2, hashKey3);
        redisTemplate.opsForHash().put(key, hashKey1, value1);
        redisTemplate.opsForHash().put(key, hashKey2, value2);
        redisTemplate.opsForHash().put(key, hashKey3, value3);
        // System.out.println(redisTemplate.opsForHash().values(key));
        System.out.println(redisTemplate.opsForHash().multiGet(key, Arrays.asList(hashKey1, hashKey2)));


    }

    @Test
    public void keys() {
        String key = "key";
        String hashKey1 = "hashKey1";
        String hashKey2 = "hashKey2";
        String hashKey3 = "hashKey3";
        String value1 = "value1";
        String value2 = "value2";
        String value3 = "value3";
        redisTemplate.opsForHash().delete(key, hashKey1, hashKey2, hashKey3);
        redisTemplate.opsForHash().put(key, hashKey1, value1);
        redisTemplate.opsForHash().put(key, hashKey2, value2);
        redisTemplate.opsForHash().put(key, hashKey3, value3);
        System.out.println(redisTemplate.opsForHash().keys(key));
        System.out.println(redisTemplate.opsForHash().size(key));
        System.out.println(redisTemplate.opsForHash().putIfAbsent(key, hashKey1, "1111"));
    }

    @Test
    public void testPutAll() {
        String key = "key";
        String hashKey1 = "hashKey1";
        String hashKey2 = "hashKey2";
        String hashKey3 = "hashKey3";
        String value1 = "value1";
        String value2 = "value2";
        String value3 = "value3";
        Map<String, Object> param = new HashMap<>();
        param.put(hashKey1, value1);
        param.put(hashKey2, value2);
        param.put(hashKey3, value3);
        redisTemplate.opsForHash().putAll(key, param);
    }


}
