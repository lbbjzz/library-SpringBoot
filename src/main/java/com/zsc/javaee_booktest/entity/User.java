package com.zsc.javaee_booktest.entity;

import com.zsc.javaee_booktest.service.UserService;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "t_user")
@Data
public class User implements UserService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String userName;
    private String password;
    private String email;
    private String sex;
    private String phone;
    private int age;
    private int valid;
}