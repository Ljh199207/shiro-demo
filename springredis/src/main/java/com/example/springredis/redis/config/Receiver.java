package com.example.springredis.redis.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;

/**
 * @author ljh
 * @date 2019-11-27 09:26
 */
@Component
public class Receiver {
    @Autowired
    private StringRedisTemplate redisTemplate;

    public void onMessage(String jsonMsg) {
        RedisSerializer<String> valueSerializer = redisTemplate.getStringSerializer();
        // String deserialize = valueSerializer.deserialize(message.getBody());
        System.out.println(("收到的mq消息" + jsonMsg));
    }


    public void reciveMessage(String jsonMsg) {
        RedisSerializer<String> valueSerializer = redisTemplate.getStringSerializer();
        //  String deserialize = valueSerializer.deserialize(message.getBody());
        System.out.println(("收到的mq222222消息" + jsonMsg));
    }


}
