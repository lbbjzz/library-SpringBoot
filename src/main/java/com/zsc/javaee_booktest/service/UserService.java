package com.zsc.javaee_booktest.service;

import com.zsc.javaee_booktest.entity.Authority;
import com.zsc.javaee_booktest.entity.User;

import java.util.List;

public interface UserService {
    public List<Authority> getAuthorityByUserName(String userName);
}
