package com.example.springredisexample;

import com.example.springredisexample.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.time.LocalDateTime;

@SpringBootTest
class UserTest {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    @Test
    void saveUserToRedis() {
        User user = User.builder()
                .username("john_doe")
                .email("asdf")
                .createdAt(LocalDateTime.now())
                .build();

        redisTemplate.opsForValue().set("user:1", user.getUsername());
    }

}