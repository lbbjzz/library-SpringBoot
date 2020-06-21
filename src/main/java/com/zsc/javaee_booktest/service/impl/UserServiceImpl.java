package com.zsc.javaee_booktest.service.impl;

import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.zsc.javaee_booktest.entity.*;
import com.zsc.javaee_booktest.repository.UserRepository;
import com.zsc.javaee_booktest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserService userService;

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

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.getByUserName(userName);
        if(user != null){
            List<Authority> authorities = userService.getAuthorityByUserName(userName);
            List<SimpleGrantedAuthority> list = authorities.stream()
                    .map(authority -> new SimpleGrantedAuthority(authority.getAuthority()))
                    .collect(Collectors.toList());
            UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                    user.getUserName(), user.getPassword(), list);
            return userDetails;
        } else{
            System.out.println("用户名不存在");
            throw new UsernameNotFoundException("当前用户不存在");
        }
    }
}
