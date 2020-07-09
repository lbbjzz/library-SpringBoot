package com.zsc.javaee_booktest.service;

import com.zsc.javaee_booktest.entity.Authority;
import com.zsc.javaee_booktest.entity.Role;
import com.zsc.javaee_booktest.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService extends UserDetailsService {

    public List<Authority> getAuthorityByUserName(String userName);
    public User saveWithEncoding(User user);
    public User getUser();
    public User getById(int userId);
    public User getByUserName(String userName);
    public List<User> getAllUsers();
    public void resetPwd(int userId, String password);
    public void activeUser(int userId);
    public void deActiveUser(int userId);
    public void deleteById(int userId);
    public List<Role> getRoleByUserId(int userId);
}
