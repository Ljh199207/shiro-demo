package com.example.springredis.redis;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

/**
 * @author ljh
 * @date 2019-11-26 17:25
 */
@SpringBootTest
public class RedsiSetTests {
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void add() {
        String key = "set";
        String value = "setvalue";
        String value1 = "setvalue1";
        String value2 = "setvalue2";
        redisTemplate.opsForSet().add(key, value, value1, value2);
        System.out.println(redisTemplate.opsForSet().members(key));
    }

    @Test
    public void testSend() {
        redisTemplate.convertAndSend("TOPIC_USERNAME", "哈哈哈，redis 订阅信息");
        System.out.println("消息发送成功了");
    }
}
