package com.zsc.javaee_booktest.service.impl;

import com.zsc.javaee_booktest.repository.UserRepository;
import com.zsc.javaee_booktest.service.UserDetailService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailServiceImpl implements UserDetailService {
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
