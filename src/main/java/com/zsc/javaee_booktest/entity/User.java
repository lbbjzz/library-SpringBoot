package com.zsc.javaee_booktest.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "t_user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "sex")
    private String sex;

    @Column(name = "phone")
    private String phone;

    @Column(name = "age")
    private int age;

    @Column(name = "valid")
    private int valid;
}