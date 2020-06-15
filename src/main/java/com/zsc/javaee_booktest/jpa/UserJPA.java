package com.zsc.javaee_booktest.jpa;

import com.zsc.javaee_booktest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJPA extends JpaRepository<User, Integer> {
}
