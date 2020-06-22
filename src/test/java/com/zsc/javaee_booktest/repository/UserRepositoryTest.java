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
    void saveWithEncoding(){
        User user = new User();
        user.setUserName("asdas");
        user.setPassword("123");
        user.setEmail("test");
        user.setSex("nan");
        user.setPhone("12312312");
        user.setAge(11);
        String msg = userService.saveWithEncoding(user);
        if(msg.equals("success")){
            System.out.println("注册成功");
        } else {
            System.out.println("该用户名已存在");
        }
    }

    @Test
    void deleteById(){
        userRepository.deleteById(4);
    }
}