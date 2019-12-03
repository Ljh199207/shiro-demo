package com.example.springredis.redis.util;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author ljh
 * @date 2019-11-26 15:38
 */
@Component
public class RedisHashUtil {
    @Resource
    private RedisTemplate<String, Object> redisTemplate;



}
