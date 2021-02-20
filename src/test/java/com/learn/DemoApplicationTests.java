package com.learn;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learn.bean.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void contextLoads() throws JsonProcessingException {
        ValueOperations ops = redisTemplate.opsForValue();
        User user=new User("学习spring-boot-redis",27);
        String jsonUser=new ObjectMapper().writeValueAsString(user);
        ops.set("user",user);
        System.out.println(ops.get("user"));
    }

}
