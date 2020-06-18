package com.zsc.javaee_booktest.controller;

import com.zsc.javaee_booktest.entity.User;
import com.zsc.javaee_booktest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userJPA;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<User> getUserEntity()
    {
        return userJPA.findAll();
    }

    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public User update(User user)
    {
        return userJPA.save(user);
    }

    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public List<User> delete(User user)
    {
        userJPA.delete(user);
        return userJPA.findAll();
    }
}
