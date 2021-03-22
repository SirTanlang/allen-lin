package com.allen.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.Serializable;

/**
 * @author tanla
 * @version 1.0
 * @description todo
 * @date 2021/3/7 10:40
 **/
@Configuration
public class RedisCacheConfig {
    @Bean
    public RedisTemplate<String, Serializable> redisTemplate() {
        RedisTemplate<String, Serializable> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(new LettuceConnectionFactory());
        return redisTemplate;
    }
}
