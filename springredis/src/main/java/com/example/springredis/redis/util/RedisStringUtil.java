package com.example.springredis.redis.util;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author ljh
 * @date 2019-11-26 10:05
 */
@Component
public class RedisStringUtil {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;


    public Set<String> keys(String keys) {
        try {
            return redisTemplate.keys(keys);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 普通缓存存入
     *
     * @param key
     * @param value
     * @return
     */
    public boolean set(String key, Object value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 普通缓存存入
     *
     * @param key
     * @param value
     * @return
     */
    public boolean set(String key, Object value, long time, TimeUnit timeUnit) {
        try {
            redisTemplate.opsForValue().set(key, value, time, timeUnit);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 得到key
     *
     * @param key
     * @return
     */
    public Object get(String key) {
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    /**
     * 获取 key 的过期时间
     *
     * @param key
     * @return
     */
    public long getExpire(String key) {
        return redisTemplate.getExpire(key);
    }

    /**
     * 获取key是否存在
     *
     * @param key
     * @return
     */
    public boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 移除键
     *
     * @param key
     * @return
     */
    public boolean del(String key) {
        return redisTemplate.delete(key);
    }

    /**
     * 设置key
     *
     * @param key
     * @param value
     * @param offset 偏移量
     */
    public void set(String key, Object value, long offset) {
        redisTemplate.opsForValue().set(key, value, offset);
    }

    public boolean getBit(String key, long offset) {
        return redisTemplate.opsForValue().getBit(key, offset);
    }

    /**
     * 获取key 的值的长度
     *
     * @param key
     * @return
     */
    public long size(String key) {
        return redisTemplate.opsForValue().size(key);
    }

    /**
     * 返回给定 key 的旧值。 当 key 没有旧值时，即 key 不存在时，返回 nil 。
     * 当 key 存在但不是字符串类型时，返回一个错误。
     *
     * @param key
     * @param value
     * @return
     */
    public Object getAndSet(String key, Object value) {
        return redisTemplate.opsForValue().getAndSet(key, value);
    }


    public Object get(String key, long start, long end) {
        return redisTemplate.opsForValue().get(key, start, end);
    }


    public Object multiGet(String... key) {
        return redisTemplate.opsForValue().multiGet(Arrays.asList(key));
    }

    public boolean setIfAbsent(String key, String value) {
        return redisTemplate.opsForValue().setIfAbsent(key, value);
    }

    public boolean setIfPresent(String key, String value) {
        return redisTemplate.opsForValue().setIfPresent(key, value);
    }

    public long increment(String key) {
        return redisTemplate.opsForValue().increment(key);
    }

    public long decrement(String key) {
        return redisTemplate.opsForValue().decrement(key);
    }

    public Double increment(String key, Double d) {
        return redisTemplate.opsForValue().increment(key, d);
    }

    /**
     * 追加指定值之后， key 中字符串的长度。
     */
    public Integer append(String key, String value) {
        return redisTemplate.opsForValue().append(key, value);
    }
}
