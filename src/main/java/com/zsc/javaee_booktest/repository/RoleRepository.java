package com.zsc.javaee_booktest.repository;

import com.zsc.javaee_booktest.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
