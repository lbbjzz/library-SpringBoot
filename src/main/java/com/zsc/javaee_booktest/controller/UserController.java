package com.zsc.javaee_booktest.controller;

import com.zsc.javaee_booktest.entity.User;
import com.zsc.javaee_booktest.repository.UserRepository;
import com.zsc.javaee_booktest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/list")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

//    @RequestMapping(value = "/list",method = RequestMethod.GET)
//    public List<User> getUserEntity()
//    {
//        return userJPA.findAll();
//    }
    @GetMapping("/getUser")
    public User getUser(){
        return userService.getUser();
    }

    @RequestMapping(value = "/save",method = RequestMethod.PUT)
    public String update(@RequestBody User user)
    {
        User result = userService.saveWithEncoding(user);
        if(result != null){
            return "success";
        } else {
            return "fail";
        }
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public void delete(@PathVariable int id)
    {
        userService.deleteById(id);
    }

    @RequestMapping(value = "/resetPwd")
    public void resetPwd(@RequestBody User user) {
        userService.resetPwd(user.getId(), user.getPassword());
    }

    @RequestMapping(value = "/activeUser/{id}",method = RequestMethod.GET)
    public void activeUser(@PathVariable int id) {
        userService.activeUser(id);
    }

    @RequestMapping(value = "/deActiveUser/{id}",method = RequestMethod.GET)
    public void deActiveUser(@PathVariable int id) {
       userService.deActiveUser(id);
    }
}
