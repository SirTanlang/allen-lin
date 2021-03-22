package com.allen.service.impl;

import com.allen.entity.User;
import com.allen.service.UserOperation;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author tanla
 * @version 1.0
 * @description todo
 * @date 2021/1/23 23:10
 **/
@Service
public class UserOperationImpl implements UserOperation {

    private final RedisTemplate<String, String> redisTemplate;

    public UserOperationImpl(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public User registerUser(String userName,String passWord) {
        redisTemplate.opsForValue().setIfAbsent(userName,passWord);
        String s = redisTemplate.opsForValue().get(userName);
        System.out.println(s);
        return new User();
    }

    @Async
    void sayHello() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Hello!");
    }

    @Async
    void sayGoodBye(){
        System.out.println("GoodBye!");
    }

}
