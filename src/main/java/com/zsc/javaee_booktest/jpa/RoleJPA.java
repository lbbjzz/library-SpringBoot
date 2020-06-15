package com.zsc.javaee_booktest.jpa;

import com.zsc.javaee_booktest.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleJPA extends JpaRepository<Role, Integer> {
}
