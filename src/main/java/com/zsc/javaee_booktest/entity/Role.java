package com.zsc.javaee_booktest.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "t_user_authority")
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "authority_id")
    private int authorityId;
}
