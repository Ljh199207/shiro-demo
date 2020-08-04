package com.ljh.demo.configure;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.io.IOException;

/**
 * @author ljh
 */
public class JacksonRedisSerializer<T> implements RedisSerializer<T> {

    private Class<T> clazz;

    private ObjectMapper mapper;

    JacksonRedisSerializer(Class<T> clazz) {
        this.clazz = clazz;
        mapper = new ObjectMapper();
    }

    /**
     * Serialize the given object to binary data.
     *
     * @param t object to serialize. Can be {@literal null}.
     * @return the equivalent binary data. Can be {@literal null}.
     */
    @Override
    public byte[] serialize(T t) throws SerializationException {
        try {
            return mapper.writeValueAsBytes(t);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Deserialize an object from the given binary data.
     *
     * @param bytes object binary representation. Can be {@literal null}.
     * @return the equivalent object instance. Can be {@literal null}.
     */
    @Override
    public T deserialize(byte[] bytes) throws SerializationException {
        if (bytes.length <= 0) {
            return null;
        }
        try {
            return mapper.readValue(bytes, clazz);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
