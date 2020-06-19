package com.zsc.javaee_booktest.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.zsc.javaee_booktest.entity.Authority;
import com.zsc.javaee_booktest.entity.QAuthority;
import com.zsc.javaee_booktest.entity.QRole;
import com.zsc.javaee_booktest.entity.QUser;
import com.zsc.javaee_booktest.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
}