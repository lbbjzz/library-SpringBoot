package com.zsc.javaee_booktest.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "t_authority")
@Data
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String authority;
}