package com.zsc.javaee_booktest.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.zsc.javaee_booktest.entity.*;
import com.zsc.javaee_booktest.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    JPAQueryFactory queryFactory;

    @Autowired
    UserService userService;

    @Test
    void findByUserName() {
        System.out.println(userRepository.getByUserName("小余"));
    }

    @Test
    void getAuthorityByUserName(){
        List<Authority> authorities = userService.getAuthorityByUserName("小余");
        System.out.println(authorities);
    }

    @Test
    void EncodingTest(){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("123456"));
    }

    @Test
    void deleteById(){
        userRepository.deleteById(4);
    }

    @Test
    void update(){
        User user = userService.getById(1);
        user.setAge(20);
        System.out.println(userService.saveWithEncoding(user));
    }
}