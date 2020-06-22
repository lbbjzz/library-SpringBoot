package com.zsc.javaee_booktest.service;

import com.zsc.javaee_booktest.entity.Authority;
import com.zsc.javaee_booktest.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    public List<Authority> getAuthorityByUserName(String userName);
    public String saveWithEncoding(User user);
}
