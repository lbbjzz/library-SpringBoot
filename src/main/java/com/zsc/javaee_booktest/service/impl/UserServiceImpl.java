package com.zsc.javaee_booktest.service.impl;

import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.zsc.javaee_booktest.entity.*;
import com.zsc.javaee_booktest.repository.UserRepository;
import com.zsc.javaee_booktest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    JPAQueryFactory queryFactory;

    QAuthority qAuthority = QAuthority.authority1;
    QRole qRole = QRole.role;
    QUser qUser = QUser.user;

    @Override
    public List<Authority> getAuthorityByUserName(String userName) {
        Predicate predicate = qUser.userName.eq(userName);
        List<Authority> authorities = queryFactory.select(qAuthority)
                .from(qRole)
                .leftJoin(qUser)
                .on(qRole.userId.eq(qUser.id))
                .leftJoin(qAuthority)
                .on(qRole.authorityId.eq(qAuthority.id))
                .where(predicate)
                .fetch();
        return authorities;
    }
}
