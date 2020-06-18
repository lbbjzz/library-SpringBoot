package com.zsc.javaee_booktest.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "persistent_logins")
@Data
public class PersistentLogin {
    @Column(nullable = false)
    private String username;
    @Id
    @Column(nullable = false)
    private String series;
    @Column(nullable = false)
    private String token;
    @Column(nullable = false)
    private Date lastUsed;
}